package gui.LanternaGUI;

import com.googlecode.lanterna.TextColor;
import control.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SettingsLanternaTest {
    Lanterna lanterna;

    @BeforeEach
    void setUp() throws IOException {
        lanterna = new Lanterna();
    }

    @Test
    void SettingsdrawText(){
        String RectColor = "#336699";
        String textColor = "#000000";
        lanterna.SettingsdrawText(new Position(63,21), RectColor, textColor);
        assertEquals("L", lanterna.getScreen().getBackCharacter(80, 18).getCharacterString(), "ex1");
        assertEquals(TextColor.Factory.fromString(RectColor), lanterna.getScreen().getBackCharacter(80, 18).getBackgroundColor(), "ex2");
        assertEquals(TextColor.Factory.fromString(textColor), lanterna.getScreen().getBackCharacter(80, 18).getForegroundColor(), "ex3");
    }

    @Test
    void SettingsdrawOptions(){
        lanterna.SettingsdrawOptions(1);
        assertEquals("l", lanterna.getScreen().getBackCharacter(50, 22).getCharacterString(), "ex1");
        assertEquals(TextColor.Factory.fromString("#A41623"), lanterna.getScreen().getBackCharacter(50, 22).getForegroundColor(), "ex2");

        lanterna.SettingsdrawOptions(2);
        assertEquals("l", lanterna.getScreen().getBackCharacter(50, 27).getCharacterString(), "ex3");
        assertEquals(TextColor.Factory.fromString("#A41623"), lanterna.getScreen().getBackCharacter(50, 27).getForegroundColor(), "ex4");

        lanterna.SettingsdrawOptions(3);
        assertEquals("l", lanterna.getScreen().getBackCharacter(50, 32).getCharacterString(), "ex5");
        assertEquals(TextColor.Factory.fromString("#A41623"), lanterna.getScreen().getBackCharacter(50, 32).getForegroundColor(), "ex6");
    }
}
