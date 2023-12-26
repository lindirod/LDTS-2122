package gui.LanternaGUI;

import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameOverLanternaTest {
    Lanterna lanterna;


    @BeforeEach
    void setUp() throws IOException {
        lanterna = new Lanterna();
    }


    @Test
    void drawGameOver() throws IOException {
        lanterna.drawGameOver();
        assertEquals(" ", lanterna.getScreen().getBackCharacter(63, 21).getCharacterString(), "ex1");
        assertEquals(TextColor.Factory.fromString("#040926"), lanterna.getScreen().getBackCharacter(63, 21).getBackgroundColor(), "ex2");
        assertEquals(TextColor.Factory.fromString("#A41623"), lanterna.getScreen().getBackCharacter(63, 21).getForegroundColor(), "ex3");
        assertEquals("[", lanterna.getScreen().getBackCharacter(103, 41).getCharacterString(), "ex4");
    }

}
