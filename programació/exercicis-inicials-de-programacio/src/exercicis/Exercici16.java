package exercicis;

import java.util.Scanner;

public class Exercici16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		double sum = 0;
		Double[] nums = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		
		for (int i=0; i<nums.length; i++) {
			nums[i] = sc.nextDouble();
			if (nums[i]%2 == 0) System.out.println(sum+=nums[i]);
		}
		
		sc.close();
		System.out.println("Suma de números parells: " + sum);
	}

}
