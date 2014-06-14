import java.util.Scanner;

public class Lab1_1
{
  public static void main(String[] arg)
  {
    Double A, B, C, X = 0.0;
    Scanner scan = new Scanner(System.in);
    System.out.print("Please input a number: ");
    A = scan.nextDouble();
    System.out.print("Please input another number: ");
    B = scan.nextDouble();
    System.out.print("Please input a third number: ");
    C = scan.nextDouble();
    X = (A + B + C)/3;
    System.out.print("The average is: ");
    System.out.println(X);
  }
}