
import java.util.Scanner;
import java.io.*;
import javax.swing.JFileChooser;
import java.text.NumberFormat;

public class Jan16
{
  public static int[] letterFrequency(Scanner scan)
  {
    int[] letterCount = new int[26];
    
    for(int i=0;i< letterCount.length;i++)
      letterCount[i] = 0;
    
    while(scan.hasNext())
    {
      String line = scan.nextLine().toLowerCase();
      for(int i=0;i<line.length();i++)
      {
        char c = line.charAt(i);
        if( (c >= 'a') && ( c <= 'z'))
          letterCount[c-'a']++;
      }
    }
    return letterCount;
  }
  
  public static void main(String[] arg) throws FileNotFoundException
  {
    Scanner scan = null;
    /*
    System.out.println("Please input some text: cntl-D to end");
    scan = new Scanner(System.in);
    */
    JFileChooser chooser = new JFileChooser("../Text");
    int returnValue = chooser.showOpenDialog(null);
    if(returnValue == JFileChooser.APPROVE_OPTION)
    {
      File file = chooser.getSelectedFile();
      scan = new Scanner(file);
    }
    
    int[] result = letterFrequency(scan);
    int total = 0;
    for(int value : result)
      total += value;
    NumberFormat fmt = NumberFormat.getPercentInstance();
    for(int i=0;i<result.length;i++)
      System.out.print((char)(i+'a')+" "+result[i]+" "+
                       fmt.format((double)result[i]/total)+"   "+
                         (i%5 == 4 ? "\n":"\t"));
    System.out.println();
  }
}
    