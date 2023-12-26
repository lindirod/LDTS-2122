package gui.LanternaGUI;

import com.googlecode.lanterna.TextColor;
import control.Position;
import gui.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoreLanternaTest {
    Lanterna lanterna;
    StoreLanterna storelanterna;
    int can;

    @BeforeEach
    void setUp() throws IOException {
        lanterna = new Lanterna();
        storelanterna = new StoreLanterna(lanterna.getScreen());
    }


    @Test
    void StoredrawText(){
        lanterna.StoredrawText(new Position(63,21), "#336699", "#000000");
        assertEquals(TextColor.Factory.fromString("#336699"), lanterna.getScreen().getBackCharacter(63, 21).getBackgroundColor(), "ex1");
        assertEquals(TextColor.Factory.fromString("#000000"), lanterna.getScreen().getBackCharacter(48, 17).getForegroundColor(), "ex2");
        assertEquals(" ", lanterna.getScreen().getBackCharacter(63, 21).getCharacterString(), "ex3");
    }

    @Test
    void StoredrawColor(){
        lanterna.StoredrawColor();

        storelanterna.drawPalete(new Color(1), new Position(48,20));
        assertEquals(TextColor.Factory.fromString("#9D69F2"), lanterna.getScreen().getBackCharacter(48, 20).getBackgroundColor(), "ex1");
        assertEquals(" ", lanterna.getScreen().getBackCharacter(48, 20).getCharacterString(), "ex2");

        storelanterna.drawPalete(new Color(2), new Position(48,25));
        assertEquals(TextColor.Factory.fromString("#D5CCFF"), lanterna.getScreen().getBackCharacter(48, 25).getBackgroundColor(), "ex3");
        assertEquals(" ", lanterna.getScreen().getBackCharacter(52, 20).getCharacterString(), "ex4");

        storelanterna.drawPalete(new Color(3), new Position(48,30));
        assertEquals(TextColor.Factory.fromString("#DD7373"), lanterna.getScreen().getBackCharacter(48, 30).getBackgroundColor(), "ex5");
        assertEquals(" ", lanterna.getScreen().getBackCharacter(56, 20).getCharacterString(), "ex6");

        storelanterna.drawPalete(new Color(4), new Position(48,35));
        assertEquals(TextColor.Factory.fromString("#B89193"), lanterna.getScreen().getBackCharacter(48, 35).getBackgroundColor(), "ex7");
        assertEquals(" ", lanterna.getScreen().getBackCharacter(60, 20).getCharacterString(), "ex8");
    }

    @Test
    void StoredrawOptions() throws IOException {
        lanterna.StoredrawOptions(1);
        assertEquals("-", lanterna.getScreen().getBackCharacter(44, 20).getCharacterString(), "ex1");

        lanterna.StoredrawOptions(2);
        assertEquals("-", lanterna.getScreen().getBackCharacter(44, 25).getCharacterString(), "ex2");

        lanterna.StoredrawOptions(3);
        assertEquals("-", lanterna.getScreen().getBackCharacter(44, 30).getCharacterString(), "ex3");

        lanterna.StoredrawOptions(4);
        assertEquals("-", lanterna.getScreen().getBackCharacter(44, 35).getCharacterString(), "ex4");
    }

    @Test
    void drawMoney(){
        lanterna.drawMoney();
        assertEquals(TextColor.Factory.fromString("#040926"), lanterna.getScreen().getBackCharacter(125, 13).getBackgroundColor(), "ex1");
        assertEquals(TextColor.Factory.fromString("#336699"), lanterna.getScreen().getBackCharacter(125, 13).getForegroundColor(), "ex2");
        assertEquals("$", lanterna.getScreen().getBackCharacter(127, 13).getCharacterString(), "ex3");

    }

    @Test
    void StoreMensager(){
        lanterna.StoreMensager(1);
        assertEquals(0,lanterna.StoreMensager(1));

        assertEquals(TextColor.Factory.fromString("#040926"), lanterna.getScreen().getBackCharacter(71, 44).getBackgroundColor(), "ex1");
        assertEquals(TextColor.Factory.fromString("#336699"), lanterna.getScreen().getBackCharacter(71, 44).getForegroundColor(), "ex2");
        assertEquals("Y", lanterna.getScreen().getBackCharacter(71, 44).getCharacterString(), "ex3");

        lanterna.StoreMensager(2);
        assertEquals(0, lanterna.StoreMensager(2));
        assertEquals(TextColor.Factory.fromString("#040926"), lanterna.getScreen().getBackCharacter(82, 44).getBackgroundColor(), "ex4");
        assertEquals(TextColor.Factory.fromString("#336699"), lanterna.getScreen().getBackCharacter(82, 44).getForegroundColor(), "ex5");
        assertEquals("S", lanterna.getScreen().getBackCharacter(82, 44).getCharacterString(), "ex6");

    }
}
