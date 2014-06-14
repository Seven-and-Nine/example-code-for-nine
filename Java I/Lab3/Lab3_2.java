public class Lab3_2
{ 
  public static void main(String[] arg)
  {
    int beginnum = 33; //!
    int endnum = 126; //~
    int characterstuff = beginnum;
    int perline = 0;
    for(int i = (endnum-beginnum)+1; i>0; i-- )
    {
      System.out.print(Character.toChars(characterstuff));
      System.out.print(' ');
      characterstuff++;
      perline++;
      if(perline % 10 == 0)
        System.out.println();
    }
  }
}