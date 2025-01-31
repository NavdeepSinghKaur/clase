import java.sql.SQLOutput;
import java.util.Scanner;

public class Exercise1MediumMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Inserta el primer número: ");
        int num1 = sc.nextInt();

        System.out.println("Inserta el segon número: ");
        int num2 = sc.nextInt();

        System.out.println("Inserta el tercer número: ");
        int num3 = sc.nextInt();

        int firstOperation = biggerNumber(num1, num2);

        System.out.println("El número més gran és: " + biggerNumber(firstOperation, num3));
    }

    public static int biggerNumber(int num1, int num2) {
        int biggerNum;
        if (num1 > num2) {
            biggerNum = num1;
        }
        else {
            biggerNum = num2;
        }
        return biggerNum;
    }
}
