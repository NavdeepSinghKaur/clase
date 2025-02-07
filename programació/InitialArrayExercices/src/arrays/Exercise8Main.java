package arrays;

import java.util.Scanner;

public class Exercise8Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Indica quants cassos de prova hi hauràn: ");
        int testCases = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < testCases; i++) {
            System.out.println("Cas " + (i+1) + " de " + testCases);
            System.out.println("Indica quants elements tindrà l'array: ");
            int arrayLength = sc.nextInt();
            sc.nextLine();

            System.out.println("Ara, insrta els elements separats per espai, exemple -> (43 32 89 67): ");
            String elements = sc.nextLine();

            String[] helperArray = elements.split(" ");

            int[] elementsArray = new int[arrayLength];
            for (int j = 0; j < arrayLength; j++) {
                elementsArray[j] = Integer.parseInt(helperArray[j]);
            }

            System.out.println("Finalment, indica teva mida de sabates: ");
            int measure = sc.nextInt();

            System.out.println("Les sabates " + calculateBootDimension(measure, elementsArray) + " tenen les dimensions adequades.");
        }
    }

    public static String calculateBootDimension(int measure, int[] array) {
        String returnWord = "NO";
        for (int i = 0; i < array.length; i++) {
            if (Math.abs(measure - array[i]) == 1) {
                returnWord = "SI";
            }
        }
        return returnWord;
    }
}
