package matrices;

import java.util.Random;
import java.util.Scanner;

public class Exercise5Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introdueix les dimesnions de la matriu separades per coma, exemple -> (6 3): ");
        String matrixInput = sc.nextLine();

        String[] matrixInputArray = matrixInput.split(" ");
        int[] dimension = new int[2];

        for (int i = 0; i < matrixInputArray.length; i++) {
            dimension[i] = Integer.parseInt(matrixInputArray[i]);
        }

        int[][] matrix = matrixGenerator(dimension);
        System.out.println("La següent és la matriu generada: ");
        System.out.println(showMatrix(matrix));

        int[] array = matrixToArray(matrix);
        System.out.println("El següent, és l'array generat: ");
        System.out.println(showArray(array));

        System.out.println("\nArray en forma de matriu: ");
        System.out.println(showArrayAsMatrix(array, dimension));
    }

    public static int[] matrixToArray (int[][] matrix) {
        int[] array = new int[matrix.length*matrix[0].length];
        int counter = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                array[counter] = matrix[i][j];
                counter++;
            }
        }
        return array;
    }

    public static String showMatrix (int[][] matrix) {
        String returnString = "";

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                returnString += matrix[i][j] + " ";
            }
            returnString += "\n";
        }
        return returnString;
    }

    public static String showArrayAsMatrix(int[] array, int[] dimensions) {
        String outputElement = "";
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            outputElement += array[i] + " ";
            counter++;
            if (counter == dimensions[1]) {
                outputElement += "\n";
                counter = 0;
            }
        }
        return outputElement;
    }

    public static String showArray (int[] array) {
        String arrayToString = "";
        for (int i = 0; i < array.length; i++) {
            arrayToString += array[i] + " ";
        }
        return arrayToString;
    }

    public static int[][] matrixGenerator(int[] dimension) {
        Random random = new Random();
        int[][] matrix = new int[dimension[0]][dimension[1]];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = random.nextInt(1, 100);
            }
        }
        return matrix;
    }
}
