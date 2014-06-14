
import java.util.Scanner;

public class TowersOfHanoi
{
  public static void move(int a, int b, int n)
  {
    if(n==1)
    {
      System.out.println("Move "+a+"->"+b);
    }
    else
    {
      int c = 3 - (a+b);
      move(a,c,n-1);
      move(a,b,1);
      move(c,b,n-1);
    }
  }
  
  public static void main(String[] arg)
  {
    Scanner scan = new Scanner(System.in);
    System.out.println("please input n: ");
    int n = scan.nextInt();
    move(0,1,n);
  }
}
    