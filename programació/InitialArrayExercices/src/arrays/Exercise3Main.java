package arrays;

import java.util.Random;

public class Exercise3Main {
    public static void main(String[] args) {

        int[] arrayReturnValue = randomArrayInitializer();

        System.out.println("Valor mínim de l'array: " + arrayReturnValue[10] + "\nValor màxim de l'array: " + arrayReturnValue[11]);
        System.out.println("Tots els valors de l'array: ");

        for (int i = 0; i < arrayReturnValue.length - 2; i++) {
            System.out.print(" [" + arrayReturnValue[i] + "] ");
        }
    }

    public static int[] randomArrayInitializer() {
        Random random = new Random();

        int[] arrayValues = new int[12];
        for (int i = 0; i < 10; i++) {
            arrayValues[i] = random.nextInt(-100, 100);
        }
        int minValue = arrayValues[0];
        int maxValue = arrayValues[0];

        for (int i = 0; i < 10; i++) {
            if (arrayValues[i] < minValue) {
                minValue = arrayValues[i];
            }
            if (arrayValues[i] > maxValue) {
                maxValue = arrayValues[i];
            }
        }

        arrayValues[10] = minValue;
        arrayValues[11] = maxValue;

        return arrayValues;
    }
}
