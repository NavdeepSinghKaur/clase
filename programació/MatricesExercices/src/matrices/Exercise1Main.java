package matrices;

import java.util.Random;
import java.util.Scanner;

public class Exercise1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Indica el nombre de files: ");
        int rows = sc.nextInt();

        System.out.println("Indica el nombre de columnes: ");
        int columns = sc.nextInt();

        int[][] matrix = matrixGenerator(rows, columns);
        System.out.println("S'ha generat la segúent matriu: ");
        for (int[] num : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (j % 2 == 0) {
                    System.out.print(" | (");
                }
                if (j % 2 == 0) {
                    System.out.print(num[j] + ", ");
                } else {
                    System.out.print(num[j] + ")");
                }
            }
            System.out.print(" | ");
            System.out.println();
        }
    }
    public static int[][] matrixGenerator(int rows, int columns) {
        Random random = new Random();
        int[][] generatedMatrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                generatedMatrix[i][j] = random.nextInt(0, 4);
            }
        }
        return generatedMatrix;
    }
}
