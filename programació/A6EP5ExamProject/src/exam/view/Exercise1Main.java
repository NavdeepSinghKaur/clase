package exam.view;


import java.io.*;
import java.nio.Buffer;
import java.util.Scanner;

public class Exercise1Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        float ingressos = 0f;
        float despesses = 0f;

        System.out.println("Inserta el nom del fitxer: ");
        String filename = scanner.nextLine();
        File f = new File(filename);

        while (!f.isFile()) {
            System.out.println("Torna a intentar-ho: ");
            filename = scanner.nextLine();
            f = new File(filename);
        }

        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();

            FileWriter fw = new FileWriter(f, true);
            BufferedWriter bw = new BufferedWriter(fw);

            while (line != null && !line.isEmpty()) {
                System.out.println(line);
                String[] elements = line.split(";");
                if (elements[0].equals("I")) {
                    ingressos += Float.parseFloat(elements[2].replace("€", ""));
                } else {
                    despesses += Float.parseFloat(elements[2].replace("€", ""));
                }
                line = br.readLine();
            }

            bw.append("Ingressos totals: " + ingressos);
            bw.flush();
            bw.append("Despesses totals: " + despesses);
            bw.flush();
            bw.append("Balanç final: " + (ingressos-despesses));
            bw.flush();
            bw.close();
            fw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
