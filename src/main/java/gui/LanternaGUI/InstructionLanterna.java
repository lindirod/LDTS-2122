package gui.LanternaGUI;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import control.Position;

import java.io.IOException;

import static com.googlecode.lanterna.input.KeyType.EOF;
import static com.googlecode.lanterna.input.KeyType.Escape;

public class InstructionLanterna {
    Screen screen;

    public InstructionLanterna(Screen screen) {
        this.screen = screen;
    }

    public void InstructiondrawText(Position position, String RectColor, String textColor) {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString(RectColor));

        graphics.fillRectangle(new TerminalPosition(47, 17), new TerminalSize(70, 20), ' ');

        graphics.setForegroundColor(TextColor.Factory.fromString(textColor));

        graphics.enableModifiers(SGR.BOLD);

        graphics.putString(new TerminalPosition(position.getX() + 5, position.getY()), "ENTER ");
        graphics.putString(new TerminalPosition(position.getX() + 5, position.getY() + 2), "Q     ");
        graphics.putString(new TerminalPosition(position.getX() + 5, position.getY() + 4), "SPACE");
        graphics.putString(new TerminalPosition(position.getX() + 5, position.getY() + 6), "ARROWS");

        graphics.disableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX() + 15, position.getY()), "\t\tChoose an option");
        graphics.putString(new TerminalPosition(position.getX() + 15, position.getY() + 2), "\t\tQuit");
        graphics.putString(new TerminalPosition(position.getX() + 15, position.getY() + 4), "\t\tJump");
        graphics.putString(new TerminalPosition(position.getX() + 15, position.getY() + 6), "\t\tMove");
        graphics.putString(new TerminalPosition(position.getX() + 6, position.getY() + 11), "Press ESC to go back");
    }

    public int InstructionProcessKey() throws IOException {
        KeyStroke key = screen.readInput();
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') {
            screen.close();
        }
        if (key.getKeyType() == EOF) {
            return 1;
        }
        if (key.getKeyType() == Escape) {
            return 2;
        }
        return 0;
    }
}