package gui;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ColorTest {
    Color color;

    @Test
    public void getColor(){
        color = new Color(1);
        assertNotNull(color.getColor());

        color = new Color(2);
        assertNotNull(color.getColor());

        color = new Color(3);
        assertNotNull(color.getColor());

        color = new Color(4);
        assertNotNull(color.getColor());

    }

}
