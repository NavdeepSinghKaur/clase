package arrays;

import javax.xml.transform.Source;
import java.util.Random;

public class Exercise9Main {
    public static void main(String[] args) {
        Random random = new Random();
        int[] elements = new int[50];

        for (int i = 0; i < elements.length; i++) {
            elements[i] = random.nextInt(-50, 50);
        }

        System.out.print("Array original: ");
        for (int element : elements) {
            System.out.print(element + " ");
        }
        System.out.println();
        int[] sortedArray = arrayGenerator(elements);
        System.out.print("Array ordenat (menor a major): ");
        for (int i : sortedArray) {
            System.out.print(i + " ");
        }
    }
    public static int[] arrayGenerator(int[] array) {
        int biggestElement = array[0];
        for (int i = 0; i < array.length; i++) {
            for (int k : array) {
                if (k > biggestElement) {
                    biggestElement = k;
                }
            }
        }
        biggestElement++;

        int[] copyArray = new int[array.length];
        int smallestElement = array[0];
        int arrayPosition = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[j] < smallestElement && array[j] != biggestElement) {
                    smallestElement = array[j];
                    arrayPosition = j;
                }
            }
            array[arrayPosition] = biggestElement;
            copyArray[i] = smallestElement;
            smallestElement = biggestElement;
        }
        return copyArray;
    }
}