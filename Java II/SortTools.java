
import java.util.Random;
public class SortTools
{
  public static <T> void shuffle(T[] data)
  {
    Random rnd = new Random();
    int current = data.length-1;
    while(current>0)
    {
      int i = rnd.nextInt(current+1);
      if( i!= current)
        swap(data,i,current);
      current--;
    }
  }
      
  public static <T extends Comparable<T>> boolean
    linearSearch(T[] data, int min, int max, T target)
  {
    for(int i=min; i< max; i++)
      if( target.compareTo(data[i]) == 0)
        return true;
    return false;
  }
  
  public static <T extends Comparable<T>> boolean
    binarySearch(T[] data, int min, int max, T target)
  {
    int mid;
    int value;
    boolean b = true;
    
    while(b)
    {
      mid = (min+max)/2;
      value = target.compareTo(data[mid]);
      if( value == 0)
        return true;
      if(min == max)
        return false;
      if( value > 0)
        min = mid + 1;
      else
        max = mid - 1;
    }
      return false;
  }
  
  private static <T> void swap(T[] data, int i, int j)
  {
    T tmp = data[j];
    data[j] = data[i];
    data[i] = tmp;
  }
  
  public static <T extends Comparable<T>> void selectionSort(T[] data)
  {
    int current = 0;
    int smallest;
    int n = data.length;
    
    while(current < n)
    {
      smallest = current;
      
      for(int i = current+1;i<n;i++)
        if ( data[i].compareTo(data[smallest]) < 0)
              smallest = i;
      swap(data, current, smallest);
      current++;
    }
  }
  public static <T extends Comparable<T>> void insertionSort(T[] data)
  {
    int current=1;
    T value;
    
    while(current<data.length)
    {
      value = data[current];
      int i= current-1;
      while(i>=0 && data[i].compareTo(value) > 0)
      {
        data[i+1] = data[i];
        i--;
      }
      data[i+1] =value;
      current++;
    }
  }
  public static <T extends Comparable<T>> void bubbleSort(T[] data)
  {
    for(int current = data.length-1; current>0;current--)
      for(int i=0;i<current;i++)
        if(data[i].compareTo(data[i+1]) > 0)
          swap(data,i,i+1);
  }
  public static <T extends Comparable<T>> void quickSort(T[] data)
  {
    quickSort(data,0,data.length-1);
  }
  public static <T extends Comparable<T>> void quickSort(T[] data,int min, int max)
  {
    if(!(min<max))
      return;
    int index = partition(data,min,max);
    quickSort(data,min,index-1);
    quickSort(data,index+1,max);
  }
  private static <T extends Comparable<T>> int partition(T[] data,int min,int max)
  {
    T value = data[min];
    int left = min;
    int right = max;
    while(left<right)
    {
      while(data[left].compareTo(value) <= 0 && left<right)
        left++;
      while(data[right].compareTo(value) > 0)
        right--;
      if(left<right)
        swap(data,left,right);
    }
    swap(data,min,right);
    return right;
  }
}