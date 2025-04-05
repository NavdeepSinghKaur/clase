package uf2dailyexercises;

import java.util.Scanner;

public class A4ED3Exercise1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String number;

        System.out.println("Inserta un número enter major a 0: ");
        number = scanner.nextLine();
        while (Integer.parseInt(number) <= 0) {
            System.out.println("El número ha de ser major a 0: ");
            number = scanner.nextLine();
        }

        System.out.println("Inversió del número recursivament: " + reverseNumberRecursive(Integer.parseInt(number), number.length()-1));
        System.out.println("Inversió del número iterativament: " + reverseNumber(number));
    }

    public static String reverseNumber(String number) {
        String[] numberList = number.split("");
        String reversedNumbers = "";
        for (int i = numberList.length -1; i >= 0; i--) {
            reversedNumbers += numberList[i];
        }

        return reversedNumbers;
    }

    public static String reverseNumberRecursive(int number, int index) {

        if (index >= 0) {
            return (index + 1) + reverseNumberRecursive(number, index-1);
        } else {
            return "";
        }

    }
}
