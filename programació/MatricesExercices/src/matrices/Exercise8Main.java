package matrices;

import java.util.Random;
import java.util.Scanner;

public class Exercise8Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Indica un valor positiu més gran que 0: ");
        int number = sc.nextInt();

        int[][] matrix = matrixInitializer();

    }
    public static int[][] matrixInitializer() {
        Random random = new Random();
        int[][] matrix = new int[3][3];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = random.nextInt(1, 15);
            }
        }
        return matrix;
    }

    public static String[][] numberFinder(int number, int[][] matrix) {
        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                sum += matrix[i][j];
                if (j == 2 && sum == number) {

                }
            }
            sum = 0;
        }
    }
}
