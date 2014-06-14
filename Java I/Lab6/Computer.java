import java.util.Random;

public class Computer
{
  private final int  CHOICES = 3;
  private char choice;
  private Random rnd;
  
  public Computer()
  {
    choice = '0';
    rnd = new Random();
  }
  
  private char getLetter(int stuff)
  {
    switch (stuff)
    {
      case 1:
        return 'R';
      case 2:
        return 'P';
      case 3:
        return 'S';
      default:
        return '0';
    }
  }
  
  public char choose()
  {
    choice = getLetter(rnd.nextInt(CHOICES) + 1);
    return choice;
  }
  
  public char getChoice()
  {
    return choice;
  }
  
  public char compare(char player)
  {
    switch (player)
    {
      case 'R':
      case 'r':
        if (choice == 'R')
          return 'D';
        else if (choice == 'P')
          return 'C';
        else if (choice == 'S')
          return 'P';
        else
          return '0';
      case 'P':
      case 'p':
        if (choice == 'R')
          return 'P';
        else if (choice == 'P')
          return 'D';
        else if (choice == 'S')
          return 'C';
        else
          return '0';
      case 'S':
      case 's':
        if (choice == 'R')
          return 'C';
        else if (choice == 'P')
          return 'P';
        else if (choice == 'S')
          return 'D';
        else
          return '0';
      default:
        return '0';
    }
  }
  
  public String toString()
  {
    return Character.toString(choice);
  }
}