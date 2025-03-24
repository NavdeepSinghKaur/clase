import java.io.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println(extracted());
        //informacioFitxer()
        // System.out.println(readFile("src" + File.separator + "hw.txt"));
        try {
            fileRead("src" + File.separator + "hw.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static String fileRead(String filename) throws FileNotFoundException {
        FileReader freader = new FileReader(filename);
        BufferedReader breader = new BufferedReader(freader);
        Scanner sreader = new Scanner(breader);
        int num;
        float decim;
        String line;

        while(sreader.hasNextInt()) {
            num = sreader.nextInt();
            System.out.println(num);
        }

        while(sreader.hasNextFloat()) {
            decim = sreader.nextFloat();
            System.out.println(decim);
        }

        line = sreader.nextLine();
        System.out.println(line);
        sreader.close();
        return line;
    }

    public static String readFile(String filename) {
        String filecontent = null;
        filecontent = "";
        try {
            FileReader freader = new FileReader(filename);
            BufferedReader breader = new BufferedReader(freader);
            String line = breader.readLine();
            while (line != null) {
                filecontent += line + "\n";
                line = breader.readLine();
            }
            breader.close();
        } catch (IOException _) {
            System.out.println("Exception.");
        }
        return filecontent;
    }

    private static void informacioFitxer() {
        File file = new File("src" + File.separator + "hw.txt");
        System.out.println(file.isFile());
        file.delete();

        File newFile = new File("src");
        System.out.println(newFile.isDirectory());
        String[] dirFilesName;

        dirFilesName = newFile.list();
        for (int i = 0; i < dirFilesName.length; i++) {
            System.out.println(dirFilesName[i]);
        }
    }

    private static String extracted() {
        StringBuilder output = new StringBuilder();
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("src" + File.separator + "hw.txt");
            int i = fileReader.read();
            while (i != -1) {
                output.append((char) i);
                i = fileReader.read();
            }
            fileReader.close();

        } catch (Exception _) {
        }

        return output.toString();
    }
}