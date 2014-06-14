
import java.util.Iterator;

public interface CountList<T extends Incrementable & Comparable<T>> extends Iterable<T>
{
  public void add(T element);
  public int size();
  public boolean isEmpty();
  public boolean contains(T element);
  public Iterator<T> iterator();
  
}