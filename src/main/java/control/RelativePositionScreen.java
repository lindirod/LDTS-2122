package control;

import state.PlayState;

import java.io.IOException;

import static state.PlayState.ative;

public class RelativePositionScreen {
    int relativePosition;

    public RelativePositionScreen() {
        relativePosition=0;
    }

    public int getRelativePosition() {
        return relativePosition;
    }

    public void StartCounting(PlayState playState){
        Thread update = new Thread(() ->{
           for(int i = 0; i < 900 && ative; i++){
               relativePosition++;
               try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        update.start();
    }

}
