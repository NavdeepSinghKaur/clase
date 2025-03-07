package matrices;

import java.util.Random;
import java.util.Scanner;

public class Exercise9Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Indica el número de files de la matriu: ");
        int rows = sc.nextInt();

        System.out.println("Ara, indica el número de columnes de la matriu: ");
        int columns = sc.nextInt();

        int[][] matrix = matrixInitialitzer(rows, columns);
        int[][] trasposedMatrix = trasposeMatrix(matrix);

        System.out.println("Matriu A: ");
        System.out.println(showMatrix(matrix));
        System.out.println("Matriu A trasposada: ");
        System.out.println(showMatrix(trasposedMatrix));
    }

    public static String showMatrix(int[][] matrix) {
        String output = "";
        for (int[] i : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                output += i[j] + " ";
            }
            output += "\n";
        }
        return output;
    }
    public static int[][] matrixInitialitzer(int rows, int columns) {
        Random random = new Random();
        int[][] newMatrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                newMatrix[i][j] = random.nextInt(1, 21);
            }
        }
        
        return newMatrix;
    }
    public static int[][] trasposeMatrix(int[][] matrix) {
        int[][] trasposedMatrix = new int[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                trasposedMatrix[j][i] = matrix[i][j];
            }
        }

        return trasposedMatrix;
    }
}
