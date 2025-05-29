import java.awt.Color;
import java.awt.Graphics;

public class Tiles {
    protected Color color;

    public Tiles() {
        this.color = new Color(139, 69, 19);
    }
    
    public Tiles(Color color) {
        this.color = color;
    }

    public boolean burn(){
        return false;
    }
    
    public void draw(Graphics g, int x, int y, int size) {
        g.setColor(color);
        g.fillRect(x, y, size, size);
    }
}
