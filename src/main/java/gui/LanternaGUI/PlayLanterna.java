package gui.LanternaGUI;

import blocks.Element;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import control.movement.Jump;
import control.movement.Left;
import control.movement.Movement;
import control.movement.Right;
import control.Position;
import control.level.Level;
import gui.Image;
import state.PlayState;

import java.io.IOException;

public class PlayLanterna {
    Screen screen;
    int width;
    int height;

    public PlayLanterna(Screen screen, int width, int height) {
        this.screen = screen;
        this.width=width;
        this.height=height;
    }
    public int PlayProcessKey(Element SquareElement, PlayState playState) throws IOException {
        KeyStroke key = screen.pollInput();
        if(key==null) return 0;

        switch (key.getKeyType()){
            case Character -> {
                if(key.getCharacter() == 'q'){
                    screen.close();
                    return 3;
                } else if (key.getCharacter() == ' ') {
                    Movement jump1 = new Jump();
                    jump1.doMovement(SquareElement, playState);
                }
            } case EOF -> {
                return 1;
            } case ArrowLeft -> {
                if (SquareElement.getPosition().getX() > 0) {
                    Movement left = new Left();
                    left.doMovement(SquareElement, playState);
                }
            } case ArrowRight -> {
                if (SquareElement.getPosition().getX() < 148) {
                    Movement right = new Right();
                    right.doMovement(SquareElement, playState);
                }
            } case Escape -> {
                return 2;
            }
        }

        return 0;
    }

    public void PlaydrawSquare(Element element) throws IOException {
        TextGraphics graphics = screen.newTextGraphics();
        Image BodySquarePlayer = new Image(graphics, element.getBodyFilename(), element.getPosition(), element.getBodyColor());
        Image FaceSquarePlayer = new Image(graphics, element.getFaceFilename(), element.getPosition(), element.getFaceColor());
    }

    public void PlaydrawElement(Element element, int relativePosition) throws IOException {
        if (element.getPositionUpdate() != relativePosition) {

            Position Dposition = new Position(element.getPosition().getX() - relativePosition, element.getPosition().getY());
            element.setScreenPosition(Dposition);

            element.setPositionUpdate(relativePosition);
        }

        if (element.getScreenPosition().getX() >= -23 && element.getScreenPosition().getX() <= width + 23) {
            TextGraphics graphics = screen.newTextGraphics();
            Image BodySquarePlayer = new Image(graphics, element.getBodyFilename(), element.getScreenPosition(), element.getBodyColor());
            Image FaceSquarePlayer = new Image(graphics, element.getFaceFilename(), element.getScreenPosition(), element.getFaceColor());
        }
    }

    public void drawKeys(int keys, Level level, String color){
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString(color));
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFBA08"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(150,2), "CHAVES: " + keys + " / " + level.keysMax());
    }

}