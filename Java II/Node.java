
public class Node<T>
{
  private T element;
  private Node<T> next;
  
  public Node(T element)
  {
    this.element = element;
    next = null;
  }
  
  public Node(T element, Node<T> node)
  {
    this.element = element;
    next = node;
  }
  
  public void setElement(T element)
  {
    this.element = element;
  }
  
  public T getElement()
  {
    return element;
  }
  
  public boolean hasNext()
  {
    return !( next == null);
  }
  
  public void setNext(Node<T> node)
  {
    next = node;
  }
  
  public Node<T> getNext()
  {
    return next;
  }
}