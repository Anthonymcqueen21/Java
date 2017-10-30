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
    
    public MouseClicker() {
     
       this.setSize(400, 400);
       this.setTitle("Mouse Clicker");
       this.addMouseListener(new Clicker());
       
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
