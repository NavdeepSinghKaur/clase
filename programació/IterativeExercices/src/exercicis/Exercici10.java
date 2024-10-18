package exercicis;

import java.util.Scanner;

public class Exercici10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Introdueix el valor de les iteracions que vols de la sucessió de fibonacci: ");
		int value = sc.nextInt();
		sc.close();
		if (value<0) {
			System.out.println("El valor és negatiu, es farán les iteracions amb el valor absolute del valor introduït.");
			value = Math.abs(value);
		}
		int a = 0;
		int b = 1;
		int c = 0;
		
		for(int i=0; i<value; i++) {
			System.out.println(a);
			c=a;
			a+=b;
			b=c;
		}
	}

}
