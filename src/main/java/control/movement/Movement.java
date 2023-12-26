package control.movement;

import blocks.Element;
import state.PlayState;

import java.io.IOException;

public abstract class Movement {
    public abstract void doMovement(Element SquareElement, PlayState playState) throws IOException;
}
