package FinalProject;

//this are some of the import used in thr program
import java.util.Random;

//this is where the fire class started
public class Fire {
    
    //this are some of the variable used in the program
    private int[][] fire = new int[100][100];
    private Random rand = new Random();
    private boolean started = false;

    //this method is used to start the fire
    public void startFire(Tiles[][] grid) {
        while (!started) {
            int attemptCol = rand.nextInt(100);
            int attemptRow = rand.nextInt(100);

            if (grid[attemptRow][attemptCol] instanceof BurnableTiles) {
                BurnableTiles tile = (BurnableTiles) grid[attemptRow][attemptCol];
                tile.setBurning(true);
                fire[attemptRow][attemptCol] = 1;
                started = true;
            }
        }
    }

    //this method is used to change the speed of the fire
    public void spreadFire(Tiles[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] newFires = new boolean[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] instanceof BurnableTiles bt && bt.isBurning()) {
                    int[][] directions = { {-1,0}, {1,0}, {0,-1}, {0,1}, {1,1}, {-1,-1}, {1,-1}, {-1,1} };

                    for (int[] dir : directions) {
                        int newRow = row + dir[0];
                        int newCol = col + dir[1];

                        if (inBounds(newRow, newCol, rows, cols)) {
                            Tiles neighbor = grid[newRow][newCol];
                            if (neighbor instanceof BurnableTiles nb && !nb.isBurning()) {
                                newFires[newRow][newCol] = true;
                            }
                        }
                    }
                }
            }
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (newFires[row][col]) {
                    BurnableTiles tile = (BurnableTiles) grid[row][col];
                    if(rand.nextInt(100) <= tile.returnBurnChance()){
                       tile.setBurning(true);
                       fire[row][col] = 1;
                    }
                }
            }
        }
    }

    //this method is used to detect if it is inside the bound
    private boolean inBounds(int row, int col, int maxRows, int maxCols) {
        return row >= 0 && row < maxRows && col >= 0 && col < maxCols;
    }
}
