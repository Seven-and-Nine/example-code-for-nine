
import java.util.Random;

public class Apr1
{
  public static void main(String[] arg)
  {
    Random rnd = new Random();
    Queue[] q = new LinkedListQueue[3];
    OrderedList<Integer> list = new DoublyLinkedList<Integer>();
    
    for(int i=0;i<3;i++)
      q[i] = new LinkedListQueue<Integer>();
    
    for(int i=0;i<20;i++)
    {
      Integer value = rnd.nextInt(100);
      System.out.print(value+" ");
      q[value%3].add(value);
    }
    System.out.println();
    for(int i=0;i<3;i++)
    {
      while(!q[i].isEmpty())
        System.out.print(q[i].remove()+" ");
      System.out.println();
    }
    
     System.out.println("\n----------------");
    for(int i=0;i<20;i++)
    {
      Integer value = rnd.nextInt(100);
      System.out.print(value+" ");
      list.add(value);
    }
    System.out.println("\n----------------");
    System.out.println(list.contains(new Integer(44)));
    while(!list.isEmpty())
      System.out.print(list.removeFront()+" ");
    System.out.println();
    
  }
}






