package exercicis;

import java.util.Scanner;

public class Exercici7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Inserta un número més gran o igual a 0:");
		int num = sc.nextInt();
		sc.close();
		if (num<0) 
			System.out.println("HAS INSERTAT UN NÚMERO NEGATIU. REINICIA");
		int fact = 1;
		
		for(int i=num; i>0; i--) {
			 fact*=i;
		}
		
		System.out.println(fact);
	
	}

}
