package exercises;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Random;
import java.util.Scanner;

public class A5E1Exercise2Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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
                    String file = scanner.nextLine();

                    try {
                        fileCreator(file);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 2:
                    break;
                default:
                    System.out.println("No has elegit una opció vàlida. Torna a intentar-ho.");
            }

        }

    }


    public static void fileCreator(String path) throws IOException {
        Random random = new Random();

        File f = new File(path);
        FileWriter fw = new FileWriter(f);
        BufferedWriter bw = new BufferedWriter(fw);

        if (f.getParentFile().isDirectory()) {
            if (!f.getParentFile().exists()) {
                f.getParentFile().mkdir();
            }
        }

        int n = random.nextInt(10, 251);

        for (int i = 0; i < n; i++) {
            bw.write(String.valueOf(random.nextInt(10, 10001)));
            bw.newLine();
            bw.flush();
        }
        bw.close();
        fw.close();
    }


}
