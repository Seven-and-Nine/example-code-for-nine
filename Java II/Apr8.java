
import java.util.Scanner;
import java.io.*;
import javax.swing.JFileChooser;
import java.util.List;
import java.util.LinkedList;

public class Apr8
{
  public static void main(String[] arg)  throws FileNotFoundException
  {
    Scanner scan = null;
    File file = null;
    List<TokenSequence> tokens = new LinkedList<TokenSequence>();
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
    second = scan.next().toLowerCase();
 //   third = scan.next();
    while(scan.hasNext())
    {
      first = second;
  //    second = third;
      second = scan.next().toLowerCase();
      TokenSequence token = new TokenSequence(first,second);
      tokens.add(token);
    }
    
    for(TokenSequence token : tokens)
      System.out.println(token);
  }
  
}
      