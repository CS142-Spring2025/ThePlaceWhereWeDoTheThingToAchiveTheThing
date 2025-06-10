//this line display all the import used inside the program
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

//this is where the BurnableTiles class started
public class BurnableTiles extends Tiles {

    //these are some of the variable used in the program
    protected int remainingBurnTime;
    protected boolean isBurning;
    protected int burnChance;
    private boolean flag = false;
    public boolean canBurn;
    private Random rand = new Random();

    //this Constructor is used to create a new BurnableTiles object
    public BurnableTiles(int burnTime, int chanceOfFire, Color color) {
        super(color);
        this.canBurn = true;
        this.burnChance=chanceOfFire;
        this.remainingBurnTime = burnTime;
        this.isBurning = false;
    }

    //this method is used to return the remaining time the tiles is burning for
    public int getRemainingBurnTime() {
        return remainingBurnTime;
    }

    //this method is used to update the time for the object to burn before it stop
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


    //this method is used to return the status of if the tiles is burning
    public boolean isBurning() {
        return isBurning;
    }
    
    public int returnBurnChance(){
      return burnChance;
    }

    //this method is used to set the tiles on fire
    public void setBurning(boolean burning) {
        this.isBurning = burning;
    }

    //this method is used to draw the burning tiles
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
