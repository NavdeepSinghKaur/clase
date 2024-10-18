package exercicis;

import java.util.Scanner;

public class Exercici1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double[] nums = {0, 0};
		for (int i=0; i<2; i++) {
			System.out.println("Inserta un número (" + (i+1) + " de 2)");
			nums[i] = sc.nextDouble();
		}
		sc.close();
		System.out.println("Resultat: " + nums[0]*nums[1]);
	}
}
