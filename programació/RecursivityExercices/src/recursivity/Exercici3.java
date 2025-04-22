package recursivity;

import java.io.*;

public class Exercici3 {
    public static void main(String[] args) {
        File inputFile = new File("files/exp.txt");
        File outputFile = new File("results/exp.txt");

        try {
            FileReader fr = new FileReader(inputFile);
            BufferedReader br = new BufferedReader(fr);

            FileWriter fw = new FileWriter(outputFile);
            BufferedWriter bw = new BufferedWriter(fw);
            br.readLine();
            int iterations = Integer.parseInt(br.readLine());
            br.readLine();
            br.readLine();
            calculateExpRecustive(iterations, br, bw);

            bw.close();
            fw.close();
            br.close();
            fr.close();
        } catch (Exception _) {}
    }

    private static void calculateExpRecustive(int i, BufferedReader br, BufferedWriter bw) throws IOException {
        if (i >= 0) {
            String line = br.readLine();
            String[] numbers = line.split("\\s+");
            long exponential = calculateExponent( Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1]) );

            bw.write(exponential + " ");
            bw.flush();
            bw.newLine();

            calculateExpRecustive(i-1, br, bw);

        }
    }

    private static long calculateExponent(int num1, int num2) {
        long exponent = 1;
        for (int i = 0; i < num2; i++) {
            exponent *= num1;
        }

        return exponent;
    }

}
