package exercicis;

import java.util.Scanner;
import java.util.Random;

public class Exercici5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
		int randNum = rand.nextInt(100);
		boolean numFound = false; 
		int inputNum;

		System.out.println("Adivina el número random entre 0 i 100.");
		int i=20;
		while (i>0 && !(numFound)) {
			System.out.println("Et queden " + i + " intents.");
			inputNum = sc.nextInt();
			if (inputNum == randNum) {
				System.out.println("Felicitats, has trobat el número.");
				numFound = true;
			}
			i--;
		}
		sc.close();
		
		if (!numFound) System.out.println("Intents esgotats, le nombre que calia encertar era el " + randNum);
	}
}
