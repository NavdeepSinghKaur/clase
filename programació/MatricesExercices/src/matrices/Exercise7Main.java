package matrices;
import java.util.Random;
import java.util.Scanner;

public class Exercise7Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Indica el nombre de files: ");
        int rows = sc.nextInt();

        System.out.println("Indica el nombre de columnes: ");
        int columns = sc.nextInt();

        int[][] matrix1 = generateMatrix(rows, columns);
        int[][] matrix2 = generateMatrix(columns, rows);


        int[][] matrixC = multiplyMatrices(matrix1, matrix2);

        System.out.println("Matriu (A)");
        System.out.println(printMatrix(matrix1));
        System.out.println("Matriu (B)");
        System.out.println(printMatrix(matrix2));
        System.out.println("Matriu resultant: (AxB)");
        System.out.println(printMatrix(matrixC));
    }

    public static int[][] multiplyMatrices(int[][] matrixA, int[][] matrixB) {
        int[][] newMatrix = new int[matrixA.length][matrixB[0].length];
        for (int i = 0; i < matrixA.length; i++) { //A[i][]
            for (int j = 0; j < matrixB[0].length; j++) { // B[][j]
                for (int k = 0; k < matrixB.length; k++) { // A[][k] B[k][]
                    newMatrix[i][j] += matrixA[i][k]*matrixB[k][j];
                }
            }
        }

        return newMatrix;
    }

    public static String printMatrix (int[][] matrix) {
        String output = "";

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                output += matrix[i][j] + " ";
            }
            output += "\n";
        }
        return output;
    }

    public static int[][] generateMatrix(int rows, int columns) {
        Random random = new Random();
        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = random.nextInt(1, 21);
            }
        }

        return matrix;
    }
}
