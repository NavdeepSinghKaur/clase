package recursivity;

import java.io.*;
import java.util.Scanner;

public class DivideAndConquerExercici1 {
    public static void main(String[] args) {
        File inputFile = new File("files/binary_search.txt");
        File outputFile = new File("results/binary_search.txt");

        try {
            FileReader fr = new FileReader(inputFile);
            BufferedReader br = new BufferedReader(fr);
            Scanner scanner = new Scanner(br);

            FileWriter fw = new FileWriter(outputFile);
            BufferedWriter bw = new BufferedWriter(fw);
            br.readLine();
            int[] array = arraySplitter(br.readLine(), ", ");
            br.readLine();
            br.readLine();
            String line = br.readLine();
            while (line != null && !line.isEmpty()) {
                int element = Integer.parseInt(line);
                int value = binarySearch(array, element, 0, array.length-1);
                if (value == -1) {
                    bw.write(element + ": Valor no trobat");
                } else {
                    bw.write(element + ": Valor trobat a la posició: " + value);
                }
                bw.newLine();
                bw.flush();
                line = br.readLine();
            }


        } catch (IOException _) {}
    }

    private static int binarySearch(int[] array, int element, int left, int right) {
        int pointer = (right + left)/2;
        if (Math.abs(right - left) > 1) {
            if (array[pointer] == element) {
                return pointer;
            }
            if (array[pointer] > element) {
                //right = pointer;
                return binarySearch(array, element, left, pointer);
            } else if (array[pointer] < element){
                //left = pointer;
                return binarySearch(array, element, pointer, right);
            }
        } /*else if (array[left] == element) {
            return left;
        } else if (array[pointer] == element) {
            return pointer;
        } else if (array[right] == element) {
            return right;
        }*/
        return -1;
    }

    private static int[] arraySplitter(String arrayElements, String space) {
        String[] stringArray = arrayElements.split(space);
        int[] newArray = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            newArray[i] = Integer.parseInt(stringArray[i]);
        }
        return newArray;
    }
}
