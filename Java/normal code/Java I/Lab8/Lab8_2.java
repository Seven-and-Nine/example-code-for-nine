import javax.swing.JFrame;

public class Lab8_2
{
  public static void main(String[] arg)
  {
    JFrame frame = new JFrame("Conversions");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(new kilosandmiles());
    frame.pack();
    frame.setVisible(true);
  }
}