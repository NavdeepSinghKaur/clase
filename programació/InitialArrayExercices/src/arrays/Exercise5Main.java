package arrays;

import java.util.Scanner;

public class Exercise5Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int arrayLength = 0;
        while (arrayLength <= 0) {
            System.out.println("Indica el tamany que tindrà l'array: ");
            arrayLength = sc.nextInt();
            if (arrayLength <= 0) {
                System.out.println("El número ha de ser natural i positiu.");
            }
        }

        double[] heights = new double[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            System.out.println("Inserta la altura número " + i + ":");
            heights[i] = sc.nextDouble();
        }

        double[] outputHeights = heightCalculator(heights);

        System.out.println("La altura mitjana és: " + outputHeights[0] + "\n" + "La altura més baija: " + outputHeights[1] + "\n" + "La altura més alta és: " + outputHeights[2]);

    }

    public static double[] heightCalculator(double[] heights) {

        double heightsSum = 0;
        double shortest = heights[0];
        double tallest = heights[0];

        for (double height : heights) {
            heightsSum += height;
            if (shortest > height) {
                shortest = height;
            }
            if (tallest < height) {
                tallest = height;
            }
        }
        double medianHeight = heightsSum/heights.length;

        double[] heightsCalculated = new double[3];
        heightsCalculated[0] = medianHeight;
        heightsCalculated[1] = shortest;
        heightsCalculated[2] = tallest;

        return heightsCalculated;
    }
}
