import java.io.*;

public class Scripture {
    public static void main(String[] args) {
        File f = new File("src" + File.separator + "hw.txt");

        try {
            FileWriter fw = new FileWriter(f, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            fw.append((char) 87);
            fw.flush();
            fw.append((char)57);
            pw.print(true);
            for (int i = 0; i < 100; i++) {
                pw.print(i + "\n");
            }
            pw.close();
            bw.close();
            fw.close();
        } catch (IOException _) {
        }
    }
}
