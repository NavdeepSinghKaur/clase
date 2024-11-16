package funcions;

import java.util.Scanner;

public class Exercici3 {
    public static String dniCalculator(int dni) {
        String[] dniStrings = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};
        return dniStrings[dni%23];
    }

    public static void menu() {
        System.out.println("0. Sortir");
        System.out.println("1. Calcular lletra del DNI");
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int dni;
        int option;
        menu();
        option = sc.nextInt();
        while (option != 0) {
            if(option != 1 && option != 0){
                System.out.println("Opció incorrecta\nTorna a intentar-ho.");
                menu();
                option = sc.nextInt();
            }
            if(option == 1){
                System.out.println("Inserta un DNI: ");
                dni = sc.nextInt();
                System.out.println(dniCalculator(dni));          
            }
            menu();
            option = sc.nextInt();  
        }
        sc.close();   
    }
    
}
