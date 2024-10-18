package exercisis;

import java.util.Scanner;

public class Exercici5 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Introdueix el non del producte: ");
		String name = sc.next();
		System.out.println("Introdueix el preu del producte: ");
		float price = sc.nextFloat();
		
		System.out.println("Escriu ->1<- si el producte és de luxe, qualsevol altre número si és básic");
		byte luxury = sc.nextByte();
		sc.close();
		
		if (luxury == 1) price += price*0.21;
		else price += price*0.04;
		
		System.out.println("Preu de " + name + " " + price);
	}

}
