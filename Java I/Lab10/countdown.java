import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class countdown extends JPanel
{
  private JTextField hoursfield, minutesfield, secondsfield;
  private JButton startbutton, stopbutton;
  private JLabel timerlabel;
  private Timer timer;
  private int h = 0, m = 0, s = 0, seconds = 0;
  private JPanel labelpanel, buttonspanel,textpanel;
 
  public countdown()
  {
    
    labelpanel = new JPanel();
    add(labelpanel);
    labelpanel.setLayout(new BorderLayout());
    textpanel = new JPanel();
    add(textpanel);
    buttonspanel = new JPanel();
    add(buttonspanel);
    Font font = new Font("Helvetica",0,16);
    
    hoursfield = new JTextField(5);
    minutesfield = new JTextField(5);
    secondsfield = new JTextField(5);
    
    timerlabel = new JLabel("Enter the time and press start!");
    timerlabel.setFont(font);
    timerlabel.setHorizontalAlignment(SwingConstants.CENTER);
    
    labelpanel.setBackground(Color.RED.brighter());
    labelpanel.add(timerlabel, BorderLayout.CENTER);
    labelpanel.setPreferredSize(new Dimension(400,150));
    
    textpanel.add(new JLabel("Hours"));
    textpanel.add(hoursfield);
    textpanel.add(new JLabel("Minutes"));
    textpanel.add(minutesfield);
    textpanel.add(new JLabel("Seconds"));
    textpanel.add(secondsfield);
    labelpanel.setPreferredSize(new Dimension(400,50));
    
    ButtonListener buttonlistener = new ButtonListener();
    TimerListener timerlistener = new TimerListener();
    timer = new Timer(1000, timerlistener);
    
    startbutton = new JButton("Start");
    startbutton.addActionListener(buttonlistener);
    stopbutton = new JButton("Stop");
    stopbutton.addActionListener(buttonlistener);
    startbutton.setPreferredSize(new Dimension(190, 30));
    stopbutton.setPreferredSize(new Dimension(190, 30));
    
    buttonspanel.add(startbutton);
    buttonspanel.add(stopbutton);
    buttonspanel.setPreferredSize(new Dimension(400,50));
    
    setPreferredSize(new Dimension(400,150));
  }
  
  private class ButtonListener implements ActionListener
  {
    private DecimalFormat dec = new DecimalFormat("00");
    private boolean stuff = true;
    
    public void actionPerformed(ActionEvent event)
    {
      if( event.getSource() == startbutton)
        {
        if (stuff)
        {
        seconds = ((Integer.parseInt(hoursfield.getText()) * 60) * 60) + (Integer.parseInt(minutesfield.getText()) * 60)+ Integer.parseInt(secondsfield.getText());
        if (seconds < 0)
          seconds = 0;
        timer.start();
        h = (seconds/3600);
        m = (seconds%3600)/60;
        s = seconds%60;
        timerlabel.setText(dec.format(h)+":"+dec.format(m)+":"+dec.format(s));
        labelpanel.setBackground(Color.GREEN.brighter());
        }
        else
        {
          labelpanel.setBackground(Color.GREEN.brighter());
          stuff = stuff ^ true;
          timer.start();
        }
      }
      
      if( event.getSource() == stopbutton)
      {
        timer.stop();
        labelpanel.setBackground(Color.RED.brighter());
        stuff = stuff ^ true;
      }
    }
  }
   
  private class TimerListener implements ActionListener
  {
    private DecimalFormat dec = new DecimalFormat("00");
    private boolean stuff = true;
    
    public void actionPerformed(ActionEvent event)
    {
      if (seconds > 0)
      {
      seconds--;
      h = (seconds/3600);
      m = (seconds%3600)/60;
      s = seconds%60;
      timerlabel.setText(dec.format(h)+":"+dec.format(m)+":"+dec.format(s));
      }
      else if (seconds == 0)
      {
        stuff = stuff ^ true;
        if (stuff)
          labelpanel.setBackground(Color.RED.brighter());
        if (!stuff)
          labelpanel.setBackground(Color.MAGENTA.brighter());
      }
    }
  }
}