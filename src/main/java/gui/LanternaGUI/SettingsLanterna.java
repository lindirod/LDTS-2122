package gui.LanternaGUI;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import control.Option;
import control.Position;

import java.io.IOException;

public class SettingsLanterna {
    Screen screen;

    public SettingsLanterna(Screen screen) {
        this.screen = screen;
    }

    public void SettingsdrawText(Position position, String RectColor, String TextColor) {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(com.googlecode.lanterna.TextColor.Factory.fromString(RectColor));
        graphics.fillRectangle(new TerminalPosition(40, 15), new TerminalSize(90, 25), ' ');
        graphics.setForegroundColor(com.googlecode.lanterna.TextColor.Factory.fromString(TextColor));

        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX() + 17, position.getY() - 3), "LEVELS: ");
        graphics.putString(new TerminalPosition(position.getX() - 13, position.getY() + 1), "level 1");
        graphics.putString(new TerminalPosition(position.getX() - 13, position.getY() + 6), "level 2");
        graphics.putString(new TerminalPosition(position.getX() - 13, position.getY() + 11), "level 3");

        graphics.disableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "Lowest difficulty level.");
        graphics.putString(new TerminalPosition(position.getX(), position.getY() + 1), "To complete it, you have to collect 3 keys and at the end");
        graphics.putString(new TerminalPosition(position.getX(), position.getY() + 2), "you receive a prize of 100 coins. ");

        graphics.putString(new TerminalPosition(position.getX(), position.getY() + 5), "This is the intermediate difficulty level.");
        graphics.putString(new TerminalPosition(position.getX(), position.getY() + 6), "You have to collect 6 keys to complete it and at the end");
        graphics.putString(new TerminalPosition(position.getX(), position.getY() + 7), "you receive 200 coins. ");

        graphics.putString(new TerminalPosition(position.getX(), position.getY() + 10), "Highest difficulty level.");
        graphics.putString(new TerminalPosition(position.getX(), position.getY() + 11), "You have to collect 9 keys and at the end you receive");
        graphics.putString(new TerminalPosition(position.getX(), position.getY() + 12), "a prize of 400 coins");

        graphics.putString(new TerminalPosition(position.getX() - 13, position.getY() + 15), "The coins that are collected throughout the game can be used in the shop");
        graphics.putString(new TerminalPosition(position.getX() - 7, position.getY() + 16), " to customize the game itself and the Square character.");

        graphics.enableModifiers(SGR.ITALIC);
        graphics.enableModifiers(SGR.BLINK);
        graphics.putString(new TerminalPosition(position.getX() + 30, position.getY() - 4), "[Press ENTER to choose an option.]");

    }
    public int SettingsProcessKey(Option currentOption) throws IOException {
        KeyStroke key = screen.readInput();
        switch (key.getKeyType()) {
            case Character -> {
                if (key.getCharacter() == 'q')
                    screen.close();
            }
            case EOF -> {
                return 1;
            }
            case Escape -> {
                return 2;
            }
            case ArrowUp -> {
                if (currentOption.getOption() != 1)
                    currentOption.setOption(currentOption.getOption() - 1);
            }
            case ArrowDown -> {
                if (currentOption.getOption() != 3)
                    currentOption.setOption(currentOption.getOption() + 1);
            }
            case Enter -> {
                if (currentOption.getOption() == 1) {
                    return 5;
                } else if (currentOption.getOption() == 2) {
                    return 6;
                } else if (currentOption.getOption() == 3) {
                    return 7;
                }
            }
        }
        return 0;
    }

    public void SettingsdrawOptions(int option) {
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(com.googlecode.lanterna.TextColor.Factory.fromString("#336699"));
        Position position = new Position(63, 21);
        graphics.enableModifiers(SGR.BOLD);

        if (option == 1) { //Level 1
            graphics.setForegroundColor(com.googlecode.lanterna.TextColor.Factory.fromString("#A41623"));
            graphics.putString(new TerminalPosition(position.getX() - 13, position.getY() + 1), "level 1");
        } else if (option == 2) { //Level 2
            graphics.setForegroundColor(com.googlecode.lanterna.TextColor.Factory.fromString("#A41623"));
            graphics.putString(new TerminalPosition(position.getX() - 13, position.getY() + 6), "level 2");
        } else if (option == 3) { //Level 3
            graphics.setForegroundColor(com.googlecode.lanterna.TextColor.Factory.fromString("#A41623"));
            graphics.putString(new TerminalPosition(position.getX() - 13, position.getY() + 11), "level 3");
        }
    }

}