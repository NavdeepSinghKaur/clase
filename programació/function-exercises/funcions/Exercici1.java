package funcions;

import java.util.Scanner;

public class Exercici1 {

    public static int multiplyNums(int num1, int num2) {
        return num1*num2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = 0;
        int b = 0;

        System.out.println("Inserta un número: ");
        a = sc.nextInt();
        System.out.println("Inserta un altre número: ");
        b = sc.nextInt();

        System.out.println("La multiplicació és: " + multiplyNums(a, b));

        sc.close();
    }
}
