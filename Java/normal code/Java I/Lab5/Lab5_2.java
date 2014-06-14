import java.util.Scanner;
import java.util.Random;
import java.text.DecimalFormat;

public class Lab5_2 {
    public static void main(String[] args) {
        Random rnd = new Random();
        Scanner scan = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("########.00");
        System.out.println("Please enter how many sides you want:");
        int dicesides = scan.nextInt();
        System.out.println("Please enter how many times you wish to roll");
        int times = scan.nextInt();
        double average = 0;
        int roll;
        for(int x = 1; x <= times; x++) {
          roll = rnd.nextInt(dicesides)+1;
          System.out.print(roll + " ");
          average += roll;
        }
        System.out.println();
        System.out.println(df.format(average/times));
    }
}