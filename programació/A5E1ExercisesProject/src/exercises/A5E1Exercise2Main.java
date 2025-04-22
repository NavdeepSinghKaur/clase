package exercises;

import java.io.*;
import java.util.*;

public class A5E1Exercise2Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String file;
        boolean exit = false;

        while (!exit) {
            System.out.println("""
                ~~~~ GESTIÓ DE FITXERS ~~~~
                    0. Sortir
                    1. Crear un nou fitxer
                    2. Ordenar un fitxer existent
                    Opció:
                """);
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    exit = true;
                    scanner.close();
                    break;
                case 1:
                    System.out.println("Introdueïx el nom amb l'ubicació del fitxer: ");
                    file = scanner.nextLine();

                    try {
                        fileCreator(file);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 2:
                    System.out.println("Introdueix el nom del fitxer: ");
                    file = scanner.nextLine();
                    System.out.println("Ara, indica el nom del fitxer on guaradàs les dades: ");
                    String newFile = scanner.nextLine();

                    try {
                        int lines = cleanFile(file, newFile);
                        System.out.println("L'arxiu carregat a " + newFile + " té " + lines + " línies.");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                default:
                    System.out.println("No has elegit una opció vàlida. Torna a intentar-ho.");
            }

        }

    }

    private static void fileCreator(String path) throws IOException {
        Random random = new Random();

        //create file
        File f = new File(path);
        FileWriter fw = new FileWriter(f);
        BufferedWriter bw = new BufferedWriter(fw);

        if (f.getParentFile().isDirectory()) {
            if (!f.getParentFile().exists()) {
                f.getParentFile().mkdirs();
            }
        }

        //create random lines
        int n = random.nextInt(10, 251);

        for (int i = 0; i < n; i++) {
            bw.write(String.valueOf(random.nextInt(10, 10001)));
            bw.newLine();
            bw.flush();
        }
        bw.close();
        fw.close();
    }

    private static int cleanFile(String fileToRead, String fileToWrite) throws IOException {
        File f = new File(fileToRead);
        String[] words;
        int countLines = 0;
        String line = "";
        String filteredLine = "";

        //reading
        if (f.isFile()) {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            Scanner scanner = new Scanner(br);

            while (scanner.hasNextLine()) {
                LinkedHashSet<String> set = new LinkedHashSet<>();
                line = scanner.nextLine();
                words = line.split(" ");

                for (String word : words) {
                    set.add(word);
                }

                for (String s : set) {
                    filteredLine += s + " ";
                }
                filteredLine += "\n";
                countLines++;
            }
            scanner.close();
            br.close();
            fr.close();
        }

        // writing
        writeContentToFile(fileToWrite, filteredLine);

        return countLines;
    }

    private static void writeContentToFile(String fileToWrite, String filteredLine) throws IOException {
        File f;
        f = new File(fileToWrite);
        FileWriter fw = new FileWriter(f);
        BufferedWriter bw = new BufferedWriter(fw);

        if (f.getParentFile().isDirectory()) {
            if (!f.getParentFile().exists()) {
                f.getParentFile().mkdirs();
            }
        }
        bw.write(filteredLine);
        bw.close();
        fw.close();
    }
}
