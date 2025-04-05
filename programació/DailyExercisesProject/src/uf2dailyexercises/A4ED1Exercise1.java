package uf2dailyexercises;

import java.util.Scanner;

public class A4ED1Exercise1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number;

        System.out.println("Inserta un número enter a sumar (major a 0): ");
        number = scanner.nextInt();
        while (number <= 0) {
            System.out.println("El número ha de ser major a 0: ");
            number = scanner.nextInt();
        }

        System.out.println("Suma iterativa: " + iterativeSum(number));
        System.out.println("Suma recursiva: " + sum(number));
    }
    public static int iterativeSum(int number) {
        int sum = 0;
        for (int i = 1; i <= number; i++) {
            sum += i;
        }

        return sum;
    }

    public static int sum(int number) {
        if (number <= 0) {
            return 0;
        } else {
            return number+sum(number-1);
        }
    }
}
