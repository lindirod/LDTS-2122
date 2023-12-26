package state;

import blocks.Element;
import control.*;

import control.movement.Gravity;
import control.movement.Movement;
import control.movement.Push;
import control.level.Level;
import gui.Color;
import gui.LanternaGUI.Lanterna;

import java.io.IOException;
import java.util.ArrayList;

import static control.Collision.CheckCollisionList;

public class PlayState extends OptionState {
    Controller controller;
    Option option;
    Lanterna lanterna;
    static Level currentlevel;
    Element SquareElement;
    int keys = 0;
    Color colorSelect;


    public static boolean ative;
    static ArrayList<Element> blocks;
    public static RelativePositionScreen relativePositionScreen;



    public PlayState(Controller controller, Lanterna lanterna) throws IOException { //B3F6A5
        this.lanterna = lanterna;
        option = new Option();
        this.controller = controller;
        colorSelect = new Color(StoreState.getColorSelect());
        SquareElement = new Element(new Position(20, 31), colorSelect.getColor().get("BodySquare"), colorSelect.getColor().get("FaceSquare"), "src/main/resources/Blocks_ascii-art/BodySquarePlayer", SquareFace());
        currentlevel = new Level();
        blocks = currentlevel.getBlocks();
        relativePositionScreen = new RelativePositionScreen();
        relativePositionScreen.StartCounting(this);
        ative = true;
    }


    @Override
    public void draw() throws IOException { //"#0D1F80"
        lanterna.background(colorSelect.getColor().get("Background"));
        lanterna.PlaydrawSquare(SquareElement);

        drawBlocksLevel();
        lanterna.drawKeys(keys,currentlevel,colorSelect.getColor().get("Background"));
        lanterna.refresh();
    }


    @Override
    public int run() throws IOException {
        Movement gravity = new Gravity();
        gravity.doMovement(SquareElement, this);

        Movement push = new Push();
        push.doMovement(SquareElement,this);

        int flag = lanterna.PlayProcessKey(SquareElement, this);

        if(flag == 1) {
            ative = false;
        }else if(flag == 2){
             flag=0;
            ative=false;
            GoMenu();
        }else if(flag==3){
            flag=0;
            ative = false;
        }
        return flag;
    }

    public void GoMenu() throws IOException {
        this.controller.ChangeState(new MenuOptionState(this.controller, lanterna));
    }

    public void GameOver() throws IOException {
        this.controller.ChangeState(new GameOverState(this.controller,lanterna));
    }

    public static void setnLevel(int nlevel){
        currentlevel = new Level(nlevel);
    }

    public void drawBlocksLevel() throws IOException {
        if (currentlevel.getLevel() == 1) {
            currentlevel.draw(1, lanterna);
        }else if (currentlevel.getLevel() == 2) {
            currentlevel.draw(2, lanterna);
        }else if (currentlevel.getLevel() == 3) {
            currentlevel.draw(3, lanterna);
        }
    }

    public static int Collision (Element e){
        ArrayList<Element> collisionList = CheckCollisionList(e, blocks);

        if (collisionList.isEmpty()) {
            return 0;
        }
        for(Element element : collisionList){
            switch (element.getFaceFilename()) {
                case "src/main/resources/Blocks_ascii-art/Peak" -> {
                    ative = false;
                    return 2;
                }case "src/main/resources/Extra_ascii-art/keys" -> {
                    blocks.remove(element);
                    return 3;
                }case "src/main/resources/Blocks_ascii-art/FinalPiece" -> {
                    ative = false;
                    return 4;
                }case "src/main/resources/Extra_ascii-art/PowerUp_Winning" -> {
                    blocks.remove(element);
                    return 5;
                }case "src/main/resources/Extra_ascii-art/DoubleKeys" -> {
                    blocks.remove(element);
                    return 6;
                }
            }
        }
        return 1;
    }

    public void FinalMode() throws IOException {
        if(keys >= Level.keysMax()) {
            this.controller.ChangeState(new WinningState(this.controller, lanterna));
        }else {
            this.controller.ChangeState(new LosingState(this.controller, lanterna));
        }
    }

    public void PowerUp() throws IOException {
        ative = false;
        this.controller.ChangeState(new WinningState(this.controller, lanterna));
    }

    public void GetKeys(int n) {
        if(n == 3) {
            keys++;
        }else if(n == 6){
            keys += 2;
        }
    }

    public String SquareFace(){
        int val = StoreState.getSquareSelect();
        switch (val){
            case 1 ->{
                return "src/main/resources/Differents-SquarePlayer_ascii-art/Face1-SquarePlayer";
            }case 2 ->{
                return "src/main/resources/Differents-SquarePlayer_ascii-art/Face2-SquarePlayer";
            }case 3 ->{
                return "src/main/resources/Differents-SquarePlayer_ascii-art/Face3-SquarePlayer";
            } case 4 ->{
                return "src/main/resources/Differents-SquarePlayer_ascii-art/Face4-SquarePlayer";
            }
        }
        return "src/main/resources/Blocks_ascii-art/FaceSquarePlayer";
    }

}