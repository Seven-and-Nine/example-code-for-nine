public class Lab4_1
{
  
  public static void main(String[] arg)
  {    
    for(int i=1;i<=7;i+=2)
    {
      for(int x=6-i;x>0;x-=2)
        System.out.print(' ');
      for(int j=1;j<=i;j++)
        System.out.print('*');
      System.out.println();
    }  
  }
}