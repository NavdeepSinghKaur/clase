package exercicis;

import java.util.Scanner;

class NumShuffler {
	
	static int Processor(int num) {
		
		if (num<0) 
			return 0;
		
		return 0;
	}
}

public class Exercici8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		String[] splitNums = Integer.toString(num).split("");
		String nums2 = Integer.toString(num);
		
		System.out.println(nums2.split(""));
	}

}
