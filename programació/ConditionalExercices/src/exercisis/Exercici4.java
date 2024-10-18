package exercisis;

import java.util.Scanner;

public class Exercici4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Escriu l'alçada del rectangle");
		float height = sc.nextFloat();
		System.out.println("Escriu la base del rectangle");
		float width = sc.nextFloat();
		sc.close();
		
		System.out.println("Àrea del rectangle: " + height*width);
		System.out.println("Perímetre del rectangle: " + (height+width)*2);
		
		if (height==width) 
			System.out.println("La figura és un quadrat");
	}

}
