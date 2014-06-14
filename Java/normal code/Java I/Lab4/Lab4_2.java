public class Lab4_2
{
  public static void main(String[] arg)
  { 
    System.out.print(" * |");
    for(int x=1;x<=12;x++) {
      if (x<10) System.out.print(' ');
      if (x<100) System.out.print(' ');
      System.out.print(x+" ");
    }
    System.out.println();
    for(int x=1;x<=21;x++) {
      if (x<10) System.out.print('-');
      System.out.print("--");
    }
    System.out.println();
    for(int i=1;i<=12;i++)
    {
      if (i<10) System.out.print(' ');
      System.out.print(i+" |");
      for(int j=1;j<=12;j++) {
        if (i*j<10) System.out.print(' ');
        if (j*i<100) System.out.print(' ');
        System.out.print(j*i+" ");
      }
      System.out.println();
    }
      System.out.println();
      System.out.println();
      
      System.out.print(" + |");
    for(int x=1;x<=12;x++) {
      if (x<10) System.out.print(' ');
      if (x<100) System.out.print(' ');
      System.out.print(x+" ");
    }
    System.out.println();
    for(int x=1;x<=21;x++) {
      if (x<10) System.out.print('-');
      System.out.print("--");
    }
    System.out.println();
    for(int i=1;i<=12;i++)
    {
      if (i<10) System.out.print(' ');
      System.out.print(i+" |");
      for(int j=1;j<=12;j++) {
        if (i+j<10) System.out.print(' ');
        if (j+i<100) System.out.print(' ');
        System.out.print(j+i+" ");
      }
      System.out.println();
    }   
  }
}
