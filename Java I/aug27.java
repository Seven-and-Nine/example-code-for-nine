import java.util.Scanner;

public class Aug27
{
  public static void main(String[] arg)
  {
    double x;
    double y;
    double z;
    
    Scanner scan;
    scan = new Scanner(System.in);
    System.out.print("Please input the first number: ");
    x = scan.nextDouble();
    System.out.println("Please input the second number: ");
    y = scan.nextDouble();
    z =  x + x;
    System.out.println("The sum is: "+z+".");
  }
}