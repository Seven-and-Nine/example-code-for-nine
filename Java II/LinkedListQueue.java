
public class LinkedListQueue<T> implements Queue<T>
{
  private Node<T> front;
  private Node<T> rear;
  private int size;
  
  public LinkedListQueue()
  {
    front = null;
    rear = null;
    size = 0;
  }
  public void add(T element)
  {
    Node<T> node = new Node(element);
    if (size == 0)
      front = node;
    else
      rear.setNext(node);
    rear = node;
    size++;
  }
  
  public T remove()
  {
    T element = front.getElement();
    front = front.getNext();
    size--;
    return element;
  }
  public T element()
  {
    return front.getElement();
  }
  public boolean isEmpty()
  {
    return ( size == 0);
  }
  public int size()
  {
    return size;
  }
}