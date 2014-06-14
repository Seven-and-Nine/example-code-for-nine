
import java.util.Scanner;
import java.io.*;
import javax.swing.JFileChooser;

public class  TextReader2
{
  public static void main(String[] arg) throws FileNotFoundException
  {
    Scanner scan = null;
    File file = null;
    JFileChooser chooser = new JFileChooser("../Text");
    int returnValue = chooser.showOpenDialog(null);
    if(returnValue == JFileChooser.APPROVE_OPTION)
    {
      file = chooser.getSelectedFile();
      scan = new Scanner(file);
    }
    else
      return;
    int count = 0;
    OrderedList<String> tokens = new DoublyLinkedList<String>();
    while(scan.hasNext())
    {
      count++;
      String token = scan.next().toLowerCase();
      if(!tokens.contains(token))
        tokens.add(token);
    }
    System.out.println(chooser.getName(file)+" has "+count+" tokens.");
    scan.close();
//    while(!tokens.isEmpty())
//      System.out.print(tokens.removeFront()+" ");
    for(String token: tokens)
      System.out.print(token+" ");
    System.out.println("\n the current size of tokens is: "+tokens.size());
  }
}
    