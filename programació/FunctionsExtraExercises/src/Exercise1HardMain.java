import java.util.Scanner;

public class Exercise1HardMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputNumber = 1;

        while(inputNumber > 0) {
            System.out.println("Introdueix el número: ");
            inputNumber = sc.nextInt();

            if (inputNumber == 0) {
                System.out.println("Tancant el programa.");
            }
            else if (isPrime(inputNumber)) {
                System.out.println("El número " + inputNumber + " és primer.");
            }
            else {
                System.out.println("El número " + inputNumber + " NO és primer.");
            }
        }
    }
    public static boolean isPrime(int number) {
        boolean returnValue = true;
        if (number >= 2) {
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    returnValue = false;
                }
            }
        }
        else {
            returnValue = false;
        }
        return returnValue;
    }
}
