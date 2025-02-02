package arrays;

import java.util.Random;
import java.util.Scanner;

public class Exercise1Main {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        int[] values = new int[100];
        int value = 0;

        for (int i = 0; i < 100; i++) {
            values[i] = random.nextInt(1, 100);
        }
        while (value <= 0) {
            System.out.println("Introdueix el valor a trobar (el valor no pot ser menor o igual a 0): ");
            value = sc.nextInt();
        }
        System.out.println("El valor " + value + " s'ha trobat " + searchValues(value, values) + " vegades.");
    }

    public static int searchValues(int num, int[] array) {
        int counter = 0;
        for (int i:array) {
            if (i == num){
                counter++;
            }
        }
        return counter;
    }
}
