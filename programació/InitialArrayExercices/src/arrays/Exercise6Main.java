package arrays;

import java.util.Scanner;

public class Exercise6Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Inserta els cassos de prova: ");
        int testCases = sc.nextInt();
        String[] output = new String[testCases];
        for (int i = 0; i < testCases; i++) {
            System.out.println(i+1 + " de " + testCases);

            System.out.println("Inidca el número d'aperitius que ha robat el Dani: ");
            int lostFood = sc.nextInt();
            sc.nextLine();

            System.out.println("Inserta els aperitius separats per espai buit exemple -> (aperitiu1 aperitiu2): ");
            String notFormattedFood = sc.nextLine();

            String[] formattedFood = notFormattedFood.split(" ");

            output[i] = remainingFood(lostFood, formattedFood);
        }

        for (String food : output) {
            System.out.println(food);
        }
    }

    public static String remainingFood(int lostFood, String[] foodArray) {
        String leftFood = "";
        for (int i = 0; i < foodArray.length; i++) {
            if ((i+1) % lostFood != 0) {
                leftFood += foodArray[i] + " ";
            }
        }
        return leftFood;
    }
}
