package exercicis;

import java.util.Scanner;

class Operation {
	static int Conversor(int num) {
		int sum = 0;
		int singleNum;
		String numToStr = Integer.toString(Math.abs(num));
		
		for (int i=numToStr.length()-1; i>=0; i--) {
			singleNum = Character.getNumericValue(numToStr.charAt(i));
			sum += singleNum*Math.pow(8, (numToStr.length()-1)-i);
		}
		
		if (num<0) return -sum;
		else return sum;
	}
}

public class Exercici12 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Inserta un número octal: ");

		int num = sc.nextInt();
		sc.close();
		
		System.out.println(Operation.Conversor(num));
	}
}
