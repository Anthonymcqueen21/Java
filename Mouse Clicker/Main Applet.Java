import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.applet.*;
import java.net.URL;
public class MouseClicker extends JFrame {
    // Audio clicks
    AudioClip click;
    // Main function string main
    public static void main(String[] args) {
    // Mouse clicker class
        new MouseClicker();
    }
    // Mouse clicker class main integer values.
    public MouseClicker() {
     // Setting the size title with a mouse Listener
       this.setSize(400, 400);
       this.setTitle("Mouse Clicker");
       this.addMouseListener(new Clicker());
       // Clicking class gett the resource
       URL urlClick = MouseClicker.class.getResource("hit.wav");
       click = Applet.newAudioClip(urlClick);
       
       this.setVisible(true);
    }
    
    private class Clicker extends MouseAdapter {
       
       public void MouseClicked(MouseEvent e) {
       
          click.play();
       }
    }
}
