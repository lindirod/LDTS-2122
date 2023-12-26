package state;

import blocks.Element;
import control.Controller;
import control.Position;
import control.level.Level;
import gui.LanternaGUI.Lanterna;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayStateTest {
    Controller controller;
    Lanterna lanterna;
    Level currentLevel;
    Element e;
    Element other;

    @BeforeEach
    void PlayState() throws IOException {
        e = new Element(new Position(20, 31), "#B3F6A5", "#7058AB", "Blocks_ascii-art/BodySquarePlayer", "Blocks_ascii-art/FaceSquarePlayer");
        other = new Element(new Position(45, 32), "#7058AB", "#7058AB", "Blocks_ascii-art/Peak", "Blocks_ascii-art/Peak");
        lanterna = new Lanterna();
        controller = new Controller(lanterna);
    }

    @Test
    void BlocksLevel() {
        currentLevel = new Level();
        PlayState.setnLevel(1);
        assertEquals(1,currentLevel.getLevel());

        PlayState.setnLevel(2);
        assertEquals(2, currentLevel.getLevel());

        PlayState.setnLevel(3);
        assertEquals(3,currentLevel.getLevel());
    }

}

