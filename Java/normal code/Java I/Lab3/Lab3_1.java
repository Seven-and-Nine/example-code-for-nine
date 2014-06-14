import java.util.Scanner;

public class Lab3_1
{
  public static Double C, F = 0.0;
  public static Scanner scan = new Scanner(System.in);
    
  public static void FtoC() {
    System.out.print("Converting to Celcius. Input Fahrenheit: ");
    F = scan.nextDouble();
    C =  ((F-32)*5)/9;
  }
  
  public static void CtoF() {
   System.out.print("Converting to Fahrenheit. Input Celcius: ");
   C = scan.nextDouble();
   F = ((C*9)/5)+32; 
  }
  
  public static void main(String[] arg)
  {
    char choice = 'C';
    while (choice == 'C' || choice == 'c' || choice == 'F' || choice == 'f') {
      System.out.print("Type C to convert a number to Celcius or F to convert a number to Fahrenheit: ");
      choice = scan.next().charAt(0);
      switch (choice) {
        case 'C' :
        case 'c' :
          FtoC();
          System.out.println(F+"°F"+" = "+C+"°C");
          break;
        case 'F' :
        case 'f' :
          CtoF();
          System.out.println(C+"°C"+" = "+F+"°F");
          break;
        default :
          break;
      }
    }
  }
}