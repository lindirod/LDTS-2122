package state;
import control.Controller;
import control.Option;
import gui.LanternaGUI.Lanterna;

import java.io.IOException;

public class MenuOptionState extends OptionState {
    Controller controller;
    Option option;
    Lanterna lanterna;

    public MenuOptionState(Controller controller, Lanterna lanterna) throws IOException {
        this.lanterna= lanterna;
        option = new Option();
        this.controller=controller;
    }

    @Override
    public void draw() throws IOException {
        lanterna.clear();
        lanterna.background("#040926");
        lanterna.drawImage("src/main/resources/Menu_ascii-art/name-game-acii-art",new control.Position(0,8), "#336699");
        lanterna.drawImage("src/main/resources/Menu_ascii-art/box-menu-ascii-art", new control.Position(25,25),"#336699");
        lanterna.MenudrawOption(option.getOption(), "#A41623");
        lanterna.refresh();
    }

    public int run() throws IOException {
        int flag = lanterna.MenuProcessKey(option);

        //valores da flag
        // 0 --> continuar normal
        // 1 --> aplicação (parar while)
        // 2 --> play
        // 3 --> instructions
        // 4 --> settings
        // 5 --> store

        if(flag == 2) {
            flag = 0;
            GoPlay();
        }else if(flag == 3){
            flag=0;
            GoInstructions();
        }else if(flag == 4) {
            flag = 0;
            GoSettings();
        }else if(flag == 5) {
            flag = 0;
            GoStore();
    }
        return flag;
    }

    public void GoStore() throws IOException {
        this.controller.ChangeState(new StoreState(this.controller, lanterna));
    }

    public void GoPlay() throws IOException {
        this.controller.ChangeState(new PlayState(this.controller, lanterna));
    }

    public void GoInstructions() throws IOException {
        this.controller.ChangeState(new InstructionsState(this.controller, lanterna));
    }

    public void GoSettings() throws IOException {
        this.controller.ChangeState(new SettingsState(this.controller, lanterna));
    }
}
