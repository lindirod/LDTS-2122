package control;

import blocks.Element;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class CollisionTest {
    Element e;
    Element other;

    @BeforeEach
    void setUp(){
        e =new Element(new Position(20, 31), "#B3F6A5","#7058AB","Blocks_ascii-art/BodySquarePlayer","Blocks_ascii-art/FaceSquarePlayer");
        other =new Element(new Position(45, 32), "#7058AB","#7058AB","Blocks_ascii-art/Peak","Blocks_ascii-art/Peak");
    }

    @Test
    void CheckCollision(){
        boolean NoXCollision = e.getXRightSquare() <= other.getXLeft() || e.getXLeftSquare() >= other.getXRight();
        boolean NoYCollision = e.getYBottomSquare() <= other.getYTop() || e.getYTopSquare() >= other.getYBottom();

        assertTrue(NoYCollision || NoXCollision);
    }


}
