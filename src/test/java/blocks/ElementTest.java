package blocks;

import control.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ElementTest {
    Element element;
    Position position;
    int positionUpdate =-1;
    Position screenPosition;

    @BeforeEach
    public void setUp() {
        element = new Element(new Position(10, 10), "#B3F6A5", "#7058AB", "Blocks_ascii-art/BodySquarePlayer", "Blocks_ascii-art/faceSquarePlayer");
    }

    @Test
    public void getScreenPosition(){
        assertEquals(10, element.getScreenPosition().getX());
        assertEquals(10, element.getScreenPosition().getY());
    }

    @Test
    public void setScreenPosition(){
        element.setScreenPosition(screenPosition);
    }

    @Test
    public void getPosition() {
        assertEquals(10, element.getPosition().getX());
        assertEquals(10, element.getPosition().getY());
    }

    @Test
    public void setPosition() {
        element.setPosition(position);
    }

    @Test
    public void getBodyColor() {
        assertEquals("#B3F6A5", element.getBodyColor());
    }

    @Test
    public void getFaceColor() {
        assertEquals("#7058AB", element.getFaceColor());
    }

    @Test
    public void getBodyFilename() {
        assertEquals("Blocks_ascii-art/BodySquarePlayer", element.getBodyFilename());
    }

    @Test
    public void getFaceFilename() {
        assertEquals("Blocks_ascii-art/faceSquarePlayer", element.getFaceFilename());
    }

    @Test
    public void getXRight() {
        assertEquals(33, element.getXRight());
    }

    @Test
    public void getXLeft(){
        assertEquals(12, element.getXLeft());
    }

    @Test
    public void getYTop(){
        assertEquals(10, element.getYTop());
    }

    @Test
    public void getYBottom(){
        assertEquals(19, element.getYBottom());
    }

    @Test
    public void getXRightSquare(){
        assertEquals(33, element.getXRightSquare());
    }

    @Test
    public void getXLeftSquare(){
        assertEquals(12, element.getXLeftSquare());
    }

    @Test
    public void getYTopSquare(){
        assertEquals(10, element.getYTopSquare());
    }

    @Test
    public void getYBottomSquare(){
        assertEquals(19, element.getYBottomSquare());
    }

    @Test
    public void getPositionUpdate(){
        assertEquals(positionUpdate, element.getPositionUpdate());
    }

    @Test
    public void setPositionUpdate(){
        element.setPositionUpdate(positionUpdate);
        assertEquals(positionUpdate, element.getPositionUpdate());
    }
}