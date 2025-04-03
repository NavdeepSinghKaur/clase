package exercises;

import java.io.*;
import java.nio.Buffer;
import java.util.LinkedList;

public class A5E1Exercise3Main {
    public static void main(String[] args) throws IOException {
        LinkedList<String> finalJoke = new LinkedList<>();
        String path1 = "jokes/jokesPart1.txt";
        String path2 = "jokes/jokesPart2.txt";
        File f1 = new File(path1);
        File f2 = new File(path2);

        FileReader fr1 = new FileReader(f1);
        FileReader fr2 = new FileReader(f2);

        BufferedReader br1 = new BufferedReader(fr1);
        BufferedReader br2 = new BufferedReader(fr2);

        int n = 0;
        String line1 = br1.readLine();
        String line2 = br2.readLine();
        while (line1 != null && line2 != null) {
            finalJoke.add(line1);
            finalJoke.add(line2);
            line1 = br1.readLine();
            line2 = br2.readLine();
        }
        fr1.close();
        fr2.close();
        br1.close();
        br2.close();

        File f = new File("jokes/jokesFinal.txt");
        FileWriter fw = new FileWriter(f1);
        BufferedWriter bw = new BufferedWriter(fw);

        for (String s : finalJoke) {
            bw.write(s);
            bw.newLine();
            bw.flush();
        }
    }
}
