
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;

public class Starfield extends JPanel
{
  private Point2D.Double[] stars;
  private int size;
  private int width;
  private int height;
  private double xvel;
  private double yvel;
  
  public Starfield()
  {
    size = 4000;
    width = 800;
    height = 600;
    
    xvel = 3.0;
    yvel = 2.0;
    
    stars = new Point2D.Double[size];
    for(int i=0;i<size;i++)
      stars[i] = new Point2D.Double(width*Math.random(),height*Math.random());
    
    setBackground(Color.black);
    setPreferredSize(new Dimension(width,height));
    Timer timer = new Timer(20,new TimerListener());
    timer.start();
  }
  
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    g.setColor(Color.white);
    for(Point2D.Double star : stars)
      g.fillOval((int) star.getX(),(int) star.getY(),3,3);
  }
  
  public class TimerListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      for(Point2D.Double star : stars)
      {
        double x = star.getX() + xvel;
        double y = star.getY() + yvel;
        if(x > width) 
          x -= width;
        if(x<0)
          x += width;
        if(y>height)
          y -= height;
        if(y<0)
          y += height;
        star.setLocation(x,y);
      }
      repaint();
      if(Math.random() < 0.05)
      {
        xvel += Math.random() - 0.5;
        yvel += Math.random() - 0.5;
      }
    }
  }
    
  
  public static void main(String[] arg)
  {
    JFrame frame = new JFrame("Starfield");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(new Starfield());
    frame.pack();
    frame.setVisible(true);
  }
}