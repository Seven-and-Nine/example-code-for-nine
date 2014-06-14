import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Nov21 extends JPanel
{
  private Point point1, point2;
  
  public Nov21()
  {
    point1 = new Point(0,0);
    point2 = new Point(0,0);
    RawMouseListener listener = new RawMouseListener();
    addMouseListener(listener);
    addMouseMotionListener(listener);
    addKeyListener(new RawKeyListener());
    setFocusable(true);
    setPreferredSize(new Dimension(640,480));
    setBackground(Color.black);
  }
  
  public void paintComponent(Graphics g)
  {
  //  super.paintComponent(g);
    g.setColor(Color.red);
    g.drawLine(point1.x,point1.y, (int) point2.getX(), (int) point2.getY());
  }
  
  private class RawMouseListener implements MouseListener, MouseMotionListener
  {
    public void mouseClicked(MouseEvent e){};
    public void mouseEntered(MouseEvent e){};
    public void mouseExited(MouseEvent e){};
    public void mousePressed(MouseEvent e)
    {
    //  point1 = e.getPoint();
    //  repaint();
    }  
    public void mouseReleased(MouseEvent e){
    }; 
    
    public void mouseDragged(MouseEvent e)
    {
      point2 = e.getPoint();
      System.out.println(point2.getX()+" "+point2.getY());
      repaint();
    }
    public void mouseMoved(MouseEvent e)
    {
      point1 = e.getPoint();
    //  repaint();
    }
  }
  
  private class RawKeyListener implements KeyListener
  {
      public void keyPressed(KeyEvent e)
      {
        System.out.println("inside keyPressed " + e.getKeyCode());
        switch(e.getKeyCode())
        {
          case KeyEvent.VK_UP:
            System.out.println("up arrow");
            break;
          case KeyEvent.VK_DOWN:
            System.out.println("down arrow");
            break;
          case KeyEvent.VK_ESCAPE:
            System.out.println("program teminating");
            System.exit(0);
        }
      }
            

      public void keyReleased(KeyEvent e)
      {
        System.out.println("inside keyReleased " + e.getKeyCode());
      }
      public void keyTyped(KeyEvent e)
      {
        System.out.println("inside keyTyped " + e.getKeyCode());
      }
  }
  public static void main(String[] arg)
  {
    JFrame frame = new JFrame("Nov21");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(new Nov21());
    frame.pack();
    frame.setVisible(true);
  }
}