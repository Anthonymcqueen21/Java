import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;
import java.util.concurrent.*;
public class NotPong extends JApplet {
    // Initialize the height and width
    public static final int WIDTH = 400;
    public static final int HEIGHT = 800;
    // private canvas sector
    private PaintSurface canvas;
    // Public settings
    public void init() {
        this.setSize(WIDTH, HEIGHT);
        canvas = new PaintSurface();
        this.add(canvas, BorderLayout.CENTER);
        ScheduledThreadPoolExecutor executor = 
         new ScheduledThreadPoolExecutor(3);
        executor.scheduleAtFixedRate(new AnimationThread(this),
                0L, 20L, TimeUnit.MILLISECONDS);
    }
}
class AnimationThread implements Runnable {
    
    JApplet c;
    
    public AnimationThread(JApplet c) {
        
        this.c = c;
    }
    
    public void run() {
        c.repaint();
    }
}

class PaintSurface extends JComponent {
    int paddle_x = 0;
    int paddle_y = 360;
    
    int score = 0;
    float english = 1.0f;
    
    Ball ball;
    
    Color[] color = {Color.RED, Color.ORANGE,
                     Color.MAGENTA, Color.ORANGE,
                     Color.CYAN, Color.BLUE};
    
    int colorIndex;
    
    public PaintSurface() {
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseMoved(MouseEvent e) {
                if (e.getX() - 30 - paddle_x > 5)
                    english = 1.5f;
                else if (e.getX() - 30 - paddle_x < -5)
                    english = 1.5f;
                else
                    english = 1.0f;
                paddle_x = e.getX() - 30;
            }
        } );
        ball = new Ball(20);
    }
    
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(
               RenderingHints.KEY_ANTIALIASING,
               RenderingHints.VALUE_ANTIALIAS_ON);
        Shape paddle = new Rectangle2D.Float(
                paddle_x, paddle_y, 60, 8);
        
        g2.setColor(color[colorIndex % 6]);
        
        if (ball.intersects(paddle_x, paddle_y, 60, 8)
                && ball.y_speed > 0) {
            
            ball.y_speed = -ball.y_speed;
            ball.x_speed = (int)(ball.x_speed * english);
            if (english != 1.0f)
                colorIndex++;
            score += Math.abs(ball.x_speed * 10);
        }
        
        if (ball.getY() + ball.getHeight()
                >= NotPong.HEIGHT) {
            ball = new Ball(20);
            score -= 1000;
            colorIndex = 0;
        }
        ball.move();
        g2.fill(ball);
        
        g2.setColor(Color.BLACK);
        g2.fill(paddle);
        g2.drawString("Score: " + score, 250, 20);
                
    }
}

class Ball extends Ellipse2D.Float {
    public int x_speed, y_speed;
    private int d;
    private int width = NotPong.WIDTH;
    private int height = NotPong.HEIGHT;
    
    public Ball(int diameter) {
        super((int)(Math.random() * (NotPong.WIDTH - 20) + 1),
                0, diameter, diameter);
        this.d = diameter;
        this.x_speed = (int)(Math.random() * 5 + 5);
        this.y_speed = (int)(Math.random() * 5 + 5);
    }
    
    public void move() {
        if(super.x < 0 || super.x > width - d)
            x_speed = -x_speed;
        if(super.y < 0 || super.y > height - d)
            y_speed = -y_speed;
        super.x += x_speed;
        super.y += y_speed;
    }
}
