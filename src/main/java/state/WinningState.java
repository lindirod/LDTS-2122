package state;

import control.Controller;
import gui.LanternaGUI.Lanterna;
import control.level.Level;

import java.io.IOException;

public class WinningState extends OptionState{
    Lanterna lanterna;
    Controller controller;

    public WinningState(Controller controller, Lanterna lanterna) throws IOException {
        this.lanterna = lanterna;
        this.controller = controller;
        updateMoney();
    }

    private void updateMoney(){
        if(Level.keysMax() == 3){
            StoreState.setMoney(StoreState.getMoney()+100);
        }else if(Level.keysMax() == 6){
            StoreState.setMoney(StoreState.getMoney()+200);
        }else if(Level.keysMax() == 9){
            StoreState.setMoney(StoreState.getMoney()+400);
        }
    }

    @Override
    public void draw() throws IOException {
        lanterna.drawWin();
        lanterna.refresh();
    }

    @Override
    public int run() throws IOException {
        int flag = lanterna.WinningProcessKey();
        if (flag == 2 || flag == 9) {
            flag = 0;
            GoMenu();
        }
        return flag;
    }

    public void GoMenu() throws IOException {
        this.controller.ChangeState(new MenuOptionState(this.controller, lanterna));
    }

}