
import java.io.*;
import java.util.Random;

public class Feb18
{
  public static long roll(int n)
  {
    Random rnd = new Random();
    int count = 0;
    long total = 0;
    while(count<n)
    {
      total++;
      if(rnd.nextInt(6) == 5)
        count++;
      else
        count = 0;
    }
    return total;
  }
  public static long fib(int n)
  {
    if(n ==0 || n==1)
      return 1;
    return fib(n-1) + fib(n-2);
  }
  
  public static void main(String[] arg) throws IOException
  {
    long start, end, elapsed;
    long value;
    BufferedWriter writer = new BufferedWriter(
           new FileWriter(new File("data.txt")));                                    
    
    double total;
    double average;
    int repeat = 20;
    for(int i=1;i<70;i++)
    {
      total = 0;
      for(int j=0;j<repeat;j++)
      {
        start = System.nanoTime();
//      value = fib(i);
        value = roll(i);
        end = System.nanoTime();
        elapsed = (end-start)/1000000;
        total += (double) elapsed;
      }
      average = total/repeat;
      String line = i+"\t"+ average;
      System.out.println(line);
      writer.write(line);
      writer.newLine();
      writer.flush();
    }
    writer.close();
  }
}