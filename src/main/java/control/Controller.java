package control;

import gui.LanternaGUI.Lanterna;
import state.MenuOptionState;
import state.OptionState;

import java.io.IOException;

public class Controller {
    OptionState optionstate;
    Lanterna lanterna;

    public Controller(Lanterna lanterna) throws IOException {
        this.lanterna=lanterna;
        this.optionstate = new MenuOptionState(this, lanterna);
    }

    public int run() throws IOException {
        return this.optionstate.run();
    }

    public void draw() throws IOException {
        this.optionstate.draw();
    }

    public void ChangeState(OptionState optionstate) {
        this.optionstate = optionstate;
    }
}