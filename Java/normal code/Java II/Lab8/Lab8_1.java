import javax.swing.JFrame;

public class Lab8_1
{
  public static void main(String[] arg)
  {
    JFrame frame = new JFrame("Text and Words :)");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(new wordpanel());
    frame.pack();
    frame.setVisible(true);
  }
}