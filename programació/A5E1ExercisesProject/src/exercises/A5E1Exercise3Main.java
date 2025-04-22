package exercises;

import java.io.*;
import java.util.LinkedList;

public class A5E1Exercise3Main {
    public static void main(String[] args) throws IOException {
        jokes();
    }

    private static void jokes() throws IOException {
        LinkedList<String> finalJoke = new LinkedList<>();
        String path1 = "jokes/jokesPart1.txt";
        String path2 = "jokes/jokesPart2.txt";
        File f1 = new File(path1);
        File f2 = new File(path2);

        readJokes(f1, f2, finalJoke);

        writeJokes(finalJoke);
    }

    private static void readJokes(File f1, File f2, LinkedList<String> finalJoke) throws IOException {
        FileReader fr1 = new FileReader(f1);
        FileReader fr2 = new FileReader(f2);

        BufferedReader br1 = new BufferedReader(fr1);
        BufferedReader br2 = new BufferedReader(fr2);

        String line1 = br1.readLine();
        String line2 = br2.readLine();
        while (line1 != null && line2 != null) {
            finalJoke.add(line1);
            finalJoke.add(line2);
            line1 = br1.readLine();
            line2 = br2.readLine();
        }
        br1.close();
        br2.close();
        fr1.close();
        fr2.close();
    }

    private static void writeJokes(LinkedList<String> finalJoke) throws IOException {
        File f = new File("jokes/jokesFinal.txt");
        FileWriter fw = new FileWriter(f);
        BufferedWriter bw = new BufferedWriter(fw);

        for (String s : finalJoke) {
            bw.write(s);
            bw.newLine();
            bw.flush();
        }
        bw.close();
        fw.close();
    }
}
