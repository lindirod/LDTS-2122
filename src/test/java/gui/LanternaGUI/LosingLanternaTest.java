package gui.LanternaGUI;

import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LosingLanternaTest {
    Lanterna lanterna;

    @BeforeEach
    void setUp() throws IOException {
        lanterna = new Lanterna();
    }

    @Test
    void drawLose() throws IOException {
        lanterna.drawLose();
        assertEquals(TextColor.Factory.fromString("#040926"), lanterna.getScreen().getBackCharacter(0, 40).getBackgroundColor(), "ex1");
        assertEquals(TextColor.Factory.fromString("#A41623"), lanterna.getScreen().getBackCharacter(46, 20).getForegroundColor(), "ex2");
        assertEquals("Y", lanterna.getScreen().getBackCharacter(46, 30).getCharacterString(), "ex3");
    }
}
