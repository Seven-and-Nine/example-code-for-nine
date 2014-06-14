
public class Jan23
{
  public static void arrayCheck(int[][] table)
  {
    System.out.println("The 2d array has "+table.length+ " rows");
    System.out.println("The 2d array has "+table[0].length+" columns");
    
    for(int[] rowvector : table)
    {
      for(int value : rowvector)
        System.out.print(value+" ");
      System.out.println();
    }
  }
  public static void test(int number, int ... values)
  {
    return;
  }
  public static double average(double ... numbers)
  {
    if (numbers.length == 0 )
      return 0.0;
    double total = 0.0;
    for(double value : numbers)
      total += value;
    return total/numbers.length;
  }
  
  public static void main(String[] arg)
  {
    System.out.println(average());
    System.out.println(average(1.0,2.0,3.0));
    System.out.println(average(1,2,3,4,5,6,7,8,9,123));
    test(7,1,2,3);
    test(7);
    
    int[][] table = new int[3][5];
    
      for(int i=0;i<3;i++)
        for(int j=0;j<5;j++)
          table[i][j] = (i+1)*(j+1);
        
      System.out.println(table[1][3]);  
      System.out.println("the length of table is: "+ table.length);
      
      arrayCheck(table);
                       
  }
}