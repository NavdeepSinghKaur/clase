package exercises;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class A5E1Exercise5Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        File f = new File("gifts/regals.txt");

        boolean exit = false;

        while (!exit) {
            System.out.println("""
                    ---- Gestió del pagament del regal ----
                    0. Sortir
                    1. Consultar pagament de membre de la colla
                    2. Afegir un nou pagament
                    
                    Opció:
                    """);
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 0:
                    scanner.close();
                    exit = true;
                    break;
                case 1:
                    boolean userExists = false;
                    System.out.println("Entra un nom: ");
                    String name = scanner.nextLine();
                    FileReader fr = new FileReader(f);
                    BufferedReader br = new BufferedReader(fr);
                    String line = br.readLine();

                    while (line != null) {
                        String[] lineList = line.split(",");
                        if (lineList[1].equals(name)) {
                            System.out.println("Codi:" + lineList[0]);
                            System.out.println("Quantitat:" + lineList[2]);
                            userExists = true;
                        }
                        line = br.readLine();
                    }

                    if (!userExists) {
                        System.out.println("Pendent!");
                    }

                    System.out.println("Prem una tecla per sortir: ");
                    while (!scanner.hasNextLine()) {
                        scanner.nextLine();
                    }

                    fr.close();
                    br.close();
                    break;
                case 2:
                    System.out.println("Introdueïx el codi bancari, nom i el pagament separats per coma. Exemple (ES349, Joan, 90€): ");
                    String inputText = scanner.nextLine().trim();
                    FileWriter fw = new FileWriter(f, true);

                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.append(inputText);
                    bw.flush();

                    fw.close();
                    bw.close();
                    break;
                default:
                    System.out.println("Has elecit una opció NO vàlida. Torna a intentar-ho.");
            }

        }
    }
}
