
import java.util.Random;

public class Feb25
{
  public static void main(String[] arg)
  {
    CD[] collection = new CD[5];
    
    collection[0] = new CD("Dead Mouse", "At Play", 1997);
    collection[1] = new CD("Nirvana", "Never Mind",1991);
    collection[2] = new CD("AC/DC","Back in Black",1980);
    collection[3] = new CD("Kanye West","The College Dropout",2004);
    collection[4] = new CD("Led Zeppelin" ,"Led Zeppelin IV",1971);
    
    CD target = new CD("Katja DeCuir", "Logic Glitch",2012);
    
    for(CD cd : collection)
      System.out.println(target+"\n"+cd+"\n"+target.compareTo(cd)+"\n");
    
    System.out.println(SortTools.linearSearch(collection,0,
                                         collection.length, target));
    
    CD target2 = new CD("Led Zeppelin" ,"Led Zeppelin IV",1971);
    
    System.out.println(SortTools.linearSearch(collection,0,
                                         collection.length, target2));
    
    Random rnd = new Random();
    int max = 500;
    long start, end;
    Integer[] array = new Integer[max];
    
    array[0] = 0;
    for(int i=1;i<max;i++)
      array[i] = array[i-1] + 1 + rnd.nextInt(2);
    
    Integer n = (90*max)/100;
//    for(Integer m : array)
//      System.out.print(m+" ");
    System.out.println("\n--------------------");
    System.out.println(n);
    start = System.nanoTime();
    System.out.println(SortTools.linearSearch(array,0,max,n));
    end = System.nanoTime();
    System.out.println("linear: "+(end - start)/1000000);
    start = System.nanoTime();
    System.out.println(SortTools.binarySearch(array,0,max,n));
    end = System.nanoTime();
    System.out.println("binary: "+(end - start)/1000000);
  
  
  System.out.println("------------------");
  for(CD cd : collection)
    System.out.println(cd);
  System.out.println("------------------");
  SortTools.selectionSort(collection);
  for(CD cd : collection)
    System.out.println(cd);
  System.out.println("------------------");
  
  array = new Integer[30];
  for(int i=0;i<array.length;i++)
    array[i] = new Integer(rnd.nextInt(100));
  for(Integer m : array)
      System.out.print(m+" ");
  System.out.println("\n----------------");
  SortTools.selectionSort(array);
  for(Integer m : array)
      System.out.print(m+" ");
  System.out.println("\n----------------");
    
      
  }
}