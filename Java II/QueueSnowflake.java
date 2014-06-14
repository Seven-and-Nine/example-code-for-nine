
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class QueueSnowflake extends JPanel
{
  private double SCALE = 1.0/(2*Math.sqrt(3.0));
  private int width,height;
  private int maxlevel;
  Queue<Point2D.Double> queue;
  
  public QueueSnowflake()
  {
    width = 600;
    height = 600;
    maxlevel = 8;
    setPreferredSize(new Dimension(width,height));
    
    queue = new LinkedListQueue<Point2D.Double>();
    double radius = 3.0*width/8.0;    
    double theta = 0.0;
    Point2D.Double A = new Point2D.Double(width/2 + radius*Math.cos(theta),
                                          height/2 + radius*Math.sin(theta));
    theta = 2*Math.PI/3;
    Point2D.Double B = new Point2D.Double(width/2 + radius*Math.cos(theta),
                                          height/2 + radius*Math.sin(theta));
    theta = 4*Math.PI/3;
    Point2D.Double C = new Point2D.Double(width/2 + radius*Math.cos(theta),
                                          height/2 + radius*Math.sin(theta));
    queue.add(A);
    queue.add(B);
    queue.add(C);
    addPoints();
    repaint();
  }
  
  private void addPoints()
  {
    for(int i=0;i<maxlevel;i++)
    {
      for(int j= queue.size(); j>0;j--)
      {
        Point2D.Double X = queue.remove();
        Point2D.Double Y = queue.element();
        double x0 = X.getX();
        double y0 = X.getY();
        double x1 = Y.getX();
        double y1 = Y.getY();
        Point2D.Double P = new Point2D.Double( (2*x0 + x1)/3.0, (2*y0 + y1)/3.0);
        Point2D.Double R = new Point2D.Double( (2*x1 + x0)/3.0, (2*y1 + y0)/3.0);
    
        double a = 0.5*(x0 + x1) + SCALE*(y1-y0);
        double b = 0.5*(y0 + y1) + SCALE*(x0-x1);
        Point2D.Double Q = new Point2D.Double(a,b);
        queue.add(X);
        queue.add(P);
        queue.add(Q);
        queue.add(R);
      }
    }
  }
        
  
  public void paintComponent(Graphics g)
  {
    g.setColor(Color.black);
    System.out.println(queue.size());
    for(int i=queue.size();i>1;i--)
    {
      Point2D.Double X = queue.remove();
      Point2D.Double Y = queue.element();
      int x0 = (int)X.getX();
      int y0 = (int)X.getY();
      int x1 = (int)Y.getX();
      int y1 = (int)Y.getY();
      g.drawLine(x0,y0,x1,y1);
 //     queue.add(X);
    }
  }  
  
  public static void main(String[] arg)
  {
    JFrame frame = new JFrame("Koch Snowflake");
    frame.getContentPane().add(new QueueSnowflake());
    frame.pack();
    frame.setVisible(true);
  }
}