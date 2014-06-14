
public class DNode<T>
{
  private DNode<T> next;
  private DNode<T> previous;
  private T element;
  
  public DNode(DNode<T> n,DNode<T> p,T e)
  {
    next = n;
    previous = p;
    element = e;
  }
  
  public void setElement(T e)
  {
    element = e;
  }
  
  public T getElement()
  {
    return element;
  }
  
  public void setNext(DNode<T> n)
  {
    next = n;
  }
  
  public DNode<T> getNext()
  {
    return next;
  }
  
  public void setPrevious(DNode<T> p)
  {
    previous = p;
  }
  
  public DNode<T> getPrevious()
  {
    return previous;
  }
}
    