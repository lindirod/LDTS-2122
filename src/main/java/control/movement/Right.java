package control.movement;

import blocks.Element;
import control.Position;
import state.PlayState;

import java.io.IOException;

import static state.PlayState.Collision;


public class Right extends Movement {

    @Override
    public void doMovement(Element SquareElement, PlayState playState) throws IOException {
        int Collision = getCollision(SquareElement);
        resolveCollision(SquareElement, playState, Collision);
    }

    private void resolveCollision(Element SquareElement, PlayState playState, int Collision) throws IOException {
        if(Collision == 0)
            SquareElement.setPosition(new Position(SquareElement.getPosition().getX() + 1, SquareElement.getPosition().getY()));
        else if(Collision == 2)
            playState.GameOver();
        else if(Collision == 3)
            playState.GetKeys(3);
        else if(Collision == 4)
            playState.FinalMode();
        else if(Collision == 5)
            playState.PowerUp();
        else if(Collision == 6)
            playState.GetKeys(6);
    }


    private int getCollision(Element SquareElement) {
        SquareElement.setPosition(new Position(SquareElement.getPosition().getX()+1, SquareElement.getPosition().getY()-1));
        int Collision = Collision(SquareElement);
        SquareElement.setPosition(new Position(SquareElement.getPosition().getX()-1, SquareElement.getPosition().getY()+1));
        return Collision;
    }
}
