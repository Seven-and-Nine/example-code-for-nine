import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class stopwatch extends JPanel
{
  private JButton startbutton;
  private JButton resetbutton;
  private JButton stopbutton;
  private JLabel timerlabel;
  private Timer timer;
  private int h = 0, m = 0, s = 0, seconds = 0;
  private JPanel labelpanel, buttonspanel;
 
  public stopwatch()
  {
    
    labelpanel = new JPanel();
    add(labelpanel);
    labelpanel.setLayout(new BorderLayout());
    buttonspanel = new JPanel();
    add(buttonspanel);
    Font font = new Font("Helvetica",0,16);
    
    timerlabel = new JLabel("Press start!");
    timerlabel.setFont(font);
    timerlabel.setHorizontalAlignment(SwingConstants.CENTER);
    
    labelpanel.setBackground(Color.RED.brighter());
    labelpanel.add(timerlabel, BorderLayout.CENTER);
    labelpanel.setPreferredSize(new Dimension(400,250));
    
    ButtonListener buttonlistener = new ButtonListener();
    TimerListener timerlistener = new TimerListener();
    timer = new Timer(1000, timerlistener);
    
    startbutton = new JButton("Start");
    startbutton.addActionListener(buttonlistener);
    resetbutton = new JButton("Reset");
    resetbutton.addActionListener(buttonlistener);
    stopbutton = new JButton("Stop");
    stopbutton.addActionListener(buttonlistener);
    startbutton.setPreferredSize(new Dimension(125, 30));
    resetbutton.setPreferredSize(new Dimension(125, 30));
    stopbutton.setPreferredSize(new Dimension(125, 30));
    
    
    buttonspanel.setBackground(Color.MAGENTA.brighter());
    buttonspanel.add(startbutton);
    buttonspanel.add(resetbutton);
    buttonspanel.add(stopbutton);
    buttonspanel.setPreferredSize(new Dimension(400,50));
    
    setPreferredSize(new Dimension(400,300));
  }
  
  private class ButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      if( event.getSource() == startbutton)
        {
        timer.start();
        timerlabel.setText("00:00:00");
        labelpanel.setBackground(Color.GREEN.brighter());
      }
      
      if( event.getSource() == resetbutton)
      {
        seconds = 0;
        timerlabel.setText("00:00:00");
      }
      
      if( event.getSource() == stopbutton)
      {
        timer.stop();
        labelpanel.setBackground(Color.RED.brighter());
      }
    }
  }
   
  private class TimerListener implements ActionListener
  {
    DecimalFormat dec = new DecimalFormat("00");
    
    public void actionPerformed(ActionEvent event)
    {
      seconds++;
      h = (seconds/3600);
      m = (seconds%3600)/60;
      s = seconds%60;
      timerlabel.setText(dec.format(h)+":"+dec.format(m)+":"+dec.format(s));
    }
  }
}