package funcions;

import java.util.Scanner;

public class Exercici8 {

    public static void menu() {
        System.out.println("Introdueix una cadena que només contingui les lletres L i R, exemple: LR.");
        System.out.println("Cadena: ");
    }

    public static boolean checkLR(String text) {
        boolean invalidInput = false;
        for(int i=0; i<text.length(); i++) {
            if( (int)text.charAt(i) != 76 && (int)text.charAt(i) != 82) {
                invalidInput = true;
            }
        }
        return invalidInput;
    }

    public static void algorithm(String text, int iterations) {
        String result = "";
        System.out.println("Cadena inicial: " + text);
        System.out.println("iteracions: " + iterations);

        for(int i=0; i<iterations; i++) {
            for (int j=0; j<text.length(); j++) {
                if(text.charAt(j) == 'L') {
                    result += "LRL";
                }
                else {
                    result += "RRL";
                }
            }
            System.out.println(i+1 + "a iteració: " + result);
            text = result;
            result = "";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        menu();
        String text = sc.nextLine().toUpperCase();
        boolean checkLROutput = checkLR(text);
        while (checkLROutput) {
            System.out.println("Error, la cadena introduida no es correcta. Has de introduïr els caràcters I o R.");
            menu();
            text = sc.nextLine().toUpperCase();
            checkLROutput = checkLR(text);
        }
        System.out.println("Inserta el número de iteracions");
        int iterations = sc.nextInt();
        while(iterations <= 0) {
            System.out.println("ERROR: El número introduït ha de ser un número positiu major de 0.");
            iterations = sc.nextInt();
        }
        algorithm(text, iterations);
        sc.close();
    } 
    
}