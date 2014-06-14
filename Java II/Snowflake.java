
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class Snowflake extends JPanel
{
  private Graphics graph;
  private double SCALE = 1.0/(2*Math.sqrt(3.0));
  private int width,height;
  private int maxlevel;
  
  public Snowflake()
  {
    width = 600;
    height = 600;
    maxlevel = 5;
    setPreferredSize(new Dimension(width,height));
    repaint();
  }
  
  public void paintComponent(Graphics g)
  {
    graph = g;
    graph.setColor(Color.black);
    
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
    
    drawSegment(A,B,maxlevel);
    drawSegment(B,C,maxlevel);
    drawSegment(C,A,maxlevel);
  }  
  
  private void drawSegment(Point2D.Double X, Point2D.Double Y, int level)
  {
    double x0 = X.getX();
    double y0 = X.getY();
    double x1 = Y.getX();
    double y1 = Y.getY();
    
    if ( level == 0)
    {
      graph.drawLine((int)x0,(int)y0,(int)x1,(int)y1);
      return;
    }
    
    Point2D.Double P = new Point2D.Double( (2*x0 + x1)/3.0, (2*y0 + y1)/3.0);
    Point2D.Double R = new Point2D.Double( (2*x1 + x0)/3.0, (2*y1 + y0)/3.0);
    
    double a = 0.5*(x0 + x1) + SCALE*(y1-y0);
    double b = 0.5*(y0 + y1) + SCALE*(x0-x1);
    Point2D.Double Q = new Point2D.Double(a,b);
    
    drawSegment(X,P,level-1);
    drawSegment(P,Q,level-1);
    drawSegment(Q,R,level-1);
    drawSegment(R,Y,level-1);
  }
  
  public static void main(String[] arg)
  {
    JFrame frame = new JFrame("Koch Snowflake");
    frame.getContentPane().add(new Snowflake());
    frame.pack();
    frame.setVisible(true);
  }
}