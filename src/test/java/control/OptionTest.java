package control;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OptionTest {
    Option option;
    Option newoption;


    @BeforeEach
    void setUp(){
        option = new Option();
        newoption = new Option(1);
    }

    @Test
    void Constructor(){
      Assertions.assertEquals(3, option.getOption());
    }

    @Test
    void Constructor2(){
     Assertions.assertEquals(1,newoption.getOption());
    }

    @Test
    void setGetOption(){
       option.setOption(5);
       Assertions.assertEquals(5,option.getOption());
    }
}
