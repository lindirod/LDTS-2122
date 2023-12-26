package control.movement;

import blocks.Element;
import control.Position;
import state.PlayState;

import java.io.IOException;

import static state.PlayState.Collision;
import static state.PlayState.ative;

public class Jump extends Movement {


    @Override
    public void doMovement(Element SquareElement, PlayState playState) throws IOException {
        if (firstPartJump(SquareElement, playState)) return;
        if (secondPartJump(SquareElement, playState)) return;
    }

    private boolean secondPartJump(Element SquareElement, PlayState playState) throws IOException {
        for (int i = 0; i < 29; i++) {
            if(!ative) return true;

            int Collision = getCollision2(SquareElement);

            if (Collision == 1) break;
            SquareElement.setPosition(new Position(SquareElement.getPosition().getX() + 1, SquareElement.getPosition().getY() + 1));

            resolveCollision(Collision, playState);

            playState.draw();
        }
        return false;
    }

    private boolean firstPartJump(Element SquareElement, PlayState playState) throws IOException {
        for (int i = 0; i < 29; i++) {
            if(!ative) return true;

            int Collision = getCollision1(SquareElement);

            if (Collision == 1) break;
            SquareElement.setPosition(new Position(SquareElement.getPosition().getX() + 1, SquareElement.getPosition().getY() - 1));

            resolveCollision(Collision, playState);

            playState.draw();

        }
        return false;
    }

    private int getCollision1(Element SquareElement) {
        SquareElement.setPosition(new Position(SquareElement.getPosition().getX()+1, SquareElement.getPosition().getY() - 1));
        int Collision = Collision(SquareElement);
        SquareElement.setPosition(new Position(SquareElement.getPosition().getX()-1, SquareElement.getPosition().getY() + 1));
        return Collision;
    }


    private int getCollision2(Element SquareElement) {
        SquareElement.setPosition(new Position(SquareElement.getPosition().getX()+1, SquareElement.getPosition().getY() + 1));
        int Collision = Collision(SquareElement);
        SquareElement.setPosition(new Position(SquareElement.getPosition().getX()-1, SquareElement.getPosition().getY() - 1));
        return Collision;
    }

    private void resolveCollision(int Collision, PlayState playState) throws IOException {
        if(Collision == 2)
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
}

