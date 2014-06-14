
import java.util.Arrays;

public class TextMatch
{
  
  public static double test(TokenSequence[] X, TokenSequence[] Y, int n)
  {
    if (n<=0)
      return test(X,Y);
    
    TokenSequence[] Z = new TokenSequence[X.length];
    for(int i=0;i<X.length;i++)
      Z[i] = X[i];
    Arrays.sort(Z,new CountOrdering());
    int max = (Z.length>n) ? n : Z.length;
    X = new TokenSequence[max];
    for(int i=0;i<max;i++)
      X[i] = Z[i];
    Arrays.sort(X);
     Z = new TokenSequence[Y.length];
    for(int i=0;i<Y.length;i++)
      Z[i] = Y[i];
    Arrays.sort(Z,new CountOrdering());
    max = (Z.length>n) ? n : Z.length;
    Y = new TokenSequence[max];
    for(int i=0;i<max;i++)
      Y[i] = Z[i];
    Arrays.sort(Y);
    return test(X,Y);
  }
  
  public static double test(TokenSequence[] X, TokenSequence[] Y)
  {
    double x = 0;
    double y = 0;
    double total = 0;
    
    for(TokenSequence token: X)
    {
      int value = token.getCount();
      x += value*value;
    }
    x = Math.sqrt(x);
    
    for(TokenSequence token: Y)
    {
      int value = token.getCount();
      y += value*value;
    }
    y = Math.sqrt(y);
    
    int i=0;
    int j=0;
    while( (i<X.length) && (j<Y.length))
    {
      while(Y[j].compareTo(X[i]) < 0)
      {
        j++;
        if( j == Y.length)
         return total/(x*y);
      }
      if( Y[j].compareTo(X[i]) == 0)
      {
        total += Y[j].getCount()*X[i].getCount();
        i++;
        j++;
      }
      else
      {
        while( X[i].compareTo(Y[j]) < 0)
        {
          i++;
          if( i == X.length)
            return total/(x*y);
        }
        if( X[i].compareTo(Y[j]) == 0)
        {
          total += X[i].getCount()*Y[j].getCount();
          i++;
          j++;
        }
      }
     
    }
     return total/(x*y);
  }
}