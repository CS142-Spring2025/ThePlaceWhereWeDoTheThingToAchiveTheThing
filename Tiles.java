//this is all the import used inside the program
import java.awt.Color;
import java.awt.Graphics;

//this is where the Tiles class started
public class Tiles {
    protected Color color;
    protected boolean canBurn;
    protected int burnTime;

    //this contructor is used to create Tiles object with default colour set
    public Tiles() {
        this.color = new Color(139, 69, 19);
    }

    //this constructor is used to create Tiles object with customisable colour
    public Tiles(Color color) {
        this.color = color;
    }

    //this method is used to indicate if the object is burnable or not
    public boolean burn(){
        return false;
    }

    //this method is used to draw and set the tiles with sepcific colour and dimension
    public void draw(Graphics g, int x, int y, int size) {
        g.setColor(color);
        g.fillRect(x, y, size, size);
    }
    public void draw(Graphics g, int x, int y, int size, Color color) {
        g.setColor(color);
        g.fillRect(x, y, size, size);
    }
}
