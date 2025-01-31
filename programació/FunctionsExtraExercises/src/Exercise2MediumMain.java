import java.util.Scanner;

public class Exercise2MediumMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introdueix el dia del calendari: ");
        int day = sc.nextInt();

        System.out.println("Introdueix el mes del calendari: ");
        int month = sc.nextInt();

        System.out.println("Introdueix l'any del calendari");
        int year = sc.nextInt();

        System.out.println(validDateCalculator(day, month, year));
    }

    public static String validDateCalculator(int day, int month, int year) {
        String returnText;
        if (year < 0) {
            returnText = "No has introduït un any correcte.";
        } else if (month < 1 || month > 12){
            returnText = "No has introduït un mes correcte.";
        } else if (month == 2 && day >= 1 && day <= 29 && (year % 4 == 0 || year % 400 == 0)) {
            returnText = "La data és correcta.";
        } else if (month == 2 && day >= 1 && day <= 28) {
            returnText = "La data és correcta.";
        } else if ((month == 4 || month == 6 || month == 9) && day >= 1 && day <= 30) {
            returnText = "La data és correcta.";
        } else if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
                    && day >= 1 && day <= 31){
            returnText = "La data és correcta.";
        } else {
            returnText = "El día no es correcte.";
        }
        return returnText;
    }
}