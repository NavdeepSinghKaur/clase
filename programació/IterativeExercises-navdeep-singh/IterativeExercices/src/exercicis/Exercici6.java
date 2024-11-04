package exercicis;

import java.util.Scanner;

class Calculator{
	static int sum = 0;
	
	static int SumNums(int num1, int num2) {
		if ((num1<0 && num2<0) || (num1>0 && num2>0)) {
			for(int i=0; i<Math.abs(num1); i++) {
				sum += Math.abs(num2);	
			}
			return sum;
		}
		else if (num1<0 || num2<0) {
			for(int i=0; i<Math.abs(num1); i++) {
				sum -= num2;	
			}
			return sum;
		}
		else {
			return 0;
		}
	}
}

public class Exercici6 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		sc.close();
		System.out.println(Calculator.SumNums(num1, num2));
	}

}
