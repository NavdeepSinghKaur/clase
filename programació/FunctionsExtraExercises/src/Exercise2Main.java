import java.util.Scanner;

public class Exercise2Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int age = 0;
        System.out.println("Inserta la teva edat: ");
        age = sc.nextInt();

        System.out.println(checkAge(age));
    }
    public static String checkAge(int age) {
        String outputText;

        if (age >= 18) {
            outputText = "Ets major de edat.";
        }
        else {
            outputText = "Ets menor de edat.";
        }

        return outputText;
    }
}
