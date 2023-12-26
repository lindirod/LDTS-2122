package control.movement;

import blocks.Element;
import control.Position;
import state.PlayState;

import java.io.IOException;

//import static control.Collision.Collision;
//import static state.PlayState.Collision;

import static state.PlayState.Collision;
import static state.PlayState.ative;

public class Gravity extends Movement {

    @Override
    public void doMovement(Element SquareElement, PlayState playState) throws IOException {
        while (true) {
            int Collision = getCollision(SquareElement);

            if (Collision == 1) break;
            SquareElement.setPosition(new Position(SquareElement.getPosition().getX(), SquareElement.getPosition().getY() + 1));
            ResolveCollision(playState, Collision);

            if (!ative) return;
            playState.draw();
        }
    }

    private void ResolveCollision(PlayState playState, int Collision) throws IOException {
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

    private int getCollision(Element SquareElement) {
        SquareElement.setPosition(new Position(SquareElement.getPosition().getX(), SquareElement.getPosition().getY() + 1));
        int Collision = Collision(SquareElement);
        SquareElement.setPosition(new Position(SquareElement.getPosition().getX(), SquareElement.getPosition().getY() - 1));

        /* significado da Colissão:
       *  0 -> sem Colisão
       *  1 -> Colisao normal
       *  2 -> Colisão com o Peak
       *  3 -> Colisão com a Key
       *  4 -> Colisão com a Final Piece
       *  5 -> Colisão com o Power Up Winning
       *  6 -> Colisão com o Power Up Doble Keys
       * */

        return Collision;
    }
}
