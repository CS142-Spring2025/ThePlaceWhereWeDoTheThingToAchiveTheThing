import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class BurnableTiles extends Tiles {
    private int remainingBurnTime;
    private boolean isBurning;
    private boolean flag = false;
    public boolean canBurn;
    private Random rand = new Random();

    public BurnableTiles(int burnTime, Color color) {
        super(color);
        this.canBurn = true;
        this.remainingBurnTime = burnTime;
        this.isBurning = false;
    }

    public int getRemainingBurnTime() {
        return remainingBurnTime;
    }

    public void decreaseBurnTime(int timeStep, Tiles[][] grid, int row, int col) {
      if (isBurning) {
         remainingBurnTime -= timeStep;
         if(remainingBurnTime <= 0){
            if(rand.nextInt(100) <= 25){
               grid[row][col] = new Ash();
            }else
            remainingBurnTime += 500;
            }
         }
   }


    public boolean isBurning() {
        return isBurning;
    }

    public void setBurning(boolean burning) {
        this.isBurning = burning;
    }

    @Override
    public void draw(Graphics g, int x, int y, int tileSize) {
        if (isBurning) {
            g.setColor(Color.RED);
            g.fillRect(x, y, tileSize, tileSize);
        } else {
            super.draw(g, x, y, tileSize);
        }
    }
}
