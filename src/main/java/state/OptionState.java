package state;
import java.io.IOException;

public abstract class OptionState{
    protected OptionState() throws IOException {}
    public abstract void draw() throws IOException;
    public abstract int run() throws IOException;
}
