import java.util.Scanner;

public class Lab2_2
{
  public static void main(String[] arg)
  {
    int numbers[] = {0,0,0};
    int odd = 0;
    int negative = 0;
    Scanner scan = new Scanner(System.in);
    System.out.print("Please input a number: ");
    numbers[0] = scan.nextInt();
    System.out.print("Please input another number: ");
    numbers[1] = scan.nextInt();
    System.out.print("Please input a third number: ");
    numbers[2] = scan.nextInt();
    if (numbers[0]<numbers[1] && numbers[0]<numbers[2])
      System.out.println(numbers[0]+" is the smallest number.");
    else if (numbers[1]<numbers[0] && numbers[1]<numbers[2])
      System.out.println(numbers[1]+" is the smallest number.");
    else if (numbers[2]<numbers[0] && numbers[2]<numbers[1])
      System.out.println(numbers[2]+" is the smallest number.");
    for (int x : numbers) {
      if (x%2 != 0)
        odd++;
      if (x < 0)
        negative++;
    }
    System.out.println(odd+" are odd.");
    System.out.println(negative+" are negative.");
  }
}