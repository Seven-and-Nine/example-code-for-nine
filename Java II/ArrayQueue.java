
public class ArrayQueue<T> implements Queue<T>
{
  private T[] ring;
  private int front, rear;
  private int size;
  private final int INITIAL_SIZE = 10;
  
  public ArrayQueue()
  {
    ring = (T[]) new Object[INITIAL_SIZE];
    size = 0;
    front = 0;
    rear = 0;
  }
    
  public void add(T element)
  {
    if(size == ring.length)
      createMoreSpace();
    ring[rear] = element;
    rear = ( rear+1)%ring.length;
    size++;
  }
  public T remove()
  {
    T element = ring[front];
    front = (front+1)%ring.length;
    size--;
    return element;
  }
  
  public T element()
  {
    return ring[front];
  }
  
  public boolean isEmpty()
  {
    return (size == 0);
  }
  
  public int size()
  {
    return size;
  }
  
  private void createMoreSpace()
  {
    T[] tmp = (T[]) new Object[2*ring.length];
    for(int i=0;i<size;i++)
      tmp[i] = ring[(front+i)%ring.length];
    ring = tmp;
    front = 0;
    rear = size;
  }
  
}