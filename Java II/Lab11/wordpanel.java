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
  private JButton textMatchButton;
  private Scanner scan;
  private File file;
  private BinaryCountTree<TokenSequence> tree;
  private JFileChooser chooser;
  private Font font;
  private TokenSequence[] X,Y;
    
  public wordpanel()
  {
    scan = null;
    file = null;
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
    textMatchButton = new JButton("Text Match");
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
    textMatchButton.addActionListener(listener);
    
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
    buttons.add(textMatchButton,BorderLayout.WEST);
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
     int N = 0;
     int n = 0;
     public double test(TokenSequence[] X, TokenSequence[] Y, int n)
     {
       if (n<=0)
         return test(X,Y);
    
       TokenSequence[] Z = new TokenSequence[X.length];
       for(int i=0;i<X.length;i++)
         Z[i] = X[i];
       Arrays.sort(Z,new CountOrdering());
       int max = (Z.length>n) ? n : Z.length;
       X = new TokenSequence[max];
       for(int i=0;i<max;i++)
         X[i] = Z[i];
       Arrays.sort(X);
       Z = new TokenSequence[Y.length];
       for(int i=0;i<Y.length;i++)
         Z[i] = Y[i];
       Arrays.sort(Z,new CountOrdering());
       max = (Z.length>n) ? n : Z.length;
       Y = new TokenSequence[max];
       for(int i=0;i<max;i++)
         Y[i] = Z[i];
       Arrays.sort(Y);
       return test(X,Y);
     }
  
  public double test(TokenSequence[] X, TokenSequence[] Y)
  {
    double x = 0;
    double y = 0;
    double total = 0;
    
    for(TokenSequence token: X)
    {
      int value = token.getCount();
      x += value*value;
    }
    x = Math.sqrt(x);
    
    for(TokenSequence token: Y)
    {
      int value = token.getCount();
      y += value*value;
    }
    y = Math.sqrt(y);
    
    int i=0;
    int j=0;
    while( (i<X.length) && (j<Y.length))
    {
      while(Y[j].compareTo(X[i]) < 0)
      {
        j++;
        if( j == Y.length)
         return total/(x*y);
      }
      if( Y[j].compareTo(X[i]) == 0)
      {
        total += Y[j].getCount()*X[i].getCount();
        i++;
        j++;
      }
      else
      {
        while( X[i].compareTo(Y[j]) < 0)
        {
          i++;
          if( i == X.length)
            return total/(x*y);
        }
        if( X[i].compareTo(Y[j]) == 0)
        {
          total += X[i].getCount()*Y[j].getCount();
          i++;
          j++;
        }
      }
     
    }
     return total/(x*y);
  }
  
    public void actionPerformed(ActionEvent event)
    {
      if (event.getSource() == fileButton)
      {
        N = Integer.parseInt(JOptionPane.showInputDialog("How many words should be in the sequences?"));
        n = Integer.parseInt(JOptionPane.showInputDialog("Vector Length?"));
        listTextArea1.setText(null);
        listTextArea2.setText(null);
        
        /* load X */
        scan = null;
        file = null;
        int returnValue = chooser.showOpenDialog(null);
        if(returnValue == JFileChooser.APPROVE_OPTION)
        {
          file = chooser.getSelectedFile();
          try
          {
            scan = new Scanner(file);
          }
          catch(FileNotFoundException e)
          {
            System.err.println("file not found");
            return;
          }
        }
        else
          return;
    
        String[] inputarray = new String[N];
        tree = new BinaryCountTree<TokenSequence>();
        for(int i=1;i<N;i++)
          inputarray[i] = scan.next().toLowerCase().replaceAll("\\p{Punct}","");
 
        int count = 0;
        while(scan.hasNext())
        {
          for(int i=1;i<N;i++)
            inputarray[i-1] = inputarray[i];
          inputarray[N-1] = scan.next().toLowerCase().replaceAll("\\p{Punct}","");
          TokenSequence token = new TokenSequence(inputarray);
          tree.add(token);
          count++;
        }
        scan.close();
        
        System.out.println(tree);
        
        X = new TokenSequence[tree.size()];
        int i=0;
        for(TokenSequence token : tree)
        {
          X[i] = token;
          i++;
        }
        
        // load Y 
        scan = null;
        file = null;
        tree = null;
        returnValue = chooser.showOpenDialog(null);
        if(returnValue == JFileChooser.APPROVE_OPTION)
        {
          file = chooser.getSelectedFile();
          try
          {
            scan = new Scanner(file);
          }
          catch(FileNotFoundException e)
          {
            System.err.println("file not found");
            return;
          }
        }
        else
          return;
    
        inputarray = new String[N];
        tree = new BinaryCountTree<TokenSequence>();
        for(i=1;i<N;i++)
          inputarray[i] = scan.next().toLowerCase().replaceAll("\\p{Punct}","");
 
        count = 0;
        while(scan.hasNext())
        {
          for(i=1;i<N;i++)
            inputarray[i-1] = inputarray[i];
  
          inputarray[N-1] = scan.next().toLowerCase().replaceAll("\\p{Punct}","");
          TokenSequence token = new TokenSequence(inputarray);
          tree.add(token);
          count++;
        }
        scan.close();
    
        Y = new TokenSequence[tree.size()];
        i=0;
        for(TokenSequence token : tree)
        {
          Y[i] = token;
          i++;
        }
        
        //output
        Arrays.sort(X, new CountOrdering());
        Arrays.sort(Y, new CountOrdering());
        for(i=0;i<X.length;i++)
          listTextArea1.append(X[i] + "\n");
        for(i=0;i<Y.length;i++)
          listTextArea2.append(Y[i] + "\n");
        totalWordsLabel.setText("Total Words: " + Integer.toString(X.length*N) + " for file one, and " + Integer.toString(Y.length*N) + " for file two.");
        listSizeLabel.setText("List Size: " + Integer.toString(X.length) + " for file one, and " + Integer.toString(Y.length) + " for file two.");  
      }
      
      if (event.getSource() == alphaButton)
      {
        boolean done = false;
        while(!done)
        {
            done=true;   
            for(int i=0;i<X.length-1;i++)
            {
                if(!(X[i]==null))
                {
                    String name1=X[i].toString(); String name2=X[i+1].toString();
                    if(name1!=null&&name2!=null)
                    {
                        int num=name1.compareTo(name2);
                        if(num>0)
                        { 
                          TokenSequence[] temp = new TokenSequence[] {X[i]}; //temp is a String that was declared earlier
                            X[i]=X[i+1];
                            X[i+1]=temp[0];
                            done=false; 
                        }
                    }
                }
            }
        }
        
        done = false;
        while(!done)
        {
            done=true;   
            for(int i=0;i<Y.length-1;i++)
            {
                if(!(Y[i]==null))
                {
                    String name1=Y[i].toString(); String name2=Y[i+1].toString();
                    if(name1!=null&&name2!=null)
                    {
                        int num=name1.compareTo(name2);
                        if(num>0)
                        { 
                          TokenSequence[] temp = new TokenSequence[] {Y[i]}; //temp is a String that was declared earlier
                            Y[i]=Y[i+1];
                            Y[i+1]=temp[0];
                            done=false; 
                        }
                    }
                }
            }
        }
        
        listTextArea1.setText(null);
        for(int i=0;i<X.length;i++)
          listTextArea1.append(X[i] + "\n");
        listTextArea2.setText(null);
        for(int i=0;i<Y.length;i++)
          listTextArea2.append(Y[i] + "\n");
      }
      if (event.getSource() == mostButton)
      {
        Arrays.sort(X, new CountOrdering());
        listTextArea1.setText(null);
        for(int i=0;i<X.length;i++)
          listTextArea1.append(X[i] + "\n");
        Arrays.sort(Y, new CountOrdering());
        listTextArea2.setText(null);
        for(int i=0;i<Y.length;i++)
          listTextArea2.append(Y[i] + "\n");
      }
     if (event.getSource() == textMatchButton)
      {        
        Arrays.sort(X, new CountOrdering());
        Arrays.sort(Y, new CountOrdering());
        textMatchButton.setText(Double.toString(test(X, Y, n)));
        System.out.println(test(X, Y, n));
     }
    }
  }
}