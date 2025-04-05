package uf2dailyexercises;

import java.util.Scanner;

public class A4ED3Exercise2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input;

        System.out.println("Inserta el número i exponent separat per coma exemple (3,3): ");
        input = scanner.nextLine();
        input = input.trim();
        String[] numbers = input.split(",");
        int power = Integer.parseInt(numbers[0]);
        int exponent = Integer.parseInt(numbers[1]);
        while (power == 0 && exponent == 0) {
            System.out.println("Els números no han de ser iguals a 0. Torna a intentar-ho: ");
            input = scanner.nextLine();
            input = input.trim();
            numbers = input.split(",");
            power = Integer.parseInt(numbers[0]);
            exponent = Integer.parseInt(numbers[1].trim());
        }
        if (power > 0) {
            System.out.println("Exponent del número recursivament: " + calculatePowerIterative(power, exponent));
            System.out.println("Exponent del número iterativament: " + calculatePowerRecursive(power, exponent));
        } else {
            System.out.println("Exponent del número recursivament: " + -calculatePowerIterative(power, exponent));
            System.out.println("Exponent del número iterativament: " + -calculatePowerRecursive(power, exponent));
        }
    }

    public static int calculatePowerIterative(int power, int exponent) {
        int total = 1;

        for (int i = 0; i < exponent; i++) {
            total*=power;
        }

        return total;
    }

    public static int calculatePowerRecursive(int power, int exponent) {
        if (exponent > 1) {
            return power * calculatePowerRecursive(power, exponent -1);
        } else {
            return power;
        }
    }
}
