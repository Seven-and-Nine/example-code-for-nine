public class TokenSequence implements Incrementable, Comparable<TokenSequence>
{
  private String[] tokens;
  private int count;
  
  public TokenSequence(String[] input)
  {
    tokens = input;
    count = 1;
  }
  
  public String[] getTokens()
  {
    return tokens;
  }
  
  public void increment()
  {
    count++;
  }
  
  public void decrement()
  {
    count--;
  }
  public int getCount()
  {
    return count;
  }
  public void setCount(int i)
  {
    count = i;
  }
  
  public int compareTo(TokenSequence t)
  {
    String[] s = t.getTokens();
    int l = s.length;
    for(int i=0;i<tokens.length;i++)
    {
      if( i==l)
        return 1;
      int value = tokens[i].compareTo(s[i]);
      if(value != 0)
        return value;
    }
    if(l>tokens.length)
      return -1;
    return 0;
  }
  
  public String toString()
  {
    String output = count+": ";
    for(int i=0;i<tokens.length;i++)
      output += tokens[i]+" ";
    return output;
  }
}