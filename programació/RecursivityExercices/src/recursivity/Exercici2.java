package recursivity;

import java.io.*;

public class Exercici2 {
    public static void main(String[] args) {
        File inputFile = new File("files/multiplications.txt");
        File outputFile = new File("results/multiplications.txt");

        try {
            FileReader fr = new FileReader(inputFile);
            BufferedReader br = new BufferedReader(fr);

            FileWriter fw = new FileWriter(outputFile);
            BufferedWriter bw = new BufferedWriter(fw);
            br.readLine();
            int iterations = Integer.parseInt(br.readLine());
            br.readLine();
            br.readLine();
            readMultiplicationsRecursive(iterations, br, bw);

            bw.close();
            fw.close();
            br.close();
            fr.close();
        } catch (Exception _) {}
    }

    private static void readMultiplicationsRecursive(int i, BufferedReader br, BufferedWriter bw) throws IOException {
        if ( i >= 0) {
            String line = br.readLine();
            String[] numbers = line.split("\\s+");

            int multiplication = Integer.parseInt(numbers[0]) * Integer.parseInt(numbers[1]);
            String multiplicationToStr = multiplication + " ";
            bw.write(multiplicationToStr);
            bw.flush();
            bw.newLine();

            readMultiplicationsRecursive(i-1, br, bw);
        }
    }
}
