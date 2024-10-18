package exercicis;

import java.util.Scanner;

public class Exercici13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long[] nums = {0, 0, 0};
		long n;

		Scanner sc = new Scanner(System.in);
		try {
		for(int i=0; i<nums.length; i++) {
			System.out.println("Inserta un número (" + (i+1) + " de 3):");
			nums[i] = sc.nextLong();
		}
		}
		catch (Exception e){
			System.out.println("Has introduït un caràcter que no s'ha pogut processar. Torna a començar.");
		}
		finally {
			sc.close();
		}
		for (int i=0; i<nums.length; i++) {
			for (int j=0; j<nums.length-1; j++) {
				if (nums[j]>nums[j+1]) {
					n=nums[j];
					nums[j]=nums[j+1];
					nums[j+1]=n;
				}
			}
		}
		for(long i: nums) {
			System.out.println(i);
		}
	}

}
