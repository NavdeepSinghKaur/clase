package matrices;

import java.util.Random;
import java.util.Scanner;

public class Exercise2Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] matrix = new int[6][2];

        System.out.println("Inserta el número d'iteracions: ");
        int iterationNum = sc.nextInt();

        for (int i = 0; i < 6; i++) {
            matrix[i][0] = i+1;
        }

        for (int i = 0; i < iterationNum; i++) {
            numGenerator(matrix);
            System.out.println("Iteració " + (i+1) + " de " + iterationNum);
            for (int[] num : matrix) {
                for (int k = 0; k < matrix[0].length; k++) {
                    System.out.print(num[k] + " ");
                }
                System.out.println();
            }
        }
    }

    public static void numGenerator(int[][] matrix) {
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            matrix[i][0] = i+1;
        }
        int generatedNum = random.nextInt(1, 7);
        for (int j = 0; j < matrix.length; j++) {
            if (matrix[j][0] == generatedNum) {
                matrix[j][1]++;
            }
        }
    }
}
