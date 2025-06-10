//this line let the program to use resources from the FinalProject Package
//package FinalProject;

//these line show the import used in the program
import java.util.*;
import javax.swing.*;
import java.awt.event.*; 

//this is where the Interface class started
public class Interface implements ActionListener {
    
    //this is some of the variable used in the program
    private JButton submitButton;
    private JButton resetButton;
    private JLabel grassLabel;
    private JLabel rockLabel;
    private JLabel fieldLabel;
    private JLabel treeLabel;
    private JLabel tickSpeedLabel;
    private JTextField grass;
    private JTextField rocks;
    private JTextField field;
    private JTextField tree;
    private JTextField tickSpeed;
    private int grassVal = 75;
    private int rocksVal = 10;
    private int fieldVal = 10;
    private int treeVal=5;
    private int tickSpeedVal = 200;
    private JFrame frame;
    private boolean status = false;
    
    //this method is used to detect action from clicking a button and process it accordingly
    public void actionPerformed (ActionEvent event) {
        Object type = event.getSource();
        if(type == submitButton){
            
            try{

                int newgrassVal = Integer.parseInt(grass.getText().trim());
                int newrocksVal = Integer.parseInt(rocks.getText().trim());
                int newfieldVal = Integer.parseInt(field.getText().trim());
                int newTreeVal = Integer.parseInt(tree.getText().trim());
                int newTickSpeedVal = Integer.parseInt(tickSpeed.getText().trim());
                int total = newgrassVal+newrocksVal+newfieldVal+newTreeVal;
                if(total>100){
                    JOptionPane.showMessageDialog(frame, "The total value exceeds 100%.");
                }else if(total<100){
                    JOptionPane.showMessageDialog(frame, "The total value is less than 100%.");
                }else{
                    grassVal = newgrassVal;
                    rocksVal = newrocksVal;
                    fieldVal = newfieldVal;
                    treeVal = newTreeVal;
                    tickSpeedVal = newTickSpeedVal;
                    status = true;
                    frame.dispose();
                }

            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Please enter Int which the sum is less then 100.");
            }
        }else if(type == resetButton){
            grass.setText(Integer.toString(grassVal));
            rocks.setText(Integer.toString(rocksVal));
            field.setText(Integer.toString(fieldVal));
            tree.setText(Integer.toString(treeVal));
            tickSpeed.setText(Integer.toString(tickSpeedVal));
        }    
        
     
   }
    
    //this constructor is used to create a Interface object
    public Interface(){
        frame = new JFrame("Interface");
        frame.setSize(350,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        
        grassLabel = new JLabel("%  Grass Percentage");
        grassLabel.setBounds(130,30,150,20);
        grass = new JTextField(Integer.toString(grassVal));
        grass.setBounds(50,30,80,20);
        grass.setHorizontalAlignment(JTextField.RIGHT);
        frame.add(grassLabel);
        frame.add(grass);
        
        rockLabel = new JLabel("%  Rock Percentage");
        rockLabel.setBounds(130,60,150,20);
        rocks = new JTextField(Integer.toString(rocksVal));
        rocks.setBounds(50,60,80,20);
        rocks.setHorizontalAlignment(JTextField.RIGHT);
        frame.add(rockLabel);
        frame.add(rocks);
        
        fieldLabel = new JLabel("%  Field Percentage");
        fieldLabel.setBounds(130,90,150,20);
        field = new JTextField(Integer.toString(fieldVal));
        field.setBounds(50,90,80,20);
        field.setHorizontalAlignment(JTextField.RIGHT);
        frame.add(fieldLabel);
        frame.add(field);
        
        treeLabel = new JLabel("%  Tree Percentage");
        treeLabel.setBounds(130,120,150,20);
        tree = new JTextField(Integer.toString(treeVal));
        tree.setBounds(50,120,80,20);
        tree.setHorizontalAlignment(JTextField.RIGHT);
        frame.add(treeLabel);
        frame.add(tree);
        
        tickSpeedLabel = new JLabel(" Tick Speed (Miliseconds)");
        tickSpeedLabel.setBounds(130,150,150,20);
        tickSpeed = new JTextField(Integer.toString(tickSpeedVal));
        tickSpeed.setBounds(50,150,80,20);
        tickSpeed.setHorizontalAlignment(JTextField.RIGHT);
        frame.add(tickSpeedLabel);
        frame.add(tickSpeed);
        
        submitButton = new JButton("Submit");
        submitButton.setBounds(50,180,100,20);
        submitButton.setHorizontalAlignment(JTextField.CENTER);
        submitButton.addActionListener(this);
        frame.add(submitButton);
        
        resetButton = new JButton("Reset");
        resetButton.setBounds(170,180,100,20);
        resetButton.setHorizontalAlignment(JTextField.CENTER);
        resetButton.addActionListener(this);
        frame.add(resetButton);
        
        frame.setVisible(true);
    }
    
    //this method is used to return the percentage of grass inputed by user
    public int GrassValue(){
        return grassVal;
    }
    //this method is used to return the percentage of rocks inputed by user
    public int RocksValue(){
        return rocksVal;
    }
    //this method is used to return the percentage of field inputed by user
    public int FieldValue(){
        return fieldVal;
    }
    
    public int treeValue(){
      return treeVal;
    }
    
    public int tickSpeedValue(){
      return tickSpeedVal;
    }
    
    //this method is used to return the status of which the interface stage is completed
    public boolean currentStatus(){
        return status;
    }
}

