import javax.swing.*;

public class Lab2_1
{ 
  public static String reverse(String rt)
  {
    if (rt.length() == 1 || rt.length() == 0)
      return rt;
    return rt.substring(rt.length()-1, rt.length()) + reverse(rt.substring(0,rt.length() - 1));
  }
  
  public static void main(String[] arg)
  {
   String reversethis = JOptionPane.showInputDialog("Enter a string you wish to reverse.");
   System.out.println("Your string was: " + reversethis + ". In reverse that is: " + reverse(reversethis));
  }
}