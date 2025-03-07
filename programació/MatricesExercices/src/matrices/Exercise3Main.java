package matrices;

import java.util.Random;
import java.util.Scanner;

public class Exercise3Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introdueix el número de files de la matriu:");
        int rows = sc.nextInt();

        System.out.println("Introdueix el número de columnes de la matriu: ");
        int columns = sc.nextInt();

        int maxNumber = 0;
        while (maxNumber < 1) {
            System.out.println("Introdueix el número máxim de la matriu: ");
            maxNumber = sc.nextInt();
            if (maxNumber < 1) {
                System.out.println("ERROR: El nombre máxim ha de ser major de 0.");
            }
        }

        int[][] matrix = matrixInitializer(maxNumber, rows, columns);
        System.out.println("La següent és la matriu: ");
        System.out.println(matrixPrintingAlgorithm(matrix));

        boolean notZero = true;
        int iterator = 0;
        while (notZero) {
            notZero = matrixCheckingAlgorithm(matrix);
            if (notZero) {
                iterator++;
                System.out.println("Actualització de la matriu " + iterator + ":");
                matrixReducer(matrix);
                System.out.println(matrixPrintingAlgorithm(matrix));

            }
        }
    }

    public static boolean matrixCheckingAlgorithm(int[][] matrix) {
        boolean notZero = false;
        for (int[] i : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i[j] > 0) {
                    notZero = true;
                }
            }
        }
        return notZero;
    }
    public static int[][] matrixInitializer(int maxNumber, int rows, int columns) {
        Random random = new Random();
        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = random.nextInt(0, maxNumber+1);
            }
        }

        boolean hasZeros = false;
        for (int[] num : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (num[j] == 0) {
                    hasZeros = true;
                }
            }
        }
        if (!hasZeros) {
            matrix[random.nextInt(0, matrix.length)][random.nextInt(0, matrix[0].length)] = 0;
        }
        return matrix;
    }

    public static void matrixReducer(int[][] matrix) {
        int[][] zeros = new int[matrix.length*matrix[0].length][2];
        int counter = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    zeros[counter][0] = i;
                    zeros[counter][1] = j;
                    counter++;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                for (int k = 0; k < counter; k++) {
                    if ((Math.abs(i-zeros[k][0]) == 1 && Math.abs(j-zeros[k][1]) == 0
                            || Math.abs(i-zeros[k][0]) == 0 && Math.abs(j-zeros[k][1]) == 1)
                            && matrix[i][j] > 0) {
                        matrix[i][j]--;
                    }
                }
            }
        }
    }

    public static String matrixPrintingAlgorithm(int[][] matrix) {
        String matrixToString = "";
        for (int[] i : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrixToString += i[j] + " ";
            }
            matrixToString += "\n";
        }
        return matrixToString;
    }
}
