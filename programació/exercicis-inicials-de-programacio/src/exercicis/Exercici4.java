package exercicis;

import java.util.Scanner;

public class Exercici4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"blau", "verd", "vermell", "opció incorrecta"};
		
		Scanner sc = new Scanner(System.in);
		short nums = sc.nextShort();
		sc.close();
		
		if (nums >= 0 && nums <= 10 ) { System.out.println(words[0]); }
		else if (nums >= 11 && nums <= 20) { System.out.println(words[1]); }
		else if (nums >= 21 && nums <= 30) { System.out.println(words[2]); }
		else { System.out.println(words[3]); }	
	}
}
