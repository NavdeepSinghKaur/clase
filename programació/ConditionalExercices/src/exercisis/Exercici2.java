package exercisis;

import java.util.Scanner;

public class Exercici2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Inserta un número");
		byte num = sc.nextByte();
		
		if (num==5 || num==6) { System.out.println("El número introduït és un 5 o 6."); }
		else {System.out.println("El número introduït NO és un 5 o 6."); }
	}

}
