
import java.util.Random;
import java.util.Scanner;
import java.io.*;
import javax.swing.JFileChooser;

public class Apr22
{
  public static void main(String[] arg) throws IOException
  {
    Random rnd = new Random();
    BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>(rnd.nextInt(100));
    
    for(int i=0;i<99;i++)
      bst.add(rnd.nextInt(100));
    
    for(Integer x : bst)
      System.out.print(x+" ");
    System.out.println();
    
    Scanner scan = null;
    File file = null;
    JFileChooser chooser = new JFileChooser("../Text");
    int returnValue = chooser.showOpenDialog(null);
    if(returnValue == JFileChooser.APPROVE_OPTION)
    {
      file = chooser.getSelectedFile();
      scan = new Scanner(file);
    }
    else
      return;
    BinarySearchTree<String> tokens = new BinarySearchTree<String>(scan.next());
    
    while(scan.hasNext())
    {
      String token = scan.next().toLowerCase();
      token = token.replaceAll("\\p{Punct}","");   
      tokens.add(token);
    }
    for(String word : tokens )
      System.out.print(word+" ");
    System.out.println();
  }
}