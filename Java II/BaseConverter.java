
import java.util.Scanner;

public class BaseConverter
{
  private static final String digits = "0123456789ABCDEFGHIGKLMNOPQRSTUVWXYZ";
  public static void main(String[] arg)
  {
    int base;
    Scanner scan = new Scanner(System.in);
    
    while(true)
    {
      Stack<Character> stack = new ArrayStack<Character>();
      System.out.print("Please input a base, 0 or 1 to exit: ");
      base = scan.nextInt();
      if( base==0 || base==1)
        return;
      System.out.print("Please input the integer in decimal: ");
      int n=scan.nextInt();
      System.out.print(n+" in base "+base+" = ");
      while(n>0)
      {
        stack.push( digits.charAt(n%base));
        n /= base;
      }
      while(!stack.isEmpty())
        System.out.print(stack.pop());
      System.out.println();
    }
  }
}
        