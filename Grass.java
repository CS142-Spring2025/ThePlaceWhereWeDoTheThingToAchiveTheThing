import java.awt.Color;


public class Grass extends Tiles{
    protected Color color;

    public Grass() {
        super(Color.GREEN);
    }

    public boolean burn(){
        return true;
    }
}
