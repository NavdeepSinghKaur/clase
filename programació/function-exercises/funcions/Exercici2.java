package funcions;

import java.util.Scanner;

public class Exercici2 {
    
    public static String pythagorasTheorem(int c1, int c2, int h) {
        if(Math.pow(c1, 2) + Math.pow(c2, 2) == Math.pow(h, 2)) {
            return "Es compleix el teorema de pitàgores";
        } else {
            return "No es compleix el teorema de pitàgores";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c1;
        int c2;
        int h;

        System.out.println("Inserta un número: ");
        c1 = sc.nextInt();

        System.out.println("Inserta un altre número: ");
        c2 = sc.nextInt();

        System.out.println("Inserta un altre altre número: ");
        h = sc.nextInt();

        System.out.println(pythagorasTheorem(c1, c2, h));
        
        sc.close();
    }
}
