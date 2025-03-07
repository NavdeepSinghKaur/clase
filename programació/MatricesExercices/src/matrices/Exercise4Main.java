package matrices;

import java.util.Random;
import java.util.Scanner;

public class Exercise4Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] matrix = matrixInitializer();

        int value = -101;
        while (value < -100 || value > 100) {
            System.out.println("Introdueix el valor que vols buscar dins de la matriu. HA DE ESTAR ENTE -100 I 100: ");
            value = sc.nextInt();
        }

        int[][] values = valueFinder(value, matrix);
        if (values[40][0] == 1) {
            System.out.println("La seüent és la coordenada en la que s'ha trobat el valor: ");
        }
        else if (values[40][0] > 1) {
            System.out.println("Les següents són les coordenades on s'ha trobat el valor: ");
        }
        else {
            System.out.println("No s'ha trobat el valor en la matriu.");
        }
        for (int i = 0; i < values[40][0]; i++) {
            System.out.println(values[i][0] + " " + values[i][1]);
        }
    }

    public static int[][] matrixInitializer() {
        Random random = new Random();
        int[][] matrix = new int[10][4];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = random.nextInt(-100, 101);
            }
        }

        return matrix;
    }
    public static int[][] valueFinder(int value, int[][] matrix) {
        int[][] values = new int[41][2];
        int counter = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == value) {
                    values[counter][0] = i;
                    values[counter][1] = j;
                    counter++;
                }
            }
        }

        values[40][0] = counter;
        return values;
    }
}
