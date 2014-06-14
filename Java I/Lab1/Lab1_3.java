import java.util.Scanner;

public class Lab1_3
{
  public static void main(String[] arg)
  {
    int Sin, S, M, H = 0;
    Scanner scan = new Scanner(System.in);
    System.out.print("type seconds to convert to Hours Minutes and Seconds");
    Sin = scan.nextInt();
    H = (Sin/3600);
    M = (Sin%3600)/60;
    S = Sin%60;
    System.out.println(Sin+" Second(s) = "+H+":"+M+":"+S);
  }
}