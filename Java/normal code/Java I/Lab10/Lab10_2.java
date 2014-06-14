import javax.swing.JFrame;

public class Lab10_2
{
  public static void main(String[] arg)
  {
    JFrame frame = new JFrame("Countdown");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(new countdown());
    frame.pack();
    frame.setVisible(true);
  }
}