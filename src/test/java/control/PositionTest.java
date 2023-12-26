package control;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositionTest {
    private Position position;

    @BeforeEach
    void setUp(){
        position = new Position(10,10);
    }

    @Test
    void getPosition(){
        assertEquals(10,position.getX());
        assertEquals(10,position.getY());
    }

    @Test
    void setPosition(){
        position.setX(20);
        position.setY(20);
        assertEquals(20,position.getX());
        assertEquals(20,position.getY());
    }

    @Test
    void getEquals(){
        assertEquals(new Position(10,10), position);
    }
}