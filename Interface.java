import java.util.*;
import javax.swing.*;
import java.awt.event.*; 


public class Interface implements ActionListener {
    
    private JTextField grass;
    private JTextField rocks;
    private JTextField field;
    private int grassVal = 30;
    private int rocksVal = 25;
    private int fieldVal = 45;
    private JFrame frame;
    private boolean status = false;
    
    
    public void actionPerformed (ActionEvent event) {
    try{
        
        grassVal = Integer.parseInt(grass.getText().trim());
        rocksVal = Integer.parseInt(rocks.getText().trim());
        fieldVal = Integer.parseInt(field.getText().trim());
        int total = grassVal+rocksVal+fieldVal;
        if(total>100){
            JOptionPane.showMessageDialog(frame, "The total value exceeds 100%.");
        }else if(total<100){
            JOptionPane.showMessageDialog(frame, "The total value is less than 100%.");
        }else{
            status = true;
            frame.dispose();
        }
        
    }catch(NumberFormatException e){
        JOptionPane.showMessageDialog(null, "Please enter Int which the sum is less then 100.");
    }
      
        
     
   }
    public Interface(){
        frame = new JFrame("Test");
        frame.setSize(400,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        
        
        grass = new JTextField("30");
        grass.setBounds(50,30,80,20);
        grass.setHorizontalAlignment(JTextField.RIGHT);
        frame.add(grass);
        
        rocks = new JTextField("25");
        rocks.setBounds(50,60,80,20);
        rocks.setHorizontalAlignment(JTextField.RIGHT);
        frame.add(rocks);
        
        field = new JTextField("45");
        field.setBounds(50,90,80,20);
        field.setHorizontalAlignment(JTextField.RIGHT);
        frame.add(field);
        
        JButton button = new JButton("Submit");
        button.setBounds(50,120,100,20);
        button.setHorizontalAlignment(JTextField.CENTER);
        button.addActionListener(this);
        frame.add(button);
        
        frame.setVisible(true);
    }
    
    public int GrassValue(){
        return grassVal;
    }
    
    public int RocksValue(){
        return rocksVal;
    }
    
    public int FieldValue(){
        return fieldVal;
    }
    
    public boolean currentStatus(){
        return status;
    }
}
