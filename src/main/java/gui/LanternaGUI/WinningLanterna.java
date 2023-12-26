package gui.LanternaGUI;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import control.Position;
import control.level.Level;
import gui.Image;

import java.io.IOException;

import static com.googlecode.lanterna.input.KeyType.*;

public class WinningLanterna {
    Screen screen;

    public WinningLanterna(Screen screen) {
        this.screen = screen;
    }

    public void drawWin() throws IOException {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#040926"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFBA08"));
        graphics.fill(' ');
        drawImage("src/main/resources/Extra_ascii-art/win", new Position(48, 12), "#FFBA08");
        if(Level.keysMax() == 3){
            drawImage("src/main/resources/Extra_ascii-art/Coins_level1",new Position(50,25),"#FFBA08");
        } else if(Level.keysMax() == 6){
            drawImage("src/main/resources/Extra_ascii-art/Coins_level2", new Position(50,25),"#FFBA08");
        }else if(Level.keysMax() == 9){
            drawImage("src/main/resources/Extra_ascii-art/Coins_level3", new Position(50,25),"#FFBA08");
        }
        graphics.enableModifiers(SGR.BLINK);
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(100,40), "[PRESS ENTER TO CONTINUE]");
    }

    public void drawImage(String filename, Position position, String color) throws IOException {
        TextGraphics graphics = screen.newTextGraphics();
        Image image = new Image(graphics, filename, position, color);
    }

    public int WinningProcessKey() throws IOException {
        KeyStroke key = screen.readInput();
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') {
            screen.close();
        }
        if (key.getKeyType() == EOF) {
            return 1;
        }
        if (key.getKeyType() == Escape || key.getKeyType() == Enter) {
            return 2;
        }
        return 0;
    }
}