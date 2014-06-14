
public class Aug29
{
  public static void main(String[] arg)
  {
    final int MAX_SCORE = 100;
    String string1;
    string1 = "Four score and seven years";
    String string2 = " ago our forefathers brought forth ";
    String s3 = string1 + string2 + string1;
    
    System.out.println(s3);
    System.out.println(string1+76543);
    System.out.println(1+2+"hello");
    System.out.println("hello"+1+2);
    System.out.println("hello"+(1+2));
    System.out.println("A \" B");
    System.out.println("He said: \"Hello World\" ");
    System.out.println("AB\tCD\nE\bF");
    int x = 7;
    x = x+1;
    x++;
    System.out.println(x);
    x = x+5;
    x += 5;
    System.out.println(x);
    x = 47;
    System.out.println(x);
//    x = 3.2;
    double z = x;
    System.out.println(x+" "+z);
 //   MAX_SCORE = 200;
    byte u = 127;
    u++;
    System.out.println(u);
    int a = 3000;
    int b = 1000000;
    int c = a*b;
    long A = 3000;
    long B = 1000000;
    long d = A*B;
    System.out.println(c+" "+d);
    double r = 1.0/3.0;
    float t = 1.0F/3.0F;
    System.out.println("r="+r+"\nt="+t);
    char w = 'a';
    System.out.println(w);
    w++;
    System.out.println(w);
    w = 67;
    System.out.println(w);
    for(w=32;w<1000;w++)
      System.out.print(w);
    boolean value = false;
    System.out.println();
    System.out.println(value);
    value = true;
    System.out.println(value);
   
  }
}