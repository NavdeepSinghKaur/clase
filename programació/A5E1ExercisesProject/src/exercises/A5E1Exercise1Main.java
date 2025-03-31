package exercises;

import java.io.*;
import java.util.Scanner;

public class A5E1Exercise1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introdueix un directori: ");
        String dir = sc.nextLine();

        try {
            System.out.println(reader(dir));
        } catch (IOException e) {
            System.out.println("Hi ha hagut un error.");
        }
    }

    public static String reader(String dir) throws IOException {
        File fr = new File(dir);
        String foldersAndFiles = "";
        int nFolders = 0;
        int nFiles = 0;

        if (!fr.exists()) {
            foldersAndFiles += "El directori " + dir + " no existeix.";
        } else if (fr.isDirectory()) {
            File[] allFiles = fr.listFiles();
            foldersAndFiles += "Carpetes:" + "\n";
            if (allFiles != null) {
                for (File f : allFiles) {
                    if (f != null && f.isDirectory()) {
                        foldersAndFiles += "\t" + f.getName() + "\n";
                        nFolders++;
                    }
                }
                foldersAndFiles += "Número de carptetes: " + nFolders + "\n";
            }
            foldersAndFiles += "Arxius:" + "\n";
            if (allFiles != null) {
                for (File f : allFiles) {
                    if (f != null && f.isFile()) {
                        foldersAndFiles += "\t" + f.getName() + "\n";
                        nFiles++;
                    }
                }
                foldersAndFiles += "Número d'arxius: " + nFiles + "\n";
            }
        }

        return foldersAndFiles;
    }
}
