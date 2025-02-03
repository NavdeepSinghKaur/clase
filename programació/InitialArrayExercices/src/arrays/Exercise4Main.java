package arrays;

import java.util.Random;

public class Exercise4Main {
    public static void main(String[] args) {
        Random random = new Random();

        int[] numbersArray = new int[20];

        for (int i = 0; i < numbersArray.length; i++) {
            numbersArray[i] = random.nextInt(0, 20);
        }
        int[] result = randomPrimeGenerator(numbersArray);

        System.out.println("Array de nombres primers: ");
        for (int j : result) {
            System.out.print(j + " ");
        }
        System.out.println("\nArray original: ");
        for (int i:numbersArray) {
            System.out.print(i + " ");
        }
    }

    public static int[] randomPrimeGenerator(int[] numbersArray) {
        int[] primesArray = new int[numbersArray.length];
        int[] helperArray;
        int counter = -1;
        for (int i:numbersArray) {
            boolean isPrime = true;
            if (i == 2 || i == 1) {
                isPrime = false;
            }
            for (int j = 2; j < i-1; j++) {
                if (i % j == 0) {
                    isPrime = false;
                }
            }
            if (isPrime) {
                counter++;
                primesArray[counter] = i;
            }
        }

        int notZeros = 0;
        for (int i = 0; i < primesArray.length; i++) {
            if (primesArray[i] != 0) {
                notZeros++;
            }
        }

        helperArray = new int[notZeros];

        for (int i = 0; i < primesArray.length; i++) {
            if (primesArray[i] != 0) {
                helperArray[notZeros -1] = primesArray[i];
                notZeros--;
            }
        }
        return helperArray;
    }
}