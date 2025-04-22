package recursivity;

import java.io.*;

public class Exercici4 {
    public static void main(String[] args) {
        File inputFile = new File("files/factorials.txt");
        File outputFile = new File("results/factorials.txt");

        try {
            FileReader fr = new FileReader(inputFile);
            BufferedReader br = new BufferedReader(fr);

            FileWriter fw = new FileWriter(outputFile);
            BufferedWriter bw = new BufferedWriter(fw);
            br.readLine();
            int iterations = Integer.parseInt(br.readLine());
            br.readLine();
            br.readLine();
            calculateFactorialsRecursive(iterations, br, bw);

            bw.close();
            fw.close();
            br.close();
            fr.close();
        } catch (Exception _) {}


    }
    private static void calculateFactorialsRecursive(int i, BufferedReader br, BufferedWriter bw) throws IOException {
        if (i >= 0) {
            String line = br.readLine();

            long factorial = calculateFactorial(Integer.parseInt(line), 1);
            bw.write(factorial + " ");
            bw.flush();
            bw.newLine();

            calculateFactorialsRecursive(i-1, br, bw);
        }
    }
    private static long calculateFactorial(int number, int output) {
        if (number > 1) {
            return calculateFactorial(number-1, output*number);
        } else {
            return output;
        }
    }
}
