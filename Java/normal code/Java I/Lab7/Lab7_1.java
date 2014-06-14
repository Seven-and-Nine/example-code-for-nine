public class Lab7_1
{
  public static void main(String[] arg)
  {
    Die die1 = new Die(10);
    Die die2 = new Die(12);
    
    int counter = 0;
    do 
    {
      die1.roll();
      die2.roll();
        counter++;
    } while ((die1.getDieFace() != 1) && (die2.getDieFace() != 1));
    System.out.println("there were "+ counter + " rolls to get a snake eyes");
  }
}