package uf2dailyexercises;

import java.util.Scanner;

public class A4ED4Exercise1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = 0;
        while ( number <= 0) {
            System.out.println("Inserta un número major o igual a 0: ");
            number = scanner.nextInt();
        }

        System.out.println("Càlcul recursiu: " + pyramidRecursive(number, 1, 3));
        System.out.println("Càlcul iteratiu: " + pyramidIterative(number));
    }

    public static int pyramidIterative(int blocks) {
        int total = 0;
        int j = 1;
        int counter = 3;
        for (int i = 0; i < blocks; i++) {
            total += j;
            j += counter;
            counter += 2;
        }
        return total;
    }

    public static int pyramidRecursive(int blocks, int j, int total) {
        if (blocks == 0) {
            return 0;
        } else {
            return j + pyramidRecursive(blocks -1 , j + total, total +2);
        }
    }
}
