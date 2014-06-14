

public class Mar18
{
  public static void main(String[] arg)
  {
    Queue<Integer> queue = new LinkedListQueue<Integer>();
    
    for(int i=0;i<20;i++)
      queue.add(new Integer(i));
    
    System.out.println("The size is "+queue.size());
    
    while(!queue.isEmpty())
     System.out.print(queue.remove()+" ");
    System.out.println();
    System.out.println("The size is "+queue.size());
    
     for(int i=0;i<20;i++)
      queue.add(new Integer(2*i));
     
     for(int i=0;i<queue.size();i++)
     {
       Integer value = queue.remove();
       System.out.print(value+" ");
       queue.add(value);
     }
     System.out.println();
     System.out.println("The size is "+queue.size());
     
     int depth = 5;
     Queue<Double> ruler = new LinkedListQueue<Double>();
     ruler.add(0.0);
     ruler.add(4.0);
     for(int i=0;i<depth;i++)
     {
       int length = ruler.size();
       for(int j=0;j<length-1;j++)
       {
         Double x = ruler.remove();
         Double y = ruler.element();
         ruler.add(x);
         ruler.add(0.5*(x+y));
       }
       ruler.add(ruler.remove());
       
       System.out.println("___________\nDepth = "+i);
       for(int j=0;j<ruler.size();j++)
       {
         System.out.print(ruler.element()+" ");
         ruler.add(ruler.remove());
       }
       System.out.println();
     }
  }
}