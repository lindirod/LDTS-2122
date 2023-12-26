package gui.LanternaGUI;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import control.Option;
import control.Position;
import gui.Color;
import gui.Image;
import state.StoreState;

import java.io.IOException;

public class StoreLanterna {
    Screen screen;

    public StoreLanterna(Screen screen) {
        this.screen = screen;
    }
    public void StoredrawText(Position position, String RectColor, String TextColor){
        TextGraphics graphics = screen.newTextGraphics();

        graphics.setBackgroundColor(com.googlecode.lanterna.TextColor.Factory.fromString(RectColor));
        graphics.fillRectangle(new TerminalPosition(40,15), new TerminalSize(90,25), ' ');
        graphics.setForegroundColor(com.googlecode.lanterna.TextColor.Factory.fromString(TextColor));

        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX() - 15, position.getY()-4), "Colors");
        graphics.putString(new TerminalPosition(position.getX() + 18, position.getY()-4),"Squares");

        graphics.enableModifiers(SGR.ITALIC);
        graphics.enableModifiers(SGR.BLINK);
        graphics.putString(new TerminalPosition(position.getX()+31,position.getY()+17),"[Press ENTER to choose an option.]");
    }
    public void StoredrawColor(){
        drawPalete(new Color(1), new Position(48,20));
        drawPalete(new Color(2), new Position(48,25));
        drawPalete(new Color(3), new Position(48,30));
        drawPalete(new Color(4), new Position(48,35));
    }

    public void drawPalete(Color color, Position position){
        TextGraphics graphics = screen.newTextGraphics();
        //color 1
        drawColors(color, position, graphics, "BodySquare", 0);
        //color 2
        drawColors(color, position, graphics, "FaceSquare", 4);
        //color 3
        drawColors(color, position, graphics, "BodyBricks", 8);
        //color 4
        drawColors(color, position, graphics, "FaceSquare", 12);
        //color 5
        drawColors(color, position, graphics, "Background", 16);
        //color 6
        drawColors(color, position, graphics, "Ground", 20);
        //color 7
        drawColors(color, position, graphics, "Final", 24);
    }

    private void drawColors(Color color, Position position, TextGraphics graphics, String name, int number) {
        graphics.setBackgroundColor(TextColor.Factory.fromString(color.getColor().get(name)));
        graphics.fillRectangle(new TerminalPosition(position.getX()+number, position.getY()), new TerminalSize(4,2), ' ');
    }

    public void StoredrawSquares(Position position) throws IOException {
        drawImage("src/main/resources/Differents-SquarePlayer_ascii-art/Face1-SquarePlayer", new Position(position.getX(), position.getY()+1), "#040926");
        drawImage("src/main/resources/Differents-SquarePlayer_ascii-art/Face2-SquarePlayer", new Position(position.getX()+24, position.getY()+1), "#040926");
        drawImage("src/main/resources/Differents-SquarePlayer_ascii-art/Face3-SquarePlayer", new Position(position.getX(), position.getY()+10), "#040926");
        drawImage("src/main/resources/Differents-SquarePlayer_ascii-art/Face4-SquarePlayer", new Position(position.getX()+24, position.getY()+10), "#040926");

    }
    public void drawImage(String filename, Position position, String color) throws IOException {
        TextGraphics graphics = screen.newTextGraphics();
        Image image = new Image(graphics, filename, position, color);
    }

    public void StoredrawPrice(Position position) {
        TextGraphics graphics = screen.newTextGraphics();

        graphics.setBackgroundColor(com.googlecode.lanterna.TextColor.Factory.fromString("#336699"));
        graphics.setForegroundColor(com.googlecode.lanterna.TextColor.Factory.fromString("#040926"));

        graphics.enableModifiers(SGR.BOLD);
        if(!StoreState.ColoreSelled[0])
            graphics.putString(new TerminalPosition(position.getX()-33, position.getY()), "100 $");
        if(!StoreState.ColoreSelled[1])
            graphics.putString(new TerminalPosition(position.getX()-33, position.getY()+5),"200 $");
        if(!StoreState.ColoreSelled[2])
            graphics.putString(new TerminalPosition(position.getX()-33, position.getY()+10), "400 $");
        if(!StoreState.ColoreSelled[3])
            graphics.putString(new TerminalPosition(position.getX()-33, position.getY()+15),"700 $");

        if(!StoreState.SquareSelled[0])
            graphics.putString(new TerminalPosition(position.getX(), position.getY()), "100 $");
        if(!StoreState.SquareSelled[1])
            graphics.putString(new TerminalPosition(position.getX()+24, position.getY()),"200 $");
        if(!StoreState.SquareSelled[2])
            graphics.putString(new TerminalPosition(position.getX(), position.getY()+10), "400 $");
        if(!StoreState.SquareSelled[3])
            graphics.putString(new TerminalPosition(position.getX()+24, position.getY()+10),"700 $");

    }
    public void StoredrawOptions(int option) throws IOException {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(com.googlecode.lanterna.TextColor.Factory.fromString("#336699"));
        graphics.setForegroundColor(com.googlecode.lanterna.TextColor.Factory.fromString("#A41623"));
        Position position = new Position(82,19);

        graphics.enableModifiers(SGR.BOLD);

        if (option == 1) { //color 1
            graphics.putString(new TerminalPosition(position.getX()-38, position.getY()+1),"--\\");
            graphics.putString(new TerminalPosition(position.getX()-38, position.getY()+2),"--/");

        } else if (option == 2) { //color 2
            graphics.putString(new TerminalPosition(position.getX()-38, position.getY()+6),"--\\");
            graphics.putString(new TerminalPosition(position.getX()-38, position.getY()+7),"--/");

        } else if (option == 3) { //color 3
            graphics.putString(new TerminalPosition(position.getX() - 38, position.getY() + 11), "--\\");
            graphics.putString(new TerminalPosition(position.getX() - 38, position.getY() + 12), "--/");

        }else if (option == 4) { //color 4
            graphics.putString(new TerminalPosition(position.getX()-38, position.getY()+16),"--\\");
            graphics.putString(new TerminalPosition(position.getX()-38, position.getY()+17),"--/");

        }else if (option == 11) { //Square 1
            drawImage("src/main/resources/Differents-SquarePlayer_ascii-art/Face1-SquarePlayer", new Position(position.getX(), position.getY()+1), "#A41623");
        }else if (option == 12) { //Square 2
            drawImage("src/main/resources/Differents-SquarePlayer_ascii-art/Face2-SquarePlayer", new Position(position.getX()+24, position.getY()+1), "#A41623");
        }else if (option == 13) { //Square 3
            drawImage("src/main/resources/Differents-SquarePlayer_ascii-art/Face3-SquarePlayer", new Position(position.getX(), position.getY()+10), "#A41623");
        }else if (option == 14) { //Square 4
            drawImage("src/main/resources/Differents-SquarePlayer_ascii-art/Face4-SquarePlayer", new Position(position.getX()+24, position.getY()+10), "#A41623");
        }
    }

    public int StoreProcessKey(Option currentOption) throws IOException{
        TextGraphics graphics = screen.newTextGraphics();

        KeyStroke key = screen.readInput();
        switch (key.getKeyType()){
            case Character -> {
                if ( key.getCharacter() == 'q')
                    screen.close();
            } case EOF -> {
                return 1;
            } case Escape ->  {
                return 2;
            } case ArrowUp -> {
                if((currentOption.getOption()!=1 && currentOption.getOption()>=1 && currentOption.getOption()<=4) || (currentOption.getOption()!=11 && currentOption.getOption()>=11 && currentOption.getOption()<=14))
                    currentOption.setOption(currentOption.getOption() - 1);
            } case ArrowDown -> {
                if((currentOption.getOption()!=4 && currentOption.getOption()>=1 && currentOption.getOption()<=4) || (currentOption.getOption()!=14 && currentOption.getOption()>=11 && currentOption.getOption()<=14))
                    currentOption.setOption(currentOption.getOption() + 1);
            } case ArrowRight -> {
                if((currentOption.getOption() >= 1) && (currentOption.getOption() <= 4))
                    currentOption.setOption(11);
            } case ArrowLeft -> {
                if((currentOption.getOption() >= 11) && (currentOption.getOption() <= 14))
                    currentOption.setOption(1);
            } case Enter -> {
                return currentOption.getOption()+10;
            }
        }
        return 0;
    }

    public void drawMoney(){
        TextGraphics graphics = screen.newTextGraphics();
        Position position = new Position(125,13);

        graphics.setBackgroundColor(com.googlecode.lanterna.TextColor.Factory.fromString("#040926"));
        graphics.setForegroundColor(com.googlecode.lanterna.TextColor.Factory.fromString("#336699"));
        graphics.putString(new TerminalPosition(position.getX(), position.getY()),StoreState.getMoney() + " $");

    }

    public int StoreMensager(int can){
        if(can == 1){
            TextGraphics graphics = screen.newTextGraphics();
            Position position = new Position(71,44);

            graphics.setBackgroundColor(com.googlecode.lanterna.TextColor.Factory.fromString("#040926"));
            graphics.setForegroundColor(com.googlecode.lanterna.TextColor.Factory.fromString("#336699"));
            graphics.putString(new TerminalPosition(position.getX(), position.getY()),"You don't have enough money");
            return 0;
        } else if(can==2){
            TextGraphics graphics = screen.newTextGraphics();
            Position position = new Position(82,44);

            graphics.setBackgroundColor(com.googlecode.lanterna.TextColor.Factory.fromString("#040926"));
            graphics.setForegroundColor(com.googlecode.lanterna.TextColor.Factory.fromString("#336699"));
            graphics.putString(new TerminalPosition(position.getX(), position.getY()),"Select");
            return 0;
        }
        return can;

    }
}