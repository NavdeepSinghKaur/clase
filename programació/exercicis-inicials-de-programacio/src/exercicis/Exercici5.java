package exercicis;

import java.util.Scanner;

public class Exercici5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.println("Introdueix la teva edat: ");
		int age = sc.nextInt();
		
		System.out.println("Introdueix el teu nom: ");		
		String name = sc.next();
		sc.close();
	
		if (0 <= age && age <= 1) System.out.println("Hola " + name + " ets un nadó");
		else if (2 <= age && age <= 5) System.out.println("Hola " + name + " ets un infant");
		else if (6 <= age && age <= 12) System.out.println("Hola " + name + " ets un nen");
		else if (13 <= age && age <= 17) System.out.println("Hola " + name + " ets un adolescent");
		else if (18 <= age && age <= 75) System.out.println("Hola " + name + " ets un adult");
		else if (age > 75) System.out.println("Hola " + name + " ets un avi");
		else System.out.println("La teva edat no és válida.");
	}
}