
import java.util.Iterator;

public class DoublyLinkedCountList<T extends Incrementable & Comparable<T>> implements CountList<T>
{
  private DNode<T> front;
  private DNode<T> rear;
  private int size;
  
  public DoublyLinkedCountList()
  {
    front = null;
    rear = null;
    size = 0;
  }
  
  public void add(T element)
  {
    DNode<T> node = new DNode(null,null,element);
    if(size == 0)
    {
      front = node;
      rear = node;
      size++;
      return;
    }
    
    DNode<T> tmp = front;
    while( (tmp != null) && ( tmp.getElement().compareTo(element) < 0))
            tmp = tmp.getNext();
    if ( tmp == null)
    {
      node.setPrevious(rear);
      rear.setNext(node);
      rear = node;
      size++;
      return;
    }
    if(tmp.getElement().compareTo(element) == 0)
    {
      tmp.getElement().increment();
      return;
    }
    size++;
    if( tmp == front)
    {
      node.setNext(front);
      front.setPrevious(node);
      front = node;
      return;
    }
    node.setNext(tmp);
    node.setPrevious(tmp.getPrevious());
    tmp.getPrevious().setNext(node);
    tmp.setPrevious(node);
    return;
  }
            
          
  public T removeFront()
  {
    T element = front.getElement();
    size--;
    front = front.getNext();
    return element;
  }
  public T removeRear()
  {
    T element = rear.getElement();
    size--;
    rear = rear.getPrevious();
    return element;
  }
  public int size()
  {
    return size;
  }
  
  public boolean isEmpty()
  {
    return (size == 0);
  }
  public boolean contains(T element)
  {
    DNode<T> tmp = front;
    while( (tmp != null) && tmp.getElement().compareTo(element) <= 0 )
    {
      if( tmp.getElement().compareTo(element) == 0)
        return true;
      tmp = tmp.getNext();
    }
    return false;
  }
  
  public Iterator<T> iterator()
  {
    return new NodeIterator();
  }
  
  private class NodeIterator<T> implements Iterator<T>
  {
    private DNode<T> current;
    
    public NodeIterator()
    {
      current = (DNode<T>) front;
    }
     public boolean hasNext()
     {
       return (current != null);
     }
     
     public T next()
     {
       T element = current.getElement();
       current = current.getNext();
       return element;
     }
     
     public void remove()
     {
       return;
     }
  
  }
}