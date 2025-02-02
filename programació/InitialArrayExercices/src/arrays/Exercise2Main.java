package arrays;

import java.util.Random;
import java.util.Scanner;

public class Exercise2Main {
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

        int[] searchValuesReturn = searchValues(value, values);

        System.out.println("El valor " + value + " s'ha trobat " + searchValuesReturn[0] + " vegades. \nEn les següents posicions: ");

        int i = 1;
        while(searchValuesReturn[i] != 0 && i < searchValuesReturn.length-1) {
            System.out.println(searchValuesReturn[i]);
            i++;
        }
    }

    public static int[] searchValues(int num, int[] array) {
        int[] searchValuesOutput = new int[101];
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == num){
                counter++;
                int j = 1;
                while (searchValuesOutput[j] != 0 && j < searchValuesOutput.length-1) {
                    j++;
                }
                searchValuesOutput[j] = i;
            }
        }
        searchValuesOutput[0] = counter;
        return searchValuesOutput;
    }
}