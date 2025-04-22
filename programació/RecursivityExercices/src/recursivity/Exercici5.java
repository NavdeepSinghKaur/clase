package recursivity;

import java.io.*;

public class Exercici5 {
    public static void main(String[] args) {
        File inputFile = new File("files/invert.txt");
        File outputFile = new File("results/invert.txt");

        try {
            FileReader fr = new FileReader(inputFile);
            BufferedReader br = new BufferedReader(fr);

            FileWriter fw = new FileWriter(outputFile);
            BufferedWriter bw = new BufferedWriter(fw);

            br.readLine();
            int iterations = Integer.parseInt(br.readLine());

            for (int i = 0; i < 5; i++) {
                br.readLine();
            }
            for (int i = 0; i < iterations; i++) {
                String line = br.readLine();
                String[] lineLists = line.split(",");
                int length = Integer.parseInt(lineLists[0]);
                String[] elements = lineLists[1].split("\\s+");
                invertNumbers(length, elements, bw);
            }
            bw.close();
            br.close();
            fw.close();
            fr.close();
        } catch (Exception _) {}

    }

    private static void invertNumbers(int length, String[] elements, BufferedWriter bw) throws IOException {
        if (length-1 >= 0) {
            bw.write(elements[length] + " ");
            bw.flush();

            invertNumbers(length-1, elements, bw);
        } else {
            bw.newLine();
            bw.flush();
        }
    }


}
