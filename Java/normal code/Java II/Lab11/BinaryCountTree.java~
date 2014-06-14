
import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;

public class BinaryCountTree<T extends Incrementable & Comparable<T>> implements Iterable<T>
{
  private BNode<T> root;
  
  public BinaryCountTree(T element)
  {
    root = new BNode(element);
  }
  
  public BinaryCountTree()
  {
    root = null;
  }
  
  public BinaryCountTree(BNode<T> node)
  {
    root = node;
  }
  
  public int size()
  {
    int size = 1;
    if(root.hasLeft())
      size += getLeftSubTree().size();
    if(root.hasRight())
      size += getRightSubTree().size();
    return size;
  }
  
  public int height()
  {
    int x=0;
    int y = 0;
    if(root.hasLeft())
      x = getLeftSubTree().height();
    if(root.hasRight())
      y = getRightSubTree().height();
    
    return 1 + ((x>=y)? x : y);
  }
  
  public BinaryCountTree<T> getLeftSubTree()
  {
    return new BinaryCountTree(root.getLeft());
  }
  
  public BinaryCountTree<T> getRightSubTree()
  {
    return new BinaryCountTree(root.getRight());
  }
  
  public void add(T element)
  {
    if ( root == null)
    {
      root = new BNode(element);
      return;
    }
      
    if ( element.compareTo(root.getElement()) == 0)
    {
      root.getElement().increment();
      return;
    }
          
    if ( element.compareTo(root.getElement()) < 0)
    {
      if(!root.hasLeft())
      {
        root.setLeft(new BNode(element));
        return;
      }
      else
      {
        getLeftSubTree().add(element);
        return;
      }
    }
    if(!root.hasRight())
    {
      root.setRight(new BNode(element));
      return;
    }
    getRightSubTree().add(element);
    return;
  }
  
  public Iterator<T> iterator()
  {
    LinkedList<T> list = new LinkedList<T>();
    inOrder(list);
    return list.iterator();
  }
  
  public void inOrder(List list)
  {
    if(root.hasLeft())
      getLeftSubTree().inOrder(list);
    list.add(root.getElement());
    if(root.hasRight())
      getRightSubTree().inOrder(list);
  }
  
  public void preOrder(List list)
  {
    list.add(root.getElement());
    if(root.hasLeft())
      getLeftSubTree().preOrder(list);   
    if(root.hasRight())
      getRightSubTree().preOrder(list);
  }
  
  public void postOrder(List list)
  {
    if(root.hasLeft())
      getLeftSubTree().postOrder(list);    
    if(root.hasRight())
      getRightSubTree().postOrder(list);
    list.add(root.getElement());
  }
}
