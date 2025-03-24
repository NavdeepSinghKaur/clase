import java.io.File;
import java.io.FileReader;

public class ShowDirs {
    public static void main(String[] args) {

        File f = new File("/home/");
        extracted(f);
    }

    private static void extracted(File f) {
        if (f.isDirectory()) {
            File[] arr = f.listFiles();
            for (File s : arr) {
                if (s.isFile()) {
                    System.out.println("\t" + s.getName());
                } else {
                    System.out.println(s.getName());
                    extracted(s);
                }
            }
        }
    }
    private static void extracted2() {
        File f = new File("level1"/* + File.separator + "Hello_world_1.txt"*/);
        if (f.isDirectory()) {
            String[] arr = f.list();
            for (String s : arr) {
                System.out.println(s);
            }
        } else {
            System.out.println("Es normal");
        }
    }
}
