
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LifeGame extends JPanel
{
  private int rows;
  private int cols;
  private int scale;
  private LifeState life;
  
  public LifeGame()
  {
    rows = 250;
    cols = 250;
    scale = 3;
    
    setPreferredSize(new Dimension(scale*cols,scale*rows));
    setBackground(Color.white);
    life = new LifeState(rows,cols);
    
   /* for(int j=0;j<cols;j++)
      life.setCell(rows/2,j,true);
    for(int j=0;j<rows;j++)
      life.setCell(j,cols/2,true);
      */
    java.util.Random rnd = new java.util.Random();
    for(int i=0;i<rows;i++)
      for(int j=0;j<cols;j++)
        life.setCell(i,j,rnd.nextBoolean());
    
    Timer timer = new Timer(100,new TimerListener());
    timer.start();
  }
  
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    g.setColor(Color.black);
    for(int i=0;i<rows;i++)
      for(int j=0;j<cols;j++)
        if(life.getCell(i,j))
           g.fillRect(scale*j,scale*i,scale,scale);
  }
  
  public class TimerListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
      life.iterate();
      repaint();
    }
  }
  
  public static void main(String[] arg)
  {
    JFrame frame = new JFrame("Conway's Game of Life");
    frame.getContentPane().add(new LifeGame());
    frame.pack();
    frame.setVisible(true);
  }
}
    