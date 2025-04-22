package recursivity;

import java.io.*;

public class DivideAndConquerExercici2 {
    public static void main(String[] args) {
        File inputFile = new File("files/quicksort.txt");
        File outputFile = new File("results/quicksort.txt");

        try {
            FileReader fr = new FileReader(inputFile);
            BufferedReader br = new BufferedReader(fr);

            FileWriter fw = new FileWriter(outputFile);
            BufferedWriter bw = new BufferedWriter(fw);

            String line = br.readLine();
            String[] lineList = line.split(" ");
            int[] elements = new int[lineList.length];
            for (int i = 0; i < lineList.length; i++) {
                elements[i] = Integer.parseInt(lineList[i]);
            }

        } catch (IOException _) {}

    }

    private static int[] quickSort(int[] array, int pivot) {
        boolean hasFinished = true;
        for (int i = 0; i < array.length-1; i++) {
            if (array[i+1] < array[i]) {
                hasFinished = false;
            }
        }
        if (!hasFinished) {
            String smallerPivot = "";
            String biggerEqualPivot = "";
            for (int i = 0; i < array.length; i++) {
                if (array[i] < pivot) {
                    smallerPivot += array[i] + " ";
                } else {
                    biggerEqualPivot += array[i] + " ";
                }
            }
            String[] smallerPivotStringList = smallerPivot.split(" ");
            String[] biggerEqualPivotStringList = biggerEqualPivot.split(" ");
            
        }
    }

}
