import java.awt.event.*;
import javax.swing.*;
public class TickTock {
     public static void main(String[] args) {
      // create a timer that calls the Ticket class
      // at one second intervals
      Timer t = new Timer(1000, new Ticker());
      t.start();
      
      // Display a message box to prevent 
      // the program from ending immediatelly
      JOptionPane.showMessageDialog(null, "Click Ok to exit program");
     }
  }
  class Ticker implements ActionListioner {
    private boolean tick = true;
    public void actionPerformed(ActionEvent event) {
    
       if (tick) {
           System.out.println("Tick...");
       }
       else {
           System.out.println("Tock...");
       }
       tick = !tick;
    }
}
