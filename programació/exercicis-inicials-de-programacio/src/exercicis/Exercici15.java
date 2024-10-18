package exercicis;

import java.util.Scanner;

public class Exercici15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		double n = 0;
		double sum = 0;
		
		while (n >= 0) {
			System.out.println("Inserta un número: ");
			n = sc.nextDouble();
			if (n >= 0) sum +=n;
		}
		
		sc.close();
		System.out.println("Suma dels números: " + sum);
	}
}
