package gui.LanternaGUI;

import com.googlecode.lanterna.TextColor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WinningLanternaTest {
    Lanterna lanterna;

    @BeforeEach
    void setUp() throws IOException {
        lanterna = new Lanterna();
    }

    @Test
    void drawWin() throws IOException {
        lanterna.drawWin();
        assertEquals(TextColor.Factory.fromString("#040926"), lanterna.getScreen().getBackCharacter(0, 40).getBackgroundColor(), "ex1");
        assertEquals(TextColor.Factory.fromString("#FFBA08"), lanterna.getScreen().getBackCharacter(48, 12).getForegroundColor(), "ex2");
        assertEquals("[", lanterna.getScreen().getBackCharacter(100, 40).getCharacterString(), "ex3");
    }
}
