package gui.LanternaGUI;

import com.googlecode.lanterna.TextColor;
import control.level.Level;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayLanternaTest {
    Lanterna lanterna;

    @BeforeEach
    void setUp() throws IOException {
        lanterna = new Lanterna();
    }


    @Test
    void drawKeys(){
        Level level = new Level();
        lanterna.drawKeys(3, level,"#FFBA08");
        assertEquals(TextColor.Factory.fromString("#FFBA08"), lanterna.getScreen().getBackCharacter(150, 2).getForegroundColor(), "ex2");
        assertEquals("C", lanterna.getScreen().getBackCharacter(150, 2).getCharacterString(), "ex3");
    }
}
