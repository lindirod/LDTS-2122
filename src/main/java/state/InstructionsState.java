package state;

import control.Controller;
import control.Option;
import control.Position;
import gui.LanternaGUI.Lanterna;

import java.io.IOException;

public class InstructionsState extends OptionState{
    Controller controller;
    Lanterna lanterna;
    Option option;

    public InstructionsState(Controller controller, Lanterna lanterna) throws IOException{
        this.lanterna = lanterna;
        option = new Option();
        this.controller = controller;
    }


    @Override
    public void draw() throws IOException {
        lanterna.background("#040926");
        lanterna.drawImage("src/main/resources/Instructions_ascii-art/nameInstructions", new control.Position(35,6),"#336699");
        lanterna.InstructiondrawText(new Position(63,21),"#336699","#000000");
        lanterna.refresh();
    }

    @Override
    public int run() throws IOException {
        int flag = lanterna.InstructionProcessKey();

        if(flag==2){
            flag=0;
            GoMenu();
        }
        return flag;
    }

    public void GoMenu() throws IOException {
        this.controller.ChangeState(new MenuOptionState(this.controller, lanterna));
    }
}
