import model.Alumne;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class LecturaFitxer {
    public static void main(String[] args) {
        ArrayList<Alumne> alumnes = new ArrayList<>();
        llegirLlistaAlumnesV2(alumnes, "src/dades.csv");
    }

    private static void llegirLlistaAlumnes(ArrayList<Alumne> alumnes, String s) {
        try {
            Scanner sc = new Scanner(new File(s));
            String line;
            sc.nextLine(); // skip first line
            while (sc.hasNextLine()) {
                line = sc.nextLine();
                String[] arr = line.split(",");
                Alumne a = new Alumne(arr[0], arr[1], Integer.parseInt(arr[2]), arr[3]);
                alumnes.add(new Alumne(a));
                sc.close();
            }

        } catch (Exception _) {

        }
    }
    private static void llegirLlistaAlumnesV2(ArrayList<Alumne> alumnes, String s) {
        try {
            FileReader fr = new FileReader(s);
            BufferedReader br = new BufferedReader(fr);

            br.lines()
            .skip(2) // numero linees a saltar
            .forEach((String line) -> {
                System.out.println(line);
                System.out.println(line.replace("\"", ""));

            } );

            br.close();
            fr.close();

        } catch (Exception _) {

        }
    }
}
