package exercicis;

import java.util.Scanner;

class Options{
	
	public static void option1(int drawingNum) {
		for(int i=0; i<drawingNum; i++) {
			System.out.println("");
			for(int n=0; n<drawingNum; n++) {
				System.out.print("*");
			}
		}
	}
	
	public static void option2(int drawingNum) {
		int n = 1;
		for(int i=0; i<drawingNum; i++) {
			System.out.println("");
			for(int o = 0; o<n; o++) {
				System.out.print("*");
			}
			n++;
		}	
	}
	
	public static void option3(int drawingNum) {
		int jmp = 10;
		int b = 10;
		int n = 1;
		int i;
		for(i=0; i<drawingNum; i++) {
			System.out.println("");
			for(int o = 0; o<n; o++) {
				while(jmp>0){
					System.out.print(" ");
					jmp--;
				}
				System.out.print("*");
			}
			
			n++;
			b-=2;
			jmp=b;
		}
	}
	
	public static void option4(int drawingNum) {
		int jmp = 10;
		int b = 10;
		int n = 1;
		int i;
		for(i=0; i<drawingNum; i++) {
			System.out.println("");
			for(int o = 0; o<n; o++) {
				while(jmp>0){
					System.out.print(" ");
					jmp--;
				}
				System.out.print("*");
			}
			
			n+=2;
			b--;
			jmp=b;
		}
	}
	
	public static void option5(int drawingNum) {
		int jmp = 10;
		int b = 10;
		int n = 1;
		int i;
		for(i=0; i<drawingNum; i++) {
			System.out.println("");
			for(int o = 0; o<n; o++) {
				while(jmp>0){
					System.out.print(" ");
					jmp--;
				}
				System.out.print(i+1);
			}
			n+=2;
			b--;
			jmp=b;
		}
	}
	
	public static void option6(int drawingNum) {
		int jmp = 10;
		int b = 10;
		int n = 1;
		int i;
		for(i=0; i<drawingNum; i++) {
			System.out.println("");
			for(int o = 0; o<jmp; o++) {
				while(jmp>0){
					System.out.print(" ");
					jmp--;
				}
			}
	        for (int m = i+1; m > 0; m--) {
	            System.out.print(m);
	        }
	        for (int p = 2; p < i+1; p++) {
	            System.out.print(p);
	        }
			n+=2;
			b--;
			jmp=b;
		}
	}
	
}

public class Exercici13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int drawingNum = -1;
		while(drawingNum>6 || drawingNum<0) {
			System.out.println("Inserta un número de (l'1 al 6).");
			drawingNum = sc.nextInt();
		}
		System.out.println("Elegeix una opció per mostrar el dibuix (de 1 a 6): ");	
		int option = sc.nextInt();
		
		switch(option) {
		case 1:
			Options.option1(drawingNum);
			break;
		case 2:
			Options.option2(drawingNum);
			break;	
		case 3: 
			Options.option3(drawingNum);
			break;
		case 4:
			Options.option4(drawingNum);
			break;
		case 5:
			Options.option5(drawingNum);
			break;
		case 6:
			Options.option6(drawingNum);
			break;
		default:
			System.out.println("Has introduït un valor incorrecte. \nREINICIA L'EXERCICI.");
		}

		sc.close();
		
	}
}

