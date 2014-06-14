
import java.io.*;
import java.util.Random;

public class Lab3_1
{
  
  private static Random rnd = new Random();
  private static final int low = 35;
  private static final int high = 200;
  
  public static long flip(int n)
  {
    int count = 0;
    long total = 0;
    while(count<n)
    {
      total++;
      if(rnd.nextBoolean() == true)
        count++;
      else
        count = 0;
    }
    return total;
  }
  
  
  public static void main(String[] arg) throws IOException
  {
    long start, end, elapsed;
    long value;
    BufferedWriter writer = new BufferedWriter(
           new FileWriter(new File("Lab3_1.txt")));                                    
    
    double total;
    double average;
    int repeat = 20;
    for(int i=low;i<high;i++)
    {
      total = 0;
      for(int j=0;j<repeat;j++)
      {
        start = System.nanoTime();
        value = flip(i);
        end = System.nanoTime();
        elapsed = (end-start);
        total += (double) elapsed/1000000.0;
      }
      average = total/repeat;
      String line = i+"\t"+ average; //+"\t"+Math.log(average);
      System.out.println(line);
      writer.write(line);
      writer.newLine();
      writer.flush();
    }
    writer.close();
  }
}