package gui.LanternaGUI;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import control.Option;
import control.Position;
import gui.Image;

import java.io.IOException;

public class MenuLanterna {
    Screen screen;

    public MenuLanterna(Screen screen) {
        this.screen = screen;
    }

    public int MenuProcessKey(Option prevOption) throws IOException {
        /* significado dos valores de return
         * 0 --> continuar normal
         * 1 --> parar a aplicação
         * 2 --> mudar para o play
         * 3 --> mudar para instructions
         * 4 --> mudar para settings
         * 5 --> mudar para store
         * */
        KeyStroke key = screen.readInput();
        switch (key.getKeyType()){
            case Character -> {
                if(key.getCharacter() == 'q')
                    screen.close();
            } case EOF -> {
                return 1;
            } case ArrowLeft -> {
                if (prevOption.getOption() != 1) {
                    prevOption.setOption(prevOption.getOption() - 1);
                }
            } case ArrowRight -> {
                if (prevOption.getOption() != 4)
                    prevOption.setOption(prevOption.getOption() + 1);
            } case Enter -> {
                if (prevOption.getOption() == 3)  return 2;
                else if (prevOption.getOption() == 2)  return 3;
                else if (prevOption.getOption() == 4)  return 4;
                else if(prevOption.getOption() == 1) return 5;
            }
        }
        return 0;
    }

    public void MenudrawOption(int option, String color) throws IOException { //color = "#A41623"
        Image image;
        TextGraphics graphics = screen.newTextGraphics();

        if (option == 1) { //Store
            image = new Image(graphics,"src/main/resources/Menu_ascii-art/small-selection-box-ascii-art", new Position(25, 27), color);
        } else if (option == 2) { //Instructions
            image = new Image(graphics,"src/main/resources/Menu_ascii-art/mediam-selection-box-ascii-art", new Position(45, 26), color);
        } else if (option == 3) { //play
            image = new Image(graphics,"src/main/resources/Menu_ascii-art/big-selection-box-ascii-art", new Position(71, 25), color);
        } else if (option == 4) { // Settings
            image = new Image(graphics,"src/main/resources/Menu_ascii-art/mediam-selection-box-ascii-art", new Position(102, 26), color);
        }
    }
}