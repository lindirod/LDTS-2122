package control.level;

import blocks.Element;
import control.Position;
import gui.Color;
import gui.LanternaGUI.Lanterna;
import state.PlayState;
import state.StoreState;

import java.io.IOException;
import java.util.ArrayList;

public class Level {
    static int level=0;
    ArrayList<Element> blocks;
    ArrayList<Position> positionsArray;
    Color colorSelect;

    public Level(){
        if(level== 0){
            level=1;
        }
        addBlocks();
    }

    public Level(int level) {
        Level.level = level;
        addBlocks();
    }

    public static int keysMax() {
        if (level == 1)
            return 3;
        else if (level == 2)
            return 6;
        else if (level == 3)
            return 9;
        return -1;
    }

    public LevelController LevelControllerFactory(){
        if(level==1)
            return new LevelController(new Level1());
        else if(level==2)
            return new LevelController(new Level2());
        else if(level == 3)
            return new LevelController(new Level3());
        return new LevelController(new Level1());
    }

    public void addBlocks(){
        blocks = new ArrayList<>();
        colorSelect = new Color(StoreState.getColorSelect());

        LevelController levelController = LevelControllerFactory();

        //ground
        positionsArray=levelController.Ground();
        for (Position p : positionsArray) {
            blocks.add(new Element(p,colorSelect.getColor().get("Ground") , colorSelect.getColor().get("Ground"), "src/main/resources/Blocks_ascii-art/GroundBlock", "src/main/resources/Blocks_ascii-art/GroundBlock"));
        }

        //Brick
        positionsArray=levelController.Brick();
        for (Position p : positionsArray) {
            blocks.add(new Element(p, colorSelect.getColor().get("BodyBricks"), colorSelect.getColor().get("FaceBricks"), "src/main/resources/Blocks_ascii-art/BodySquarePlayer", "src/main/resources/Blocks_ascii-art/Brick"));
        }

        //Peak
        positionsArray=levelController.Peak();
        for(Position p : positionsArray){
            blocks.add(new Element(p,"#A41623","#A41623","src/main/resources/Blocks_ascii-art/Peak","src/main/resources/Blocks_ascii-art/Peak"));
        }

        //Keys
        positionsArray=levelController.Key();
        for (Position p : positionsArray) {
            blocks.add(new Element(p, "#0D1F80", "#FFBA08", "src/main/resources/Extra_ascii-art/keys", "src/main/resources/Extra_ascii-art/keys"));
        }

        //Final Piece
        positionsArray=levelController.FinalPiece();
        for (Position p : positionsArray) { //#0D1F80","#AB5489"
            blocks.add(new Element(p, colorSelect.getColor().get("Background"), colorSelect.getColor().get("Final"), "src/main/resources/Blocks_ascii-art/FinalPiece", "src/main/resources/Blocks_ascii-art/FinalPiece"));
        }

        positionsArray=levelController.DoubleKeys();
        for(Position p : positionsArray){
            blocks.add(new Element(p, "#D5BBB1", "#AF3E4D", "src/main/resources/Blocks_ascii-art/BodySquarePlayer", "src/main/resources/Extra_ascii-art/DoubleKeys"));
        }

        positionsArray=levelController.PowerUp();
        for(Position p : positionsArray){
            blocks.add(new Element(p, "#0D1F80", "#9CC4B2", "src/main/resources/Extra_ascii-art/PowerUp_Winning", "src/main/resources/Extra_ascii-art/PowerUp_Winning"));
        }

    }


    public ArrayList<Element> getBlocks() {
        return blocks;
    }

    public int getLevel(){
        return level;
    }

    public void draw(int currentLevel, Lanterna lanterna) throws IOException {
        if (currentLevel == 1) {
            for (Element e : blocks) {
                lanterna.PlaydrawElement(e, PlayState.relativePositionScreen.getRelativePosition());
            }
        } else if (currentLevel == 2) {
            for (Element e : blocks) {
                lanterna.PlaydrawElement(e, PlayState.relativePositionScreen.getRelativePosition());
            }
        } else if (currentLevel == 3) {
            for (Element e : blocks) {
                lanterna.PlaydrawElement(e, PlayState.relativePositionScreen.getRelativePosition());
            }
        }
    }
}