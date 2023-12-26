package gui.LanternaGUI;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import control.Position;
import gui.Image;

import java.io.IOException;

import static com.googlecode.lanterna.input.KeyType.*;

public class GameOverLanterna {
    Screen screen;

    public GameOverLanterna(Screen screen) {
        this.screen = screen;
    }

    public void drawGameOver() throws IOException {
        Position position = new Position(63, 21);


        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#040926"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#A41623"));
        graphics.fill(' ');

        graphics.enableModifiers(SGR.ITALIC);
        graphics.enableModifiers(SGR.BLINK);
        graphics.putString(new TerminalPosition(position.getX() + 40, position.getY() + 20), "[PRESS ENTER TO CONTINUE.]");
        Image image = new Image(graphics,"src/main/resources/Extra_ascii-art/game_over", new Position(45, 20), "#A41623");
    }


    public int GameOverProcessKey() throws IOException {
        KeyStroke key = screen.readInput();
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') {
            screen.close();
        }
        else if (key.getKeyType() == EOF) {
            return 1;
        }
        else if (key.getKeyType() == Escape) {
            return 2;
        }
        else if (key.getKeyType() == Enter) {
            return 3;
        }
        return 0;
    }

}