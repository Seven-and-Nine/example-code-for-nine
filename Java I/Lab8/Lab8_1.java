import javax.swing.JFrame;

public class Lab8_1
{
  public static void main(String[] arg)
  {
    JFrame frame = new JFrame("Roll a die");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    DiePanel panel = new DiePanel();
    
    frame.getContentPane().add(panel);
    frame.pack();
    frame.setVisible(true);
  }
}