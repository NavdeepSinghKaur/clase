package exercicis;

import java.util.Scanner;

public class Exercici9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int inputNum;
		int positives=0;
		int negatives=0;
		int zeros=0;
		boolean addNums = true;
		
		while (addNums==true) {
			System.out.println("Inserta el número:");
			inputNum = sc.nextInt();
			
			if (inputNum>0) {
				positives++;
			}else if (inputNum==0) {
				zeros++;
			}else {
				negatives++;
			}
			
			System.out.println("Vols insertar un número més?");
			
			if(sc.next().equals("no")) {
				addNums=false;
			}
		}
		sc.close();
		
		System.out.println("numeros positius: " + positives + " Negatius: " + negatives
				+ " zeros: " + zeros);
	}

}
