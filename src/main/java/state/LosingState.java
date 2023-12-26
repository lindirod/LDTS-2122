package state;

import control.Controller;
import gui.LanternaGUI.Lanterna;

import java.io.IOException;

public class LosingState extends OptionState {
    Lanterna lanterna;
    Controller controller;

    public LosingState(Controller controller, Lanterna lanterna) throws IOException{
        this.lanterna = lanterna;
        this.controller = controller;
    }

    @Override
    public void draw() throws IOException {
        lanterna.drawLose();
        lanterna.refresh();
    }

    @Override
    public int run() throws IOException {
        int flag = lanterna.GameOverProcessKey();
        if (flag == 2) {
            flag = 0;
            GoMenu();
        }else if(flag == 3){
            flag = 0;
            GoMenuPlay();
        }
        return flag;
    }

    public void GoMenuPlay() throws IOException {
        this.controller.ChangeState(new PlayState(this.controller, lanterna));
    }

    public void GoMenu() throws IOException {
        this.controller.ChangeState(new MenuOptionState(this.controller, lanterna));
    }

}
