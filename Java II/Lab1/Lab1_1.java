
import java.io.*;
import javax.swing.JOptionPane;
import java.util.Random;

public class Lab1_1
{
  private static final int sides = 6;
  private static Random rnd = new Random();
    
  public static int diceroll (int M)
  {
    int[] dice = new int[M];
    int dicerolltotal = 0;
    for (int i = 0; i<M; i++)
      dice[i] = rnd.nextInt(sides)+1;
    for (int value : dice)
      dicerolltotal += value;
    return dicerolltotal;
  }
  
  public static void main(String[] arg)
  {
    int howmany = Integer.parseInt(JOptionPane.showInputDialog("How many dice?"));
    int count = Integer.parseInt(JOptionPane.showInputDialog("How many times?"));
    int[] stuff = new int[(howmany*6)+1];
    
    String outputfile = JOptionPane.showInputDialog("Output file?");
    File file = new File(outputfile);
    BufferedWriter writer;
    
    try
    {
      writer = new BufferedWriter( new FileWriter(file) );
    }
    catch( IOException err)
    {
      System.out.println("не может открыть файл "+outputfile);
      return;
    }
    
    for(int i=0;i<stuff.length;i++)
      stuff[i] = 0;
    
    for(int i=0;i<count;i++)
      stuff[diceroll(howmany)]++;
    
    for(int i=0;i<stuff.length;i++)
    {
      String output = Integer.toString(i)+" "+stuff[i];
      try
      {
        writer.write(output);
        writer.newLine();
      }
      catch(IOException err)
      {
        System.out.println("ошибка писатель");
        return;
      }
    }
    try
    {
      writer.close();
    }
    catch(IOException err)
    {
      System.out.println("писатель ошибки выход");
    };
  }
}