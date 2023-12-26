package gui.LanternaGUI;

import com.googlecode.lanterna.TextColor;
import control.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LanternaTestFinal {
    Lanterna lanterna;

    @BeforeEach
    void setUp() throws IOException {
        lanterna = new Lanterna();
    }

    @Test
    void Constructorlanterna() {

        assertEquals(170, lanterna.width);
        assertEquals(50,lanterna.height);
        assertEquals(170, lanterna.getWidth());
        assertEquals(50, lanterna.getHeight());

    }

    @Test
    void clear() {
        lanterna.clear();
        lanterna = null;
    }

    @Test
    void refresh() throws IOException {
        lanterna.refresh();
    }

    @Test
    void background() {
        lanterna.background("#040926");

        assertEquals(" ", lanterna.getScreen().getBackCharacter(0, 0).getCharacterString(), "ex1");
        assertEquals(TextColor.Factory.fromString("#040926"), lanterna.getScreen().getBackCharacter(0, 0).getBackgroundColor(), "ex2");
        assertEquals(" ", lanterna.getScreen().getBackCharacter(lanterna.getWidth() - 1, lanterna.getHeight() - 1).getCharacterString(), "ex3");
        assertEquals(TextColor.Factory.fromString("#040926"), lanterna.getScreen().getBackCharacter(lanterna.getWidth() - 1, lanterna.getHeight() - 1).getBackgroundColor(), "ex4");
    }



}
