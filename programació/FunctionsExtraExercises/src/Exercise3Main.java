import java.util.Scanner;

public class Exercise3Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1, num2;

        System.out.println("Inserta el primer número: ");
        num1 = sc.nextInt();
        System.out.println("Inserta el segon número: ");
        num2 = sc.nextInt();

        System.out.println("La mitjana del números és: " + median(num1, num2));
    }

    public static float median(int num1, int num2) {
        return (float) (num1 + num2) /2;
    }
}
