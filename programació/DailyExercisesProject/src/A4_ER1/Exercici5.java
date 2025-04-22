package A4_ER1;

public class Exercici5 {
    public static void main(String[] args) {
        String filename = "casa";

        System.out.println(capitalizeA(filename, 0));
    }

    private static String capitalizeA(String filename, int i) {
        if (i < filename.length()) {
            if (filename.charAt(i) == 'a') {
                return "A" + capitalizeA(filename, i + 1);
            } else {
                return filename.charAt(i) + capitalizeA(filename, i + 1);
            }
        } else {
            return "";
        }
    }
}
