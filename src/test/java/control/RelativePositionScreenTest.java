package control;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RelativePositionScreenTest {
    RelativePositionScreen relativePosition;
    int position;

    @BeforeEach
    public void Constructor(){
        relativePosition = new RelativePositionScreen();
        position = 0;
    }

    @Test
    public void getRelativePosition(){
        assertEquals(0, relativePosition.getRelativePosition());
    }

}
