package exercicis;

import java.util.Scanner;


public class Exercici8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Inserta el radi del cercle: ");
		double rad = sc.nextDouble();
		sc.close();
		
		System.out.println("Àrea del cercle: " + (Math.PI*Math.pow(rad, 2)));
		System.out.println("Perímetre del cercle: " + (2*Math.PI*rad));
		
	}

}
