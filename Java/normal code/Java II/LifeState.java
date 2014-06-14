
public class LifeState
{
  private int rows;
  private int cols;
  private boolean[][] state;
  
  public LifeState(int i,int j)
  {
    rows = i;
    cols = j;
    state = new boolean[rows][cols];
    for(int k=0;k<rows;k++)
      for(int l=0;l<cols;l++)
        state[k][l] = false;
  }
  
  public void setCell(int i,int j, boolean value)
  {
    state[i][j] = value;
  }
  
  public boolean getCell(int i, int j)
  {
    return state[i][j];
  }
  
  public void iterate()
  {
    boolean[][] tmp = new boolean[rows][cols];
    
      for(int i=0;i<rows;i++)
        for(int j=0;j<cols;j++)
          tmp[i][j] = getNext(i,j);
      state = tmp;
  }
  
  private boolean getNext(int i,int j)
  {
    int count = state[i][j] ? -1 : 0;
    int imin = (i>0) ? i-1 : 0;
    int imax = (i==rows-1) ? i : i+1;
    int jmin = (j>0) ? j-1 : 0;
    int jmax = (j==cols-1) ? j : j+1;
    
    for(int k= imin;k<=imax;k++)
      for(int l=jmin;l<=jmax;l++)
        if (state[k][l])
          count++;
    
    if(state[i][j])
    {
      if ( (count ==2) || count == 3)
        return true;
      return false;
    }
    if (count==3)
      return true;
    return false;
  }
}
    