import java.util.Random;

public class Die
{
  private int faceNumber;
  private int dieFace;
  private Random rnd;
  
  public Die()
  {
    faceNumber = 6;
    dieFace = 0;
    rnd = new Random();
  }
  
  public Die(int initial)
  {
    faceNumber = initial;
    dieFace = 0;
    rnd = new Random();
  }
  
  public int roll()
  {
    dieFace = rnd.nextInt(faceNumber) + 1;
    return dieFace;
  }
  
  public void setDieFace(int value)
  {
    if ( (1<= value) && (value <= faceNumber))
      dieFace = value;
  }
  
  public int getDieFace()
  {
    return dieFace;
  }
  
  public String toString()
  {
    return Integer.toString(dieFace);
  }
}