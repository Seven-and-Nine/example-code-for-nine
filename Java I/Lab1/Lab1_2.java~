import java.util.Scanner;

public class Lab1_2
{
  public static void main(String[] arg)
  {
    Double C, F = 0.0;
    Scanner scan = new Scanner(System.in);
    System.out.print("Type C to convert a number to Celcius or F to convert a number to Fahrenheit: ");
    char choice = scan.next().charAt(0);
    if (choice == 'C' || choice == 'c') {
      System.out.print("Converting to Celcius. Input Fahrenheit: ");
      F = scan.nextDouble();
      C =  ((F-32)*5)/9;
      System.out.println(F+"°F"+" = "+C+"°C");
    } else if (choice == 'F' || choice == 'f') {
      System.out.print("Converting to Fahrenheit. Input Celcius: ");
      C = scan.nextDouble();
      F = ((C*9)/5)+32;
      System.out.println(C+"°C"+" = "+F+"°F");
    }
  }
}