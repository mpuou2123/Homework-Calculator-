//Michael Puou
//Lab 08 
//Section 04
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App implements ActionListener{
   static JTextField text = new JTextField("");
   static JButton[] Button = new JButton [15];
   static double opnd1,opnd2,res;
   static char Operator;
   static boolean newNumber;
   public static void main (String []args){
      ActionListener AL = new App();
      
      //creation of frame
      JFrame frame = new JFrame ("Michael's Calculator");
      Container ContentPane = frame.getContentPane();
      ContentPane.setLayout(new BorderLayout());
      
      //creation of panels
      JPanel panel1 = new JPanel(new GridLayout(2,1));
      ContentPane.add(panel1,BorderLayout.NORTH);
      JPanel panel2 = new JPanel(new GridLayout(4,5));
      ContentPane.add(panel2,BorderLayout.CENTER);
      JPanel panel3 = new JPanel(new GridLayout(1,3));
      ContentPane.add(panel3,BorderLayout.SOUTH);
      
      //panel1 (label)
      JLabel label = new JLabel ("CSC 20 Lab 08", JLabel.CENTER);
      panel1.add(label);
      
      //panel1 (text field)
      text = new JTextField("");
      text.setHorizontalAlignment(JTextField.RIGHT);
      panel1.add(text);
      
      //panel2
      JButton BkSP = new JButton ("BkSP");
      panel2.add(BkSP);
      JButton CE = new JButton ("CE");
      panel2.add(CE);
      JButton C = new JButton ("C");
      panel2.add(C);
      Button[13] = new JButton ("/");
      panel2.add(Button[13]);
      JButton sqrt = new JButton ("sqrt");
      panel2.add(sqrt);
      for (int i=0; i<=9; i++){
         Button[i]=new JButton(""+i);
      }
      for (int i=7; i<=9; i++){
         panel2.add(Button[i]);
      }
      Button[12] = new JButton ("*");
      panel2.add(Button[12]);
      JButton percent = new JButton ("%");
      panel2.add(percent);
      for (int k=4; k<=6; k++){
         panel2.add(Button[k]);
      }
      Button[11] = new JButton ("-");
      panel2.add(Button[11]);
      JButton dividex = new JButton ("1/x");
      panel2.add(dividex);
      for (int j=1; j<=3; j++){
         panel2.add(Button[j]);
      }
      
      Button[10] = new JButton ("+");
      panel2.add(Button[10]);
      JButton plusMinus = new JButton ("+/-");
      panel2.add(plusMinus);
      
      //panel3
      Button[0] = new JButton ("0");
      panel3.add(Button[0]);
      JButton period = new JButton (".");
      panel3.add(period);
      Button[14] = new JButton ("=");
      panel3.add(Button[14]);
      for (int i=0; i<=14; i++){
         Button[i].addActionListener(AL);
      }
      
      //formatting frame
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(300,400);
      frame.setVisible(true);
      
   }
   public void actionPerformed(ActionEvent e){
      for (int i=0; i<=9; ++i) {
         if (e.getSource() == Button[i]){ 
            if (newNumber == true) {
               text.setText(""+i);
               newNumber = false; 
            }
            else text.setText(text.getText()+i);
         }
      }
      if(e.getSource() == Button[10]){
         opnd1 = Double.parseDouble(text.getText());
         newNumber = true;
         Operator = '+';
         return;
      }
      if(e.getSource() == Button[11]){
         opnd1 = Double.parseDouble(text.getText());
         newNumber = true;
         Operator = '-';
         return;
      }
      if(e.getSource() == Button[12]){
         opnd1 = Double.parseDouble(text.getText());
         newNumber = true;
         Operator = '*';
         return;
      }
      if(e.getSource() == Button[13]){
         opnd1 = Double.parseDouble(text.getText());
         newNumber = true;
         Operator = '/';
         return;
      }
      if (e.getSource() == Button[14]){
      opnd2 = Double.parseDouble(text.getText()); 
      switch (Operator){
            case '/': 
                  res = opnd1 / opnd2; 
                  break; 
            case '*': 
                  res = opnd1 * opnd2; 
                  break; 
            case '-': 
                  res = opnd1 - opnd2; 
                  break; 
            case '+': 
                  res = opnd1 + opnd2; 
                  break;
      }
      text.setText(""+res); 
      newNumber=true;
      return;
   }
}

}
