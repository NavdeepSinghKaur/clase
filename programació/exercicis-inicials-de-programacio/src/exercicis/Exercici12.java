package exercicis;

import java.util.Scanner;

public class Exercici12 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double n = 0;
		double[] nums = {0, 0, 0, 0, 0};
		for (int i=0; i<5; i++) {
			nums[i] = sc.nextDouble();
			n += nums[i];
		}
		sc.close();
		System.out.println("Mitjana dels números: " + n);
		n = nums[0];
		for (int i=0; i<4; i++) {
			if (nums[i+1] < n) n = nums[i+1];
		}
		System.out.println("Número més petit: " + n);
		
		n=nums[0];
		for (int i=0; i<4; i++) {
			if (nums[i+1] > n) n = nums[i+1];
		}
		System.out.println("Número més gran: " + n);

	}	
}
