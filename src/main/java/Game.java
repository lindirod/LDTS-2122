import control.Controller;
import gui.LanternaGUI.Lanterna;
import state.StoreState;

import java.io.IOException;

public class Game {
    Controller controller;
    Lanterna lanterna;


    public static void main(String[] args) throws IOException {
        StoreState.setMoney(0);
        Game game = new Game();
        game.start();
    }

    public Game() throws IOException {
        lanterna = new Lanterna();
        controller = new Controller(lanterna);
    }

    private void start(){
        while(true){
            try {
                controller.draw();
                int flag = controller.run();
                if(flag==1){
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
