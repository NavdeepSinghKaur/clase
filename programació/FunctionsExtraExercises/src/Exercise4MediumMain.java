import java.util.Scanner;

public class Exercise4MediumMain {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Inserta el preu del producte abans del descompte: ");
        float priceBeforeDiscount = sc.nextFloat();

        System.out.println("Inserta el preu del producte després del descompte: ");
        float priceAfterDiscount = sc.nextFloat();

        System.out.println("El percentatge de descompte és: " +  discountCalculator(priceBeforeDiscount, priceAfterDiscount) + "% ");
    }

    public static float discountCalculator(float priceBefore, float priceAfter) {
        return ((priceBefore - priceAfter)/priceBefore)*100;
    }
}
