
public class Jan14
{
  public static void main(String[] arg)
  {
    int[] scores;
    
    System.out.println("Please input length: ");
    java.util.Scanner scan = new java.util.Scanner(System.in);
    scores = new int[scan.nextInt()];
    
    System.out.println(scores);
    System.out.println(scores.length);
    
    for(int i=0;i<scores.length;i++)
      scores[i] = i*i;
    
    // does not make a permanent change to scores!
    for(int value : scores)
      value = 5;
    
    for(int i=0;i< scores.length; i++)
      System.out.print(scores[i]+ ( i%10 == 9 ? "\n":"\t"));
    System.out.println();
    
    String[] names;
    names = new String[5];
    
    names[0] = "Frank";
    names[1] = "suzy";
    
    for(String name : names)
      System.out.println(name);
    
    boolean[] flags = new boolean[10];
    for(boolean flag : flags)
      System.out.print(flag+" ");
    System.out.println();
    
    
  }
}