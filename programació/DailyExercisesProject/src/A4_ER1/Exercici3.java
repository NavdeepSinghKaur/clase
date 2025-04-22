package A4_ER1;

public class Exercici3 {
    public static void main(String[] args) {

        String num = convertToString(56);

        System.out.println(eachValue(num, 0));
    }

    private static String convertToString(int num) {
        return String.valueOf(num);
    }

    private static int eachValue(String num, int i) {
        if (i < num.length()) {
            return Integer.parseInt(String.valueOf(num.charAt(i))) + eachValue(num, i+1);
        } else {
            return 0;
        }
    }
}
