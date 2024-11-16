package funcions;

import java.util.Scanner;

public class Exercici5 {
    private static String text = "";

    public static void initialMenu() {
        System.out.println("~~~~ MEN Ú ~~~~\n" +
                        "0. Sortir\n" + 
                        "1. Introduir una cadena de car à cters\n" + 
                        "2. Comptar maj ú scules\n" + 
                        "3. Comptar min ú scules\n" + 
                        "OPCIÓ: \n");
    }

    public static String option1(String inputText) {
        text = inputText;
        return text;
    }

    public static int option2() {
        int upperCount = 0;
        for(int i=0; i<text.length(); i++) {
            for(int j=60; j<91; j++) {
                if((int)text.charAt(i) == j) {
                    upperCount++;
                }
            }
        } 
        return upperCount; 
    }

    public static int option3() {
        int lowerCount = 0;
        for(int i=0; i<text.length(); i++) {
            for(int j=97; j<123; j++) {
                if((int)text.charAt(i) == j) {
                    lowerCount++;
                }
            }
        }
        return lowerCount;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int option = 1;
        String inputString = null;

        
        while (option != 0) {
            initialMenu();
            option = sc.nextInt();
            sc.nextLine();
            if(option >= 4 || option < 0) {
                System.out.println("Opció incorrecta\nTorna a intentar-ho.");
            }    
            else if (option == 1) {
                System.out.println("Inserta una cadena de caràcters: ");
                inputString = sc.nextLine();
                System.out.println("S'ha guardat el text: " + option1(inputString));
            }
            else if (option == 2 && inputString != null) {
                System.out.println("El número de majúscules es: " + option2());
            }
            else if (option == 3 && inputString != null) {
                System.out.println("El número de minúscules es: " + option3());
            }
            else if (option == 0 && inputString != null) {
                System.out.println("Tancant el programa");
                sc.close();
            }
            if (inputString == null) {
                System.out.println("ERROR: Has de introduïr primer el text (opció 1).");
            }
        }
    }
}
