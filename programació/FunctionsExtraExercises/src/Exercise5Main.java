import java.util.Scanner;

public class Exercise5Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Inserta la distància en kilòmetres: ");
        double kilometers = sc.nextDouble();

        System.out.println("La distància en milles és: " + kilometersToMiles(kilometers));
    }
    public static double kilometersToMiles(double kilometers) {
        return kilometers/1.60934;
    }
}
