import javax.swing.*;
import javax.swing.JOptionPane.*;
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
  private JTextArea listTextArea1;
  private JTextArea listTextArea2;
  private JButton fileButton;
  private JButton alphaButton;
  private JButton mostButton;
  private Scanner scan1;
  private Scanner scan2;
  private File file1;
  private File file2;
  private CountList<TokenSequence> tokens1;
  private CountList<TokenSequence> tokens2;
  private JFileChooser chooser;
  private Font font;
    
  public wordpanel()
  {
    scan1 = null;
    scan2 = null;
    file1 = null;
    tokens1 = new DoublyLinkedCountList<TokenSequence>();
    file2 = null;
    tokens2 = new DoublyLinkedCountList<TokenSequence>();
    chooser = new JFileChooser("../Text");
    font = new Font("Helvetica",0,16);
    
    listSizeLabel = new JLabel("List Size: ");
    listSizeLabel.setFont(font);
    totalWordsLabel = new JLabel("Total Words: ");
    totalWordsLabel.setFont(font);
    listTextArea1 = new JTextArea( "First File Goes Here.");
    listTextArea1.setFont(new Font("Helvetica",0,16));
    listTextArea1.setLineWrap(true);
    listTextArea1.setWrapStyleWord(true);
    listTextArea2 = new JTextArea( "Second File Goes Here.");
    listTextArea2.setFont(new Font("Helvetica",0,16));
    listTextArea2.setLineWrap(true);
    listTextArea2.setWrapStyleWord(true);
    fileButton = new JButton("Open File");
    alphaButton = new JButton("Sort alphabeticly");
    mostButton = new JButton("Sort by # of reoccurences");
    DefaultCaret caret1 = (DefaultCaret)listTextArea1.getCaret();
    caret1.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
    DefaultCaret caret2 = (DefaultCaret)listTextArea2.getCaret();
    caret2.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
    JScrollPane scrollPane1 = new JScrollPane();
    JScrollPane scrollPane2 = new JScrollPane();
    scrollPane1.setViewportView(listTextArea1);
    scrollPane2.setViewportView(listTextArea2);
    
    ButtonListener listener = new ButtonListener();
    fileButton.addActionListener(listener);
    alphaButton.addActionListener(listener);
    mostButton.addActionListener(listener);
    
    JPanel labels = new JPanel(new BorderLayout());
    JPanel buttons = new JPanel(new BorderLayout());
    JPanel text1 = new JPanel(new BorderLayout());
    JPanel text2 = new JPanel(new BorderLayout());
    setLayout(new BorderLayout());
    add(labels,BorderLayout.NORTH);
    add(text1,BorderLayout.WEST);
    add(text2,BorderLayout.EAST);
    add(buttons,BorderLayout.SOUTH);
    setBackground(Color.CYAN.brighter());
    labels.setBackground(Color.MAGENTA.brighter());
    labels.add(listSizeLabel,BorderLayout.NORTH);
    labels.add(totalWordsLabel,BorderLayout.SOUTH);
    text1.add(scrollPane1, BorderLayout.CENTER);
    text2.add(scrollPane2, BorderLayout.CENTER);
    buttons.add(fileButton,BorderLayout.NORTH);
    buttons.add(alphaButton,BorderLayout.CENTER);
    buttons.add(mostButton,BorderLayout.SOUTH);
    setPreferredSize(new Dimension(400,400));
    labels.setPreferredSize(new Dimension(400,50));
    buttons.setPreferredSize(new Dimension(400,75));
    text1.setPreferredSize(new Dimension(200,350));
    text2.setPreferredSize(new Dimension(200,350));
  }
  
   private class ButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      if (event.getSource() == fileButton)
      {
        int num = Integer.parseInt(JOptionPane.showInputDialog("How many words should be in the sequences?"));
        listTextArea1.setText(null);
        listTextArea2.setText(null);
        //listTextArea.append("You clicked the button");
        int returnValue = chooser.showOpenDialog(null);
        if(returnValue == JFileChooser.APPROVE_OPTION)
        {
          file1 = chooser.getSelectedFile();
          try 
          {
            scan1 = new Scanner(file1);
          }
          catch (Exception e)
          {
            listTextArea1.setText("File not found.");
            return;
          }
        }
        else
          return;
      
        returnValue = chooser.showOpenDialog(null);
        if(returnValue == JFileChooser.APPROVE_OPTION)
        {
          file2 = chooser.getSelectedFile();
          try 
          {
            scan2 = new Scanner(file2);
          }
          catch (Exception e)
          {
            listTextArea2.setText("File not found.");
            return;
          }
        }
        else
          return;
        //file1
        java.util.List<String> sequence1 = new ArrayList<String>();
        int count1 = 0;
        for (int i = 0; i < (num-1); i++)
          sequence1.add(scan1.next().toLowerCase().replaceAll("\\p{Punct}",""));
        while(scan1.hasNext())
        {
          sequence1.add(scan1.next().toLowerCase().replaceAll("\\p{Punct}",""));
          String[] sat1 = sequence1.toArray(new String[0]);
          TokenSequence token1 = new TokenSequence(sat1);
          tokens1.add(token1);
          count1++;
          java.util.List<String> tmpseq1 = new ArrayList<String>();
          Iterator itr1= sequence1.iterator();
          itr1.next();
          while(itr1.hasNext())
            tmpseq1.add(itr1.next().toString());
          sequence1 = tmpseq1;
        }
        TokenSequence[] array1 = new TokenSequence[tokens1.size()];
        int i=0;
        for(TokenSequence token : tokens1)
        {
          array1[i] = token;
          i++;
        }
      
        //file2
        java.util.List<String> sequence2 = new ArrayList<String>();
        int count2 = 0;
        for (i = 0; i < (num-1); i++)
          sequence2.add(scan2.next().toLowerCase().replaceAll("\\p{Punct}",""));
        while(scan2.hasNext())
        {
          sequence2.add(scan2.next().toLowerCase().replaceAll("\\p{Punct}",""));
          String[] sat2 = sequence2.toArray(new String[0]);
          TokenSequence token2 = new TokenSequence(sat2);
          tokens2.add(token2);
          count2++;
          java.util.List<String> tmpseq2 = new ArrayList<String>();
          Iterator itr2 = sequence2.iterator();
          itr2.next();
          while(itr2.hasNext())
            tmpseq2.add(itr2.next().toString());
          sequence2 = tmpseq2;
        }
        TokenSequence[] array2 = new TokenSequence[tokens2.size()];
        i=0;
        for(TokenSequence token : tokens2)
        {
          array2[i] = token;
          i++;
        }
        //output
        Arrays.sort(array1, new CountOrdering());
        Arrays.sort(array2, new CountOrdering());
        try
        {
          BufferedWriter writer = new BufferedWriter(new FileWriter(new File("Output.txt"))); 
          writer.write("Total Words: " + Integer.toString(count1) + " for file one, and " + Integer.toString(count2) + " for file two.");
          writer.newLine();
          writer.write("List Size: " + Integer.toString(array1.length) + " for file one, and " + Integer.toString(array2.length) + " for file two.");
          writer.newLine();
          writer.newLine();
          for(i=0;i<array1.length;i++)
          {
            listTextArea1.append(array1[i] + "\n");
            writer.write(array1[i].toString());
            writer.newLine();
          }
          writer.newLine();
          writer.newLine();
          writer.write("------------------//NEXT FILE//----------------------");
          writer.newLine();
          writer.newLine();
          writer.flush();
          for(i=0;i<array2.length;i++)
          {
            listTextArea2.append(array2[i] + "\n");
            writer.write(array2[i].toString());
            writer.newLine();
          }
          writer.flush();
          writer.close();
        } catch (Exception e) {final JOptionPane optionPane = new JOptionPane(e.toString());}
        totalWordsLabel.setText("Total Words: " + Integer.toString(count1) + " for file one, and " + Integer.toString(count2) + " for file two.");
        listSizeLabel.setText("List Size: " + Integer.toString(array1.length) + " for file one, and " + Integer.toString(array2.length) + " for file two.");  
      }
      if (event.getSource() == alphaButton)
      {
        TokenSequence[] array1 = new TokenSequence[tokens1.size()];
        int i=0;
        for(TokenSequence token : tokens1)
        {
          array1[i] = token;
          i++;
        }
        
        TokenSequence[] array2 = new TokenSequence[tokens2.size()];
        i=0;
        for(TokenSequence token : tokens2)
        {
          array2[i] = token;
          i++;
        }

        boolean done = false;
        while(!done)
        {
            done=true;   
            for(i=0;i<array1.length-1;i++)
            {
                if(!(array1[i]==null))
                {
                    String name1=array1[i].toString(); String name2=array1[i+1].toString();
                    if(name1!=null&&name2!=null)
                    {
                        int num=name1.compareTo(name2);
                        if(num>0)
                        { 
                          TokenSequence[] temp = new TokenSequence[] {array1[i]}; //temp is a String that was declared earlier
                            array1[i]=array1[i+1];
                            array1[i+1]=temp[0];
                            done=false; 
                        }
                    }
                }
            }
        }
        
        listTextArea1.setText(null);
        for(i=0;i<array1.length;i++)
          listTextArea1.append(array1[i] + "\n");
        listTextArea2.setText(null);
        for(i=0;i<array2.length;i++)
          listTextArea2.append(array2[i] + "\n");
      }
      if (event.getSource() == mostButton)
      {
          TokenSequence[] array1 = new TokenSequence[tokens1.size()];
        int i=0;
        for(TokenSequence token : tokens1)
        {
          array1[i] = token;
          i++;
        }
        
        TokenSequence[] array2 = new TokenSequence[tokens2.size()];
        i=0;
        for(TokenSequence token : tokens2)
        {
          array2[i] = token;
          i++;
        }
        Arrays.sort(array1, new CountOrdering());
        listTextArea1.setText(null);
        for(i=0;i<array1.length;i++)
          listTextArea1.append(array1[i] + "\n");
        Arrays.sort(array2, new CountOrdering());
        listTextArea2.setText(null);
        for(i=0;i<array2.length;i++)
          listTextArea2.append(array2[i] + "\n");
      }
    }
  }
}