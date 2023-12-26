package gui.LanternaGUI;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import control.Position;
import gui.Image;

import java.io.IOException;

public class LosingLanterna {
    Screen screen;

    public LosingLanterna(Screen screen) {
        this.screen = screen;
    }
    public void drawLose() throws IOException {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#040926"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#A41623"));
        graphics.fill(' ');
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(46,30), "YOU DIDN'T PICK UP ENOUGH KEYS, TRY AGAIN LOSER");
        graphics.enableModifiers(SGR.BLINK);
        graphics.putString(new TerminalPosition(107,30), "[PRESS ENTER TO CONTINUE]");
        Image image = new Image(graphics,"src/main/resources/Extra_ascii-art/lose", new Position(46, 20), "#A41623");
    }
   /* public void drawImage(String filename, Position position, String color) throws IOException {
        TextGraphics graphics = screen.newTextGraphics();
        Image image = new Image(graphics, filename, position, color);
    }
*/
}