import java.util.Scanner;

public class Aug22
{
  public static void main(String[] arg)
  {
    System.out.println("This is day 2");
    System.out.println("the room is like a sauna");
 //   System.out.println(1/0);
    int x;
    x = 5;
    int y = x + 7;
    x = 6;
    System.out.println(x);
    x = x + 1;
    System.out.println(x);
    System.out.println(y);
    Scanner scan = new Scanner(System.in);
    System.out.print("please input a name: ");
    String name = scan.next();
    System.out.print("Your name is: ");
    System.out.println(name);
    String lastname = scan.next();
    System.out.println(lastname);
    x = scan.nextInt();
    x = x+1;
    System.out.println(x);
  }
}