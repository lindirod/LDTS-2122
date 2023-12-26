package control;

import blocks.Element;
import control.level.Level;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class LevelTest {
    Level level;
    Level currentLevel;
    ArrayList<Element> blocks;
    RelativePositionScreen relativePositionScreen;

    @BeforeEach
    void setUp(){
        level = new Level();
        currentLevel = new Level(1);
        relativePositionScreen = new RelativePositionScreen();
    }

    @Test
    public void Level(){
        assertEquals(1,level.getLevel());
        assertEquals(1, currentLevel.getLevel());
        currentLevel = new Level(2);
        assertEquals(2, level.getLevel());
        assertEquals(2, currentLevel.getLevel());
        currentLevel = new Level(3);
        assertEquals(3, level.getLevel());
        assertEquals(3, currentLevel.getLevel());
    }

    @Test
    public void KeysMax(){
        assertEquals(3, Level.keysMax());
        currentLevel = new Level(2);
        assertEquals(6, Level.keysMax());
        currentLevel = new Level(3);
        assertEquals(9, Level.keysMax());
        currentLevel = new Level(0);
        assertEquals(-1, Level.keysMax());
    }

    @Test
    public void getBlocks(){
        assertNull(blocks);
    }


    @Test
    public void draw(){
        int block = relativePositionScreen.relativePosition;
        if(currentLevel.equals(new Level(1))){
            assertEquals(blocks, relativePositionScreen.relativePosition);
        }else if(currentLevel.equals(new Level(2))){
            assertEquals(block, relativePositionScreen.relativePosition);
        }else if(currentLevel.equals(new Level(3))){
            assertEquals(block, relativePositionScreen.relativePosition);
        }
    }

}
