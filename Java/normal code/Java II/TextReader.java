
import java.util.Scanner;
import java.io.*;
import javax.swing.JFileChooser;

public class  TextReader
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
    while(scan.hasNext())
    {
      count++;
      System.out.println(scan.next().toLowerCase());
    }
    System.out.println(chooser.getName(file)+" has "+count+" tokens.");
    scan.close();
  }
}
    