import java.util.Scanner;

public class Exercise4Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Inserta un número enter: ");
        int num = sc.nextInt();

        System.out.println(numberType(num));
    }
    public static String numberType(int num) {
        String returnText = "";

        if (num > 0) {
            returnText = "El número és positiu";
        } else if (num < 0) {
            returnText = "El número és negatiu";
        }
        else {
            returnText = "El número és 0";
        }
        return returnText;
    }
}
