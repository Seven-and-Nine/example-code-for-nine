import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class calcPanel extends JPanel
{
  private JTextField firstfield;
  private JTextField secondfield;
  private JButton addbutton, multiplybutton;
  private JLabel answerlabel;
  
  public calcPanel()
  {
    addbutton = new JButton("+");
    multiplybutton = new JButton("*");
    ButtonListener listener = new ButtonListener();
    addbutton.addActionListener(listener);
    multiplybutton.addActionListener(listener);
    
    JPanel texts = new JPanel();
    add(texts);
    JPanel buttons = new JPanel();
    add(buttons);
    JPanel answers = new JPanel();
    add(answers);
    Font font = new Font("Helvetica",0,16);
    
    firstfield = new JTextField(10);
    secondfield = new JTextField(10);
    answerlabel = new JLabel("Answer: ");
    
    
    texts.setBackground(new Color(255,020,147));
    texts.add(firstfield);
    texts.add(secondfield);
    texts.setPreferredSize(new Dimension(300,50));
    
    buttons.setBackground(new Color(253,0, 0));
    buttons.add(addbutton);
    buttons.add(multiplybutton);
    buttons.setPreferredSize(new Dimension(300,50));
    
    answers.setBackground(new Color(253, 246, 250));
    answers.add(answerlabel);
    answers.setPreferredSize(new Dimension(300,50));
    
    setPreferredSize(new Dimension(300,150));
  }
  
  private class ButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      int one =   Integer.parseInt(firstfield.getText());
      int two =   Integer.parseInt(secondfield.getText());
      if( event.getSource() == addbutton)
        answerlabel.setText("Answer: "+Integer.toString((one+two)));
      if( event.getSource() == multiplybutton)
        answerlabel.setText("Answer: "+Integer.toString((one*two)));
    }
  }
      
  
}