package A4_ER1;

public class Exercici4 {
    public static void main(String[] args) {

        String text = "Bon dia";

        System.out.println(reverseText(text, text.length()));
    }

    private static String reverseText(String text, int element) {
        if (element > 0) {
            return text.charAt(element - 1) + reverseText(text, element - 1);
        } else {
            return "";
        }
    }
}
