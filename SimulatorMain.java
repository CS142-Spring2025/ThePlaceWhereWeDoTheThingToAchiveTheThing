//these line show all the import used in the program
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

//this is where the SimulatorMain class started
public class SimulatorMain extends JPanel {

    //these are some of the variable used in the program
    public static final int TILE_SIZE = 10;
    public static final int TILES_PER_ROW = 100;
    public static final int TILES_PER_COL = 100;
    
    private Tiles[][] grid;
    private Fire fire;
    private Random rand = new Random();
    

    public SimulatorMain(Interface input) {
    setPreferredSize(new Dimension(TILE_SIZE * TILES_PER_ROW, TILE_SIZE * TILES_PER_COL));
    createGrid(input);

    fire = new Fire();

    Timer starter = new Timer(500, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            fire.startFire(grid);
        }
    });
    starter.setRepeats(false);
    starter.start();

    Timer timer = new Timer(200, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            for (int row = 0; row < TILES_PER_COL; row++) {
                for (int col = 0; col < TILES_PER_ROW; col++) {
                    if (grid[row][col] instanceof BurnableTiles bt) {
                        bt.decreaseBurnTime(1, grid, row, col);
                    }
                }
            }
            fire.spreadFire(grid);
            repaint();
        }
    });
    timer.start();
   }

    //this method we used to draw graphics onto the GUI of the program
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int row = 0; row < TILES_PER_COL; row++) {
            for (int col = 0; col < TILES_PER_ROW; col++) {
                int x = col * TILE_SIZE;
                int y = row * TILE_SIZE;
                grid[row][col].draw(g, x, y, TILE_SIZE);
            }
        }
    }

    //this method is used to create individual tiles where each one will be defined as a different object
    public void createGrid(Interface input) {
        grid = new Tiles[TILES_PER_COL][TILES_PER_ROW];
        for (int row = 0; row < TILES_PER_COL; row++) {
            for (int col = 0; col < TILES_PER_ROW; col++) {
                int temp = rand.nextInt(100);
                 if (col > 60 && col <= 70){
                    grid[row][col] = new Water();
                }else if(col == 60 || col == 71){
                    int random = rand.nextInt(2);
                    if(random==0){
                        grid[row][col] = new Water();
                        if(col == 60){
                            grid[row][59]= new Sand();
                        }else if(col == 71){
                            grid[row][72]= new Sand();        
                        }
                    }else{
                        grid[row][col] = new Sand();
                    }
                }else if (temp <= input.FieldValue()) {
                    grid[row][col] = new Tiles();
                } else if (temp > input.FieldValue() && temp <= input.GrassValue()){
                    grid[row][col] = new Grass();
                }else
                    grid[row][col] = new Rock();
            }
        }
    }

    //this is where the main method started
    public static void main(String[] args) {
        Interface input = new Interface();
        
        while (!input.currentStatus()) {
            try {
               Thread.sleep(100);  // Check every 100ms
            } catch (InterruptedException e) {
               e.printStackTrace();
            } 
        }
        JFrame frame = new JFrame("Simulator Grid");
        SimulatorMain panel = new SimulatorMain(input);
        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        System.out.println(input.GrassValue()+"  "+input.FieldValue()+"  "+input.RocksValue());
    }
}
