//********************************************************************
//  Rebound.java       Java Foundations
//
//  Demonstrates an animation and the use of the Timer class.
//********************************************************************

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Rebound
{
   //-----------------------------------------------------------------
   //  Displays the main frame of the program.
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
      String instructions = "Up/Down to change speed\n"+
        "Left/Right to change number\n"+
        "Space to toggle happy/sad\n"+
        "S to toggle snake\n"+
        "Escape to exit\n";
      JOptionPane.showMessageDialog(null,instructions);
      String name = JOptionPane.showInputDialog("Please input name");
      JFrame frame = new JFrame (name);
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

      frame.getContentPane().add(new ReboundPanel());

      frame.pack();
      frame.setVisible(true);
   }
}