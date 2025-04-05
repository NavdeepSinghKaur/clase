package uf2dailyexercises;

import java.util.Scanner;

public class A4ED2Exercise1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number;

        System.out.println("Inserta un número enter major a 0: ");
        number = scanner.nextInt();
        while (number <= 0) {
            System.out.println("El número ha de ser major a 0: ");
            number = scanner.nextInt();
        }

        System.out.println("Conversió a binari recursivament: " + recursiveDecToBin(number));
        System.out.println("Conversió a binari iterativament: " + decToBin(number));
    }

    public static String recursiveDecToBin(int number) {

        if (number >= 1) {
            return recursiveDecToBin(number/2) + ((number % 2 == 0) ? "0" : "1");
        } else {
            return "";
        }
    }

    public static String decToBin(int number) {
        String binaryNum = "";

        while (number >= 1) {
            binaryNum += (number % 2 == 0) ?  "0" : "1";
            number /= 2;
        }

        return binaryNum;
    }
}
