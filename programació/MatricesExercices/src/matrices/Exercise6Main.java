package matrices;

import java.util.Random;
import java.util.Scanner;

public class Exercise6Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introdueix les dimensions de les matrius separades per espai, exemple -> (9 3): ");
        String inputText = sc.nextLine();

        String[] stringArray = inputText.split(" ");

        int[] array = new int[2];
        for (int i = 0; i < stringArray.length; i++) {
            array[i] = Integer.parseInt(stringArray[i]);
        }

        int[][] matrix1 = initializeMatrix(array);
        int[][] matrix2 = initializeMatrix(array);
        System.out.println("Les matrius son:\n" + showMatrix(matrix1) + "\n" + showMatrix(matrix2));

        int[][] outputMatrix = sumMatrix(matrix1, matrix2);
        System.out.println("La matriu resultant és:\n" + showMatrix(outputMatrix));
    }

    public static String showMatrix(int[][] matrix) {
        String outputString = "";
        for (int[] i :matrix) {
            for (int j:i) {
                if (j>9) {
                    outputString += "| " + j + " ";
                }
                else {
                    outputString += "|  " + j + " ";
                }
            }
            outputString += "\n";
        }
        return outputString;
    }
    public static int[][] initializeMatrix (int[] dimensions) {
        Random random = new Random();
        int[][] matrix = new int[dimensions[0]][dimensions[1]];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = random.nextInt(1, 21);
            }
        }
        return matrix;
    }
    public static int[][] sumMatrix(int[][] matrix1, int[][] matrix2) {
        int[][] outputMatrix = new int[matrix1.length][matrix1[0].length];

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                outputMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return outputMatrix;
    }
}
