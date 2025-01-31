import java.util.Scanner;

public class Exercise7Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Inserta el radi del cercle: ");
        double circleRadious = sc.nextDouble();

        System.out.println("L'àrea del cercle és: " + areaCalculator(circleRadious));
    }

    public static double areaCalculator(double radious) {
        return Math.PI*(radious*radious);
    }
}
