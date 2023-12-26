package gui.LanternaGUI;

import com.googlecode.lanterna.TextColor;
import control.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InstructionsLanternaTest {
    Lanterna lanterna;

    @BeforeEach
    void setUp() throws IOException {
        lanterna = new Lanterna();
    }

    @Test
    void InstructiondrawText() {
        String RectColor = "#336699";
        String textColor = "#000000";
        lanterna.InstructiondrawText(new Position(63,21), RectColor, textColor);

         assertEquals("E", lanterna.getScreen().getBackCharacter(68, 21).getCharacterString(), "ex1");
         assertEquals(TextColor.Factory.fromString(RectColor), lanterna.getScreen().getBackCharacter(68, 21).getBackgroundColor(), "ex2");
         assertEquals(TextColor.Factory.fromString(textColor), lanterna.getScreen().getBackCharacter(68, 21).getForegroundColor(), "ex3");

    }
}
