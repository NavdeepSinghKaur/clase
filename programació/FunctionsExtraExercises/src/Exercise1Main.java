import java.util.Scanner;

public class Exercise1Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1;
        int num2;

        System.out.println("Inserta el primer número: ");
        num1 = sc.nextInt();
        System.out.println("Inserta el segon número: ");
        num2 = sc.nextInt();

        System.out.println("Suma de " + num1 + " + " + num2 + ": " + operation(num1, num2));
    }

    public static int operation(int num1, int num2) {
        return num1 + num2;
    }
}
