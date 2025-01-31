import java.util.Scanner;

public class Exercise6Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Inserta el preu del producte sense IVA: ");
        double productPrice = sc.nextDouble();

        System.out.println("Preu del producte amb 21% d'IVA: " + gstCalculator(productPrice));
    }

    public static double gstCalculator(double productPrice) {
        return productPrice*1.21;
    }
}
