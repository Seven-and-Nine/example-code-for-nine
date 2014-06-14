
import java.util.Scanner;
import java.io.*;
import javax.swing.JFileChooser;
import java.util.Arrays;

public class Apr29
{
  public static void main(String[] arg)  throws FileNotFoundException
  {
    int N;
    Scanner scan = null;
    File file = null;
    scan = new Scanner(System.in);
    System.out.println("Please input N: ");
    N = scan.nextInt();
    BinaryCountTree<TokenSequence> tree = new BinaryCountTree<TokenSequence>();
    JFileChooser chooser = new JFileChooser("../Text");
    int returnValue = chooser.showOpenDialog(null);
    if(returnValue == JFileChooser.APPROVE_OPTION)
    {
      file = chooser.getSelectedFile();
      scan = new Scanner(file);
    }
    else
      return;
    
    String[] inputarray = new String[N];
    for(int i=1;i<N;i++)
      inputarray[i] = scan.next().toLowerCase().replaceAll("\\p{Punct}","");
 
    int count = 0;
    while(scan.hasNext())
    {
      for(int i=1;i<N;i++)
        inputarray[i-1] = inputarray[i];
  
      inputarray[N-1] = scan.next().toLowerCase().replaceAll("\\p{Punct}","");
      TokenSequence token = new TokenSequence(inputarray);
      tree.add(token);
      count++;
    }
    
    TokenSequence[] array = new TokenSequence[tree.size()];
    int i=0;
    for(TokenSequence token : tree)
    {
      array[i] = token;
      i++;
    }
   // if !alpha.isSelected() 
    Arrays.sort(array, new CountOrdering());
    
    for(i=0;i<25;i++)
      System.out.println(array[i]);
    
    System.out.println("Size of list: "+array.length+"\nTotal count: "+count);
  }
  
}
      