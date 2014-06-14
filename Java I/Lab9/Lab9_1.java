import javax.swing.JFrame;

public class Lab9_1
{
  public static void main(String[] arg)
  {
    JFrame frame = new JFrame("Calculator");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(new calcPanel());
    frame.pack();
    frame.setVisible(true);
  }
}