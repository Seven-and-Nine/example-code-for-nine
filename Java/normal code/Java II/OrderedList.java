
public interface OrderedList<T extends Comparable<T>>
{
  public void add(T element);
  public T removeFront();
  public T removeRear();
  public int size();
  public boolean isEmpty();
  public boolean contains(T element);
}
  