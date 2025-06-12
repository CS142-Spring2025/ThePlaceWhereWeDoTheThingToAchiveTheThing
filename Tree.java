package FinalProject;

//this is some of the import used in the program
import java.awt.Color;
import java.util.Random;

//this is where the tree class started
public class Tree extends BurnableTiles{
    
   //this is some of the variable used in the program
   private int treeHeight;
   private Random rand = new Random();

   //this construct is used to create e tree object
   public Tree() {
        super(4000, 20, new Color(43,70,60));
        this.treeHeight=rand.nextInt(20);
   }
   @Override
   public void decreaseBurnTime(int timeStep, Tiles[][] grid, int row, int col) {
      int rows = grid.length;
      int cols = grid[0].length;
      
      if (isBurning) {
         remainingBurnTime -= timeStep;
         if(remainingBurnTime <= 0){
            if(rand.nextInt(100) <= 25){
               int temp = rand.nextInt(4);
               if (temp==0){
                  for(int i=0;i<treeHeight;i++){
                     if (inBounds(row+i, col, rows, cols)){
                        grid[row+i][col] = new Trunk();
                     }else{
                        break;
                     }
                  }
               }else if(temp==1){
                  for(int i=0;i<treeHeight;i++){
                     if (inBounds(row, col+i, rows, cols)){
                        grid[row][col+i] = new Trunk();
                     }else{
                        break;
                     }
                  }
               }else if(temp==2){
                  for(int i=0;i<treeHeight;i++){
                     if (inBounds(row-i, col, rows, cols)){
                        grid[row-i][col] = new Trunk();
                     }else{
                        break;
                     }
                  }
               }else{
                  for(int i=0;i<treeHeight;i++){
                     if (inBounds(row, col-i, rows, cols)){
                        grid[row][col-i] = new Trunk();
                     }else{
                        break;
                     }
                  }
               }
               
            }else{
               remainingBurnTime += 500;
            }
         }
      }
   }
   
   //this method is used to detect if it is in bound
   private boolean inBounds(int row, int col, int maxRows, int maxCols) {
        return row >= 0 && row < maxRows && col >= 0 && col < maxCols;
   }
   
}
