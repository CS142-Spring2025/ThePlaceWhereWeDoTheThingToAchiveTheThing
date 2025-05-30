//these line show all the import used in the program
import java.awt.Color;

//this is where the Grass class started
public class Grass extends Tiles{
    protected Color color;

    //this constructor is used to create a Grass object
    public Grass() {
        super(Color.GREEN);
    }

    //this method determine if the object is burnable
    public boolean burn(){
        return true;
    }
}
