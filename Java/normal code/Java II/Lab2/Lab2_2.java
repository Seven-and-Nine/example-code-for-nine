import javax.swing.*;

public class Lab2_2
{ 
  public static int exponential(int base, int exponent)
  {
    if (exponent == 1)
      return base;
    return base*exponential(base,exponent-1);
  }
  
  public static void main(String[] arg)
  {
   int base = Integer.parseInt(JOptionPane.showInputDialog("Enter a integer for the base."));
   int exponent = Integer.parseInt(JOptionPane.showInputDialog("Enter a integer for the exponent."));
   System.out.println("The answer is: " + exponential(base,exponent));
  }
}