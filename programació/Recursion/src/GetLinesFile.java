import java.io.*;
import java.util.Scanner;

public class GetLinesFile {
    public static void main(String[] args) {
        BufferedReader bf = null;
        File f = null;
        try {
            f = new File("level1/Five_lines_file.txt");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        countLinesFile(f);

    }
    private static void countLinesFile(File f) {
        int count = 0;
        Scanner sc = null;
        try {
            sc = new Scanner(f);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            while (sc.hasNextLine()) {
                count++;
                sc.nextLine();
            }

        } catch (Exception _) {

        }
        System.out.println(count);
        sc.close();
    }

    private static void countLinesFile2(File f) {
        int count = 0;
        Scanner sc = null;
        try {
            sc = new Scanner(f);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            while (sc.hasNextLine()) {
                count++;
                sc.nextLine();
            }

        } catch (Exception _) {

        }
        System.out.println(count);
    }

}
