
import java.util.Scanner;

public class PostFixEvaluator
{
  private static boolean isNumber(String token)
  {
    return !(token.equals("+")||token.equals("-")||token.equals("*")||
          token.equals("/"));
  }
  
  private static Double operate(String op,Double x,Double y)
  {
    switch(op.charAt(0))
    {
      case '+': return x+y;
      case '*': return x*y;
      case '-': return y-x;
      case '/': return y/x;
    }
    return Double.NaN;
  }
  public static void main(String[] arg)
  {
    while(true)
    {
      Scanner scan = new Scanner(System.in);
      System.out.print("Please input a valid postfix expression or q to quit: ");
      String input = scan.nextLine();
      if( input.equalsIgnoreCase("q"))
        return;
      scan = new Scanner(input);
      Stack<Double> stack = new ArrayStack<Double>();
      while(scan.hasNext())
      {
        String token = scan.next();
        if( isNumber(token) )
          stack.push(Double.parseDouble(token));
        else
          stack.push(operate(token,stack.pop(),stack.pop()));
      }
      System.out.println("The result is: "+stack.pop());
    }
  }
}
                     