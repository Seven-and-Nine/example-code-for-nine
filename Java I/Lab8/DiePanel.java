import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class DiePanel extends JPanel
{
  private JButton button1;
  private JLabel label1;
  private Random rnd;
  
  public DiePanel()
  {
    rnd = new Random();
    button1 = new JButton("Click to Roll");
    ButtonListener listener = new ButtonListener();
    button1.addActionListener(listener);
    add(button1);
    
    label1 = new JLabel("Click the button to roll.");
    add(label1);
    setPreferredSize(new Dimension(400,200));
    setBackground(Color.MAGENTA);
  }
  
  private class ButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      int die = rnd.nextInt(6)+1;
      label1.setText("You rolled a "+die);
    }
  }
}