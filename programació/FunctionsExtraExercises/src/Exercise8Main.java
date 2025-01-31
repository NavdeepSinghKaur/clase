import java.util.Scanner;

public class Exercise8Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exitMainMenu = false;
        while (!exitMainMenu) {
            int number;
            int userInput = 0;
            System.out.println("""
                    ~~~~ MENÚ ~~~~
                    0. Sortir
                    1. Sumar els parells
                    2. Sumar els imparells
                    
                    Entrada:
                    """);

            userInput = sc.nextInt();

            switch (userInput) {
                case 0:
                    exitMainMenu = true;
                    System.out.println("El programa es tancarà inmediatament.");
                    sc.close();
                    break;
                case 1:
                    System.out.println("Inserta el número: ");
                    number = sc.nextInt();
                    System.out.println("Resultat: " + evenSum(number));
                    break;
                case 2:
                    System.out.println("Inserta el número: ");
                    number = sc.nextInt();
                    System.out.println("Resultat: " + oddSum(number));
                    break;
                default:
                    System.out.println("Inserta una opció vàlida. Torna a intentar-ho.");
            }
        }
    }
    public static int evenSum(int num) {
        int result = 0;
        for (int i = 1; i <= num; i++) {
            if (i%2==0) {
                result += i;
            }
        }
        return result;
    }
    public static int oddSum(int num) {
        int result = 0;
        for (int i = 1; i <= num; i++) {
            if (i%2!=0) {
                result += i;
            }
        }
        return result;
    }
}
