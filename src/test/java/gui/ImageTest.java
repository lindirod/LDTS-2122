package gui;

import control.Position;
import com.googlecode.lanterna.graphics.TextGraphics;
import gui.LanternaGUI.Lanterna;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.IOException;

public class ImageTest {
    private Image image;
    private Lanterna lanterna;

    @BeforeEach
    void setUp() throws IOException{
        lanterna = new Lanterna();
    }

    @Test
    void nameImagetest() throws IOException{
        TextGraphics graphics = lanterna.getScreen().newTextGraphics();
        image = new Image(graphics, "src/main/resources/Menu_ascii-art/name-game-acii-art", new Position(0,8), "#336699" );
        lanterna.refresh();
        Assertions.assertNotNull(image);
        Assertions.assertEquals("%", lanterna.getScreen().getBackCharacter(5,8).getCharacterString(), "part2");

    }


}
