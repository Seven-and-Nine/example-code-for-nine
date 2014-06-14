
import java.util.Scanner;
import java.io.*;
import javax.swing.JFileChooser;
import java.util.Arrays;

public class Apr15
{
  public static void main(String[] arg)  throws FileNotFoundException
  {
    Scanner scan = null;
    File file = null;
    CountList<TokenSequence> tokens = new DoublyLinkedCountList<TokenSequence>();
    JFileChooser chooser = new JFileChooser("../Text");
    
    
    
    
    
    
    
    
    
    
    int returnValue = chooser.showOpenDialog(null);
    if(returnValue == JFileChooser.APPROVE_OPTION)
    {
      file = chooser.getSelectedFile();
      scan = new Scanner(file);
    }
    else
      return;
    
    
    
    
    
    
    
    
    
    String first, second, third;
    second = scan.next().toLowerCase().replaceAll("\\p{Punct}","");
 //   third = scan.next();
    int count = 0;
    while(scan.hasNext())
    {
      first = second;
  //    second = third;
      second = scan.next().toLowerCase().replaceAll("\\p{Punct}","");
      TokenSequence token = new TokenSequence(first,second);
      tokens.add(token);
      count++;
    }
    
    
    
    
    
    
    
    
    TokenSequence[] array = new TokenSequence[tokens.size()];
    int i=0;
    for(TokenSequence token : tokens)
    {
      array[i] = token;
      i++;
    }
    
    Arrays.sort(array, new CountOrdering());
    
    for(i=0;i<25;i++)
      System.out.println(array[i]);
    
    System.out.println("Size of list: "+array.length+"\nTotal count: "+count);
  }
  
}
      