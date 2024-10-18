package exercicis;

import java.util.Scanner;

public class Exercici3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Inserta un número");
		byte num = sc.nextByte();
		sc.close();
		
		if (num==5 || num==6) { System.out.println("El número introduït és un 5 o 6."); }
		else {System.out.println("El número introduït NO és un 5 o 6."); }
	}

}
