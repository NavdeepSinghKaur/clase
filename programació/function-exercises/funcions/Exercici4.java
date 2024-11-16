package funcions;

import java.util.Scanner;

public class Exercici4 {

    public static void menu() {
        System.out.println("~~~~ MEN Ú ~~~~\n" + //
                        "0. Sortir\n" + //
                        "1. Calcular el factorial d'un nombre enter positiu\n" + //
                        "2. Calcular la sèrie numèrica [ 1 - X ^2/2!+ X ^4/4! -...]");
    }
    public static String series(int num) {
        double ans = 1;
        int iteration = 0;
        boolean positive = false; 
        int power = 2;
        double uselessVal = 1e-15;
        double operation;

        while (iteration <= 150) {
            operation = Math.pow(num, power) / factorial(power);

            if (operation < uselessVal) {
                iteration = 151;
            }

            if (positive) {
                ans += operation;
                positive = false;
            } else {
                ans -= operation;
                positive = true;
            }
            
            power += 2;
            iteration += 1;
        }
        return "Valor en radians: " + ans;
    }

    public static double factorial(int n) {
        double a = 1.0;
        for (int i = 2; i <= n; i++) {
            a *= i;
        }
        return a;
    }

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option = -1;
        int num;
        while(option != 0) {
            menu();
            option = sc.nextInt();
            
            switch(option) {
                case 0:
                    System.out.println("Tancant el programa");
                    sc.close();
                    break;

                case 1: 
                    System.out.println("Inserta un número: ");
                    num = sc.nextInt();
                    while (num < 0) {
                        System.out.println("ERROR: El número introduït ha de ser un número positiu major de 0.\nInserta un altr número: ");
                        num = sc.nextInt();
                    }
                    System.out.println(factorial(num));
                    break;

                case 2:
                    System.out.println("Inserta un número: ");
                    num = sc.nextInt();
                    System.out.println(series(num));
                    break;

                default:
                    System.out.println("Opció incorrecta\nTorna a intentar-ho.");
            }
        }

    }  
}
