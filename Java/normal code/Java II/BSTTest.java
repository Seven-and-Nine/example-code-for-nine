
import java.util.Random;
import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;

public class BSTTest
{
  public static void main(String[] arg)
  {
    Random rnd = new Random();
    
    Integer[] array = new Integer[10];
    for(int i=0;i< array.length;i++)
      array[i] = rnd.nextInt(100);
    BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>(array[0]);
    for(int i=1;i<array.length;i++)
      bst.add(array[i]);
    
    List<Integer> list = new LinkedList<Integer>();
    bst.preOrder(list);
    for(Integer value : list)
      System.out.print(value+" ");
    System.out.println();
    Scanner scan = new Scanner(System.in);
    scan.next();
    for(Integer value: array)
      System.out.print(value+" ");
    System.out.println();
  }
}
    
    