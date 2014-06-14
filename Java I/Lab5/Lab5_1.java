import java.util.Scanner;
import java.util.Random;
import java.text.DecimalFormat;

public class Lab5_1 {
    public static void main(String[] args) {
        Random rnd = new Random();
        Scanner scan = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("000");
        System.out.println("Please input your first and last name:");
        String familiarname = scan.next();
        String lastname = scan.next();
        familiarname = familiarname.substring(0,1).toLowerCase(); 
        if (lastname.length() > 6)
          lastname = lastname.substring(0,6).toLowerCase();
        else
          lastname = lastname.toLowerCase();
        int number = rnd.nextInt(999);
        System.out.print("Your email address is: ");
        System.out.println(familiarname+lastname+df.format(number)+"@students.highlands.edu");
        
    }
}