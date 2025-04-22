package recursivity;

import com.sun.source.tree.LiteralTree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Exercici1 {

    public static void main(String[] args) {

        File inputDir = new File("files/integers.txt");
        File outputDir = new File("results/integers.txt");

        try {
            FileReader fr = new FileReader(inputDir);
            BufferedReader br = new BufferedReader(fr);

            FileWriter fw = new FileWriter(outputDir);
            BufferedWriter bw = new BufferedWriter(fw);
            br.readLine();
            int iterations = Integer.parseInt(br.readLine());
            br.readLine();
            br.readLine();
            readNumbersRecursive(iterations, br, bw);

            bw.close();
            fw.close();
            br.close();
            fr.close();
        } catch (Exception _) {}

    }

    private static void readNumbersRecursive(int i, BufferedReader br, BufferedWriter bw) throws IOException {
        if (i >= 0) {
            bw.write(br.readLine());

            bw.flush();
            bw.newLine();

            readNumbersRecursive(i-1, br, bw);
        }
    }
}