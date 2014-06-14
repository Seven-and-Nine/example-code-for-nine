
import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;

public class BinarySearchTree<T extends Comparable<T>> implements Iterable<T>
{
  private BNode<T> root;
  
  public BinarySearchTree(T element)
  {
    root = new BNode(element);
  }
  
  public BinarySearchTree(BNode<T> node)
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
  
  public BinarySearchTree<T> getLeftSubTree()
  {
    return new BinarySearchTree(root.getLeft());
  }
  
  public BinarySearchTree<T> getRightSubTree()
  {
    return new BinarySearchTree(root.getRight());
  }
  
  public void add(T element)
  {
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
