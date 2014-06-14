
import java.util.Scanner;
import java.io.*;
import javax.swing.JFileChooser;
import java.util.Arrays;

public class May1
{
  public static void main(String[] arg) 
  {
    int N;
    TokenSequence[] X,Y;
    Scanner scan = null;
    File file = null;
    scan = new Scanner(System.in);
    System.out.println("Please input N: ");
     N = scan.nextInt();
    System.out.println("Please input the vector length: ");
    int n = scan.nextInt();
   
    BinaryCountTree<TokenSequence> tree = new BinaryCountTree<TokenSequence>();
    
    /* load X */
    JFileChooser chooser = new JFileChooser("./Text");
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
    
    X = new TokenSequence[tree.size()];
    int i=0;
    for(TokenSequence token : tree)
    {
      X[i] = token;
      System.out.println(token);
      i++;
    }
   // load Y 
    chooser = new JFileChooser("./Text");
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
    System.out.println("The match is "+ TextMatch.test(X,Y,n));
    
  }
  
}
      