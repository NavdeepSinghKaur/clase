package arrays;

import java.util.Scanner;

public class Exercise7Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Indica els cassos de prova: ");
        int testCases = sc.nextInt();
        sc.nextLine();
        String[] outputArray = new String[testCases];

        for (int i = 0; i < testCases; i++) {
            System.out.println("Cas " + (i+1) + " de " + testCases + "\n");
            System.out.println("Indica el tamany de l'array: ");
            int arrayLength = sc.nextInt();
            sc.nextLine();

            System.out.println("Indica els números separats per espais exemple -> (4 8 3 20 ): ");
            String numbersString = sc.nextLine();

            String[] numbersStringArray = numbersString.split(" ");
            int[] numbersArray = new int[arrayLength];
            for (int j = 0; j < arrayLength; j++) {
                numbersArray[j] = Integer.parseInt(numbersStringArray[j]);
            }

            System.out.println("Ara, indica el valor a canviar i el valor que el substituirà separats amb espai -> exemple(3 9)," +
                    " el valor 3 es canviarà pel 9 a l'array: ");
            String valuesToChangeString = sc.nextLine();

            String[] valuesToChangeStringArray = valuesToChangeString.split(" ");
            int[] valuesToChangeArray = new int[valuesToChangeStringArray.length];

            for (int j = 0; j < valuesToChangeArray.length; j++) {
                valuesToChangeArray[j] = Integer.parseInt(valuesToChangeStringArray[j]);
            }

            outputArray[i] = arrayValueChanger(numbersArray, valuesToChangeArray);
        }

        for (int i = 0; i < outputArray.length; i++) {
            System.out.print("Array " + (i+1) + ": "  + outputArray[i]);
            System.out.println();
        }
    }

    public static String arrayValueChanger(int[] array, int[] valuesToChange) {
        String arrayToString = "";
        for (int i = 0; i < array.length; i++) {
            if (array[i] == valuesToChange[0]) {
                array[i] = valuesToChange[1];
            }
            arrayToString += array[i] + " ";
        }
        return arrayToString;
    }
}
