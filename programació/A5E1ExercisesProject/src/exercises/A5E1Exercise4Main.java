package exercises;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class A5E1Exercise4Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Indica el fitxer a crear: ");
        String pathname = scanner.nextLine();

        File f = new File(pathname);
        FileWriter fw = new FileWriter(f, true);
        BufferedWriter bw = new BufferedWriter(fw);

        makeFile(f);

        System.out.println("Inserta el text: ");
        String text = scanner.nextLine();
        writeToNewFile(text, bw, scanner, fw);
    }

    private static void writeToNewFile(String text, BufferedWriter bw, Scanner scanner, FileWriter fw) throws IOException {
        while (!text.isEmpty()) {
            bw.append(text);
            bw.newLine();
            bw.flush();
            text = scanner.nextLine();
        }

        bw.close();
        fw.close();
    }

    private static void makeFile(File f) {
        if (f.getParentFile().isDirectory()) {
            if (!f.getParentFile().exists()) {
                f.getParentFile().mkdirs();
            }
        }
    }
}
