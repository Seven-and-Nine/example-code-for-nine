
public class BNode<T>
{
  private BNode<T> left;
  private BNode<T> right;
  private T element;
  
  public BNode(T element)
  {
    this.element = element;
    left = null;
    right = null;
  }
  
  public T getElement()
  {
    return element;
  }
  
  public void setElement(T element)
  {
    this.element = element;
  }
  
  public BNode<T> getLeft()
  {
    return left;
  }
  
  public void setLeft(BNode<T> node)
  {
     left = node;
  }
  
  public BNode<T> getRight()
  {
    return right;
  }
  
  public void setRight(BNode<T> node)
  {
     right = node;
  }
  
  public boolean hasLeft()
  {
    return ( left != null);
  }
  
  public boolean hasRight()
  {
    return ( right != null);
  }
}