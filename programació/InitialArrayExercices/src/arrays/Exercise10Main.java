package arrays;

import java.util.Scanner;

public class Exercise10Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Indica quants cassos de prova hi hauràn: ");
        int testCases = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < testCases; i++) {
            System.out.println("Indica el tamany de l'array de pilots: ");
            int arrayLength = sc.nextInt();
            sc.nextLine();

            String[] pilotsArray = new String[arrayLength];

            System.out.println("Indica el nom dels pilots separats per espai, exemple -> (Hamilton Bottas Verstappen): ");
            String pilotNames = sc.nextLine();
            pilotsArray = pilotNames.split(" ");

            System.out.println("Ara, indica les posicions que ha perdut cada pilot separades amb espai, exemple -> (2 1 0)");
            String lostPositionsString = sc.nextLine();

            
        }
    }
}
