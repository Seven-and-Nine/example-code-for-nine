
import java.util.Comparator;

public class CountOrdering implements Comparator<TokenSequence>
{
  public int compare(TokenSequence X,TokenSequence Y)
  {
    int value = -(X.getCount() - Y.getCount());
    if( value != 0)
      return value;
    return X.compareTo(Y);
  }
  
  public boolean equals(TokenSequence X, TokenSequence Y)
  {
    int value = X.getCount() - Y.getCount();
    return (value == 0) && X.equals(Y);
  }
}
  