package state;

import control.Controller;
import control.Option;
import control.Position;
import gui.LanternaGUI.Lanterna;

import java.io.IOException;

public class SettingsState extends OptionState{
    Lanterna lanterna;
    Controller controller;
    Option option;


    public SettingsState(Controller controller, Lanterna lanterna) throws IOException{
        this.lanterna = lanterna;
        option = new Option(1);
        this.controller = controller;
    }

    @Override
    public void draw() throws IOException {
        lanterna.background("#040926");
        lanterna.drawImage("src/main/resources/Settings_ascii-art/nameSettings",new Position(55,6),"#336699");
        lanterna.drawImage("src/main/resources/Settings_ascii-art/haveFun",new Position(54,43),"#336699");
        lanterna.SettingsdrawText(new Position(63,21), "#336699", "#000000");
        lanterna.SettingsdrawOptions(option.getOption());
        lanterna.refresh();
    }

    @Override
    public int run() throws IOException {
        int flag = lanterna.SettingsProcessKey(option);
        if(flag==2){
            flag=0;
            GoMenu();
        }else if(flag == 5){
            flag = 0;
            PlayState.setnLevel(1);
            GoMenu();
        }else if(flag == 6){
            flag = 0;
            PlayState.setnLevel(2);
            GoMenu();
        }else if(flag == 7){
            flag = 0;
            PlayState.setnLevel(3);
            GoMenu();
        }

        return flag;
    }

    public void GoMenu() throws IOException {
        this.controller.ChangeState(new MenuOptionState(this.controller,lanterna));
    }

}
