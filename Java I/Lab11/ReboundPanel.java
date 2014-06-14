//********************************************************************
//  ReboundPanel.java       Java Foundations
//
//  Represents the primary panel for the Rebound program.
//********************************************************************

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;


public class ReboundPanel extends JPanel
{
   private final int WIDTH = 600, HEIGHT = 600;
   private final int DELAY = 20, IMAGE_SIZE = 35;
   private int MAX = 9;

   private ImageIcon[] image;
   private Timer timer;
   private int x[], y[], moveX[], moveY[];
   private int N;
   private int M;
   private int counter;
   private Random rnd;
   private boolean happy;
   private boolean snake;

   //-----------------------------------------------------------------
   //  Sets up the panel, including the timer for the animation.
   //-----------------------------------------------------------------
   public ReboundPanel()
   {
      timer = new Timer(DELAY, new ReboundListener());

      N = 100;
      M = 3;
      counter = 0;
       rnd = new Random();
      image = new ImageIcon[N];
      x = new int[N];
      y = new int[N];
      moveX = new int[N];
      moveY = new int[N];
      happy = false;
      snake = false;
      for(int i=0;i<N;i++)
      {
        image[i] = new ImageIcon ("sadface.png");
     
        x[i] = 0;
        y[i] = 40;
        moveX[i] = moveY[i] = 3;
      }

      addKeyListener(new RawKeyListener());
      setFocusable(true);
      setPreferredSize (new Dimension(WIDTH, HEIGHT));
      setBackground (Color.black);
      timer.start();
   }

   //-----------------------------------------------------------------
   //  Draws the image in the current location.
   //-----------------------------------------------------------------
   public void paintComponent (Graphics page)
   {
      super.paintComponent (page);
      for(int i=M-1;i>=0;i--)
      {
       image[i].paintIcon (this, page, x[i], y[i]);
       image[i].paintIcon (this, page, x[i]-WIDTH, y[i]);
       image[i].paintIcon (this, page, x[i], y[i]-HEIGHT);
       image[i].paintIcon (this, page, x[i]-WIDTH, y[i]-HEIGHT);
      }
   }

     private class RawKeyListener implements KeyListener
  {
      public void keyPressed(KeyEvent e)
      {
        switch(e.getKeyCode())
        {
          case KeyEvent.VK_UP:
            System.out.println("up arrow"+MAX);
            MAX++;
            break;
          case KeyEvent.VK_DOWN:
            System.out.println("down arrow"+MAX);
            MAX--;
            break;   
          case KeyEvent.VK_RIGHT:
            if(M<N) M++;
            break;
          case KeyEvent.VK_LEFT:
            if (M>0) M--;
            break;
          case KeyEvent.VK_ESCAPE:
            timer.stop();
            int value = JOptionPane.showConfirmDialog(null,"Really Quit?");
            System.out.println(value);
            if(value == JOptionPane.YES_OPTION)
            {
              JOptionPane.showMessageDialog(null,"Your score is: "+counter);
              System.exit(0);
            }
            timer.start();
            break;
          case KeyEvent.VK_SPACE:
            happy = happy ^ true;
            changeIcon();
            break;
          case KeyEvent.VK_S:
            snake = snake ^ true;
            break;
            
        }
      }
            

      public void keyReleased(KeyEvent e){};
      public void keyTyped(KeyEvent e){};
  }
     
  private void changeIcon()
  {
    if(happy)
    {
      for(int i=0;i<N;i++)
        image[i] = new ImageIcon("happyFace.gif");
    }
    else
      for(int i=0;i<N;i++)
        image[i] = new ImageIcon("sadface.png");
  }
      
   //*****************************************************************
   //  Represents the action listener for the timer.
   //*****************************************************************
   private class ReboundListener implements ActionListener
   {
      //--------------------------------------------------------------
      //  Updates the position of the image and possibly the direction
      //  of movement whenever the timer fires an action event.
      //--------------------------------------------------------------
      public void actionPerformed (ActionEvent event)
      {
        counter++;
        for(int i=N-1;i>0;i--)
        {
          if(snake)
          {
            x[i] = x[i-1];
            y[i] = y[i-1];
          }
          else
          {
           x[i] += moveX[i];
           y[i] += moveY[i];
          }
        }
        
        x[0] += moveX[0];
        y[0] += moveY[0];
        
        for(int i=0;i<N;i++)
        {

 //        if (x <= 0 || x >= WIDTH)
 //           moveX = moveX * -1;
         if(x[i]<0)
           x[i] += WIDTH;
         if(x[i]>WIDTH)
           x[i] -= WIDTH;

         if (y[i] <= 0 || y[i] >= HEIGHT-IMAGE_SIZE)
            moveY[i] = moveY[i] * -1;
    
         switch(rnd.nextInt(30))
         {
           case 0:
             moveX[i]++;
             break;
           case 1:
             moveX[i]--;
             break;
           case 2:
             moveY[i]++;
             break;
           case 3:
             moveY[i]--;
             break;
         }
         if ( moveX[i] > MAX)
           moveX[i] = MAX;
         if (moveX[i] < -MAX)
           moveX[i] = -MAX;
         if (moveY[i] > MAX)
           moveY[i] = MAX;
         if (moveY[i] < -MAX)
           moveY[i] = -MAX;
        }
         repaint();
      }
   }
}