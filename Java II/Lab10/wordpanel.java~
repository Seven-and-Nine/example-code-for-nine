import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.*;
import java.io.*;

public class wordpanel extends JPanel
{
  private JLabel listSizeLabel;
  private JLabel totalWordsLabel;
  private JTextArea listTextArea;
  private JButton fileButton;
  private Scanner scan;
  private File file;
  private CountList<TokenSequence> tokens;
  private JFileChooser chooser;
  private Font font;
    
  public wordpanel()
  {
    scan = null;
    file = null;
    tokens = new DoublyLinkedCountList<TokenSequence>();
    chooser = new JFileChooser("../Text");
    font = new Font("Helvetica",0,16);
    
    listSizeLabel = new JLabel("List Size: ");
    listSizeLabel.setFont(font);
    totalWordsLabel = new JLabel("Total Words: ");
    totalWordsLabel.setFont(font);
    listTextArea = new JTextArea( "Click the Open File button to begin.");
    listTextArea.setFont(new Font("Helvetica",0,16));
    listTextArea.setLineWrap(true);
    listTextArea.setWrapStyleWord(true);
    fileButton = new JButton("Open File");
    DefaultCaret caret = (DefaultCaret)listTextArea.getCaret();
    caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setViewportView(listTextArea);
    
    ButtonListener listener = new ButtonListener();
    fileButton.addActionListener(listener);
    
    JPanel labels = new JPanel(new BorderLayout());
    setLayout(new BorderLayout());
    add(labels,BorderLayout.NORTH);
    setBackground(Color.MAGENTA.brighter());
    labels.setBackground(Color.MAGENTA.brighter());
    labels.add(listSizeLabel,BorderLayout.NORTH);
    labels.add(totalWordsLabel,BorderLayout.SOUTH);
    add(scrollPane, BorderLayout.CENTER);
    add(fileButton,BorderLayout.SOUTH);
    setPreferredSize(new Dimension(400,400));
    labels.setPreferredSize(new Dimension(400,50));
  }
  
   private class ButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      int num = Integer.parseInt(JOptionPane.showInputDialog("How many words should be in the sequences?"));
      listTextArea.setText(null);
      //listTextArea.append("You clicked the button");
      int returnValue = chooser.showOpenDialog(null);
      if(returnValue == JFileChooser.APPROVE_OPTION)
      {
        file = chooser.getSelectedFile();
        try 
        {
          scan = new Scanner(file);
        }
        catch (Exception e)
        {
          listTextArea.setText("File not found.");
          return;
        }
      }
      else
        return;
      
      java.util.List<String> sequence = new ArrayList<String>();
      int count = 0;
      for (int i = 0; i < (num-1); i++)
        sequence.add(scan.next().toLowerCase().replaceAll("\\p{Punct}",""));
      while(scan.hasNext())
      {
        sequence.add(scan.next().toLowerCase().replaceAll("\\p{Punct}",""));
        String[] sat = sequence.toArray(new String[0]);
        TokenSequence token = new TokenSequence(sat);
        tokens.add(token);
        count++;
        java.util.List<String> tmpseq = new ArrayList<String>();
        Iterator itr= sequence.iterator();
        itr.next();
        while(itr.hasNext())
          tmpseq.add(itr.next().toString());
        sequence = tmpseq;
      }
      TokenSequence[] array = new TokenSequence[tokens.size()];
      int i=0;
      for(TokenSequence token : tokens)
      {
        array[i] = token;
        i++;
      }
      Arrays.sort(array, new CountOrdering());
      try
      {
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("Output.txt"))); 
        writer.write("Total Words: " + Integer.toString(count));
        writer.newLine();
        writer.write("List Size: " + Integer.toString(array.length));
        writer.newLine();
        writer.newLine();
        for(i=0;i<array.length;i++)
        {
          listTextArea.append(array[i] + "\n");
          writer.write(array[i].toString());
          writer.newLine();
        }
        writer.flush();
        writer.close();
      } catch (Exception e) {listTextArea.setText(e.toString());}
      totalWordsLabel.setText("Total Words: " + Integer.toString(count));
      listSizeLabel.setText("List Size: " + Integer.toString(array.length));  
    }
  }
}