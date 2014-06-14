import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class kilosandmiles extends JPanel
{
  private JLabel milesLabel;
  private JLabel kiloLabel;
  private JTextField kilosField;
  
  private JLabel kilosLabel;
  private JLabel mileLabel;
  private JTextField milesField;
  
  public kilosandmiles()
  {
    JPanel kilostomiles = new JPanel();
    add(kilostomiles);
    JPanel milestokilos = new JPanel();
    add(milestokilos);
    Font font = new Font("Helvetica",0,16);
    
    kilosLabel = new JLabel("Kilometers: ");
    kilosLabel.setFont(font);
    mileLabel = new JLabel("Miles:");
    mileLabel.setFont(font);
    milesField = new JTextField(10);
    
    milesLabel = new JLabel("Miles: ");
    milesLabel.setFont(font);
    kiloLabel = new JLabel("Kilometers:");
    kiloLabel.setFont(font);
    kilosField = new JTextField(10);
    
    TextListener textlistener = new TextListener();
    
    kilosField.addActionListener(textlistener);
    milestokilos.setBackground(Color.YELLOW.brighter());
    milestokilos.add(kiloLabel);
    milestokilos.add(kilosField);
    milestokilos.add(milesLabel);
    milestokilos.setPreferredSize(new Dimension(400,200));
    
    milesField.addActionListener(textlistener);
    kilostomiles.setBackground(Color.MAGENTA.brighter());
    kilostomiles.add(mileLabel);
    kilostomiles.add(milesField);
    kilostomiles.add(kilosLabel);
    kilostomiles.setPreferredSize(new Dimension(400,200));
    
    setPreferredSize(new Dimension(400,400));
  }
  
  private class TextListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
       if( event.getSource() == kilosField)
      {
        double kilos =   Double.parseDouble(kilosField.getText());
        double miles = kilos * 0.62137;
        milesLabel.setText("Miles: "+Double.toString(miles));
      }
      
       if( event.getSource() == milesField)
      {
        double miles =   Double.parseDouble(milesField.getText());
        double kilos = miles / 0.62137;
        kilosLabel.setText("Kilometers: "+Double.toString(kilos));
      }
    }
  }
      
  
}