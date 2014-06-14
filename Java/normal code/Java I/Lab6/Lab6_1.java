import java.util.Scanner;

public class Lab6_1
{
  public static void main(String[] arg)
  {
    Computer rps = new Computer();
    Scanner scan = new Scanner(System.in);
    char input;
    int player = 0, computer = 0, tie = 0;
    do
    {
      System.out.println("Please type in R, P, or S to play the Rock, Paper, Scissors game, or press Q to exit and see your score.");
      input = scan.next().charAt(0);
      if (input != 'q' && input != 'Q')
      {
        rps.choose();
        System.out.println("The computer\'s choice is "+rps.getChoice());
        if (rps.compare(input) == 'P')
        {
          player++;
          System.out.println("You win!");
        }
        else if (rps.compare(input) == 'C')
        {
          computer++;
          System.out.println("Computer wins!");
        }
        else if (rps.compare(input) == 'D')
        {
          tie++;
          System.out.println("There is a tie!");
        }
        else if (rps.compare(input) == '0')
        {
          System.out.println("You didn\'t enter the right character. please enter R, P, S, or Q!");
        }
      }
      System.out.println("------------------"); 
    }
    while (input != 'q' && input != 'Q');
    int total = player+computer+tie;
    if (total == 0)
      System.out.println("Please play the game at least once");
    else 
    {
      System.out.println("Wins: "+player+" "+Float.toString((float)((player*100.0)/total))+"%");
      System.out.println("Losses: "+computer+" "+Float.toString((float)((computer*100.0)/total))+"%");
      System.out.println("Ties: "+tie+" "+Float.toString((float)((tie*100.0)/total))+"%");
    }
  }
}