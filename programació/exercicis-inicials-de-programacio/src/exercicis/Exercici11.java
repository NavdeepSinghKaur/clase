package exercicis;

import java.util.Scanner;

public class Exercici11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Inserta un número: ");
		int num = sc.nextInt();
		System.out.println("Números parells de " + num + ":");
		for (int i=0; i<=num; i++){
			if(i%2==0)
				System.out.println(i);
		}
		sc.close();
	}
}
