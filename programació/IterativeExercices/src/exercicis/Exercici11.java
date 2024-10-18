package exercicis;

import java.util.Scanner;

public class Exercici11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num1 = -1;
		int num2 = -1;
		int selectedNum;
		
		while (num1<0 && num2<0) {
			System.out.println("Inserta dos números enters positius (després de cada número pulsa la tecla enter): ");
			num1 = sc.nextInt();
			num2 = sc.nextInt();
		}
		sc.close();
		
		if (num2<num1)
			selectedNum = num2;
		else
			selectedNum = num1;
		
		while(num1%selectedNum!=0 || num2%selectedNum!=0) {
			selectedNum--;
		}
		
		System.out.println(selectedNum);
	}
}
