
import java.io.*;
import javax.swing.JOptionPane;

public class Jan21
{
  private static final int size = 100;
  private static final double alpha = 10.0;
  
  public static int f()
  {
    double total = 0;
    int k=0;
    while( (k<size) )
    {
      total += Math.random();
      k++;
      if( total > alpha)
        return k;
    }
    return size - 1;
  }
    
  
  public static void main(String[] arg) /*throws IOException*/
  {
    int[] table = new int[size];
    int count = 2000;
    
    String outputfile = "output.txt";
    File file = new File(outputfile);
    BufferedWriter writer;
    
    try
    {
      writer = new BufferedWriter( new FileWriter(file) );
    }
    catch( IOException err)
    {
      System.out.println("can't open "+outputfile);
      return;
    }
    
    for(int i=0;i<table.length;i++)
      table[i] = 0;
    
    for(int i=0;i<count;i++)
      table[f()]++;
    
    for(int i=0;i<table.length;i++)
    {
      String output = Integer.toString(i)+" "+table[i];
      try
      {
        writer.write(output);
        writer.newLine();
      }
      catch(IOException err)
      {
        System.out.println("write error");
        return;
      }
    }
    try
    {
      writer.close();
    }
    catch(IOException err)
    {};
    
    int[] test = {1,2,3};
    
 //   test = {3,4,5};
    System.out.println("The arguement vector has length: "+
                       arg.length);
    System.out.println("The vector is: ");
    for(String value : arg)
      System.out.println(value);
    int num = Integer.parseInt(
                    JOptionPane.showInputDialog("input an int"));
    System.out.println(num+1);
  }
}