import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    short a = sc.nextShort();
    final String msg = a > 12 ? "Number is greater than 12" : "Number is less than or equal to 12";
    sc.close();   
    System.out.println(msg);
    }
}