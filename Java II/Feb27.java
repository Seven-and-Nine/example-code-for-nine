
public class Feb27
{
  public static void main(String[] arg)
  {
    Integer[] array;
    
    int max = 50;
    
    array = new Integer[max];
    for(int i=0;i<max;i++)
      array[i] = i;
    SortTools.shuffle(array);
    for(Integer element: array)
      System.out.print(element+" ");
    System.out.println("\n------------------------");
    SortTools.quickSort(array);
    for(Integer element: array)
      System.out.print(element+" ");
    System.out.println("\n------------------------");
    
    int repeat = 20;
    double total;
    
    max = 16000;
    long start, elapsed;
    array = new Integer[max];
    for(int i=0;i<max;i++)
      array[i] = i;
    total = 0.0;
    for(int i=0;i<repeat;i++)
    {
      SortTools.shuffle(array);
      start = System.nanoTime();
      SortTools.quickSort(array);
      elapsed = System.nanoTime() - start;
      total += elapsed/1000000.0;
    }
    double average = total/repeat;
    System.out.println(average);
      
      
      
    
  }
}