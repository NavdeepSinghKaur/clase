package funcions;

import java.util.Scanner;

public class Exercici7 {

    public static String ckeckArmstrong(int num) {
        String inputNum = Integer.toString(num);
        int armstrongSum = 0;
        for(int i=0; i<inputNum.length(); i++) {
            armstrongSum += Math.pow((int)(inputNum.charAt(i) - '0'), 3);
        }
        if(armstrongSum == num) {
            return "El número que has introduït: " + num + " és un número Armstrong.";
        }
        else 
            return "El número que has introduït: " + num + " NO és un número Armstrong.";

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputNum = -1;
        System.out.println("Inserta un número positiu: ");
        inputNum = sc.nextInt();

        if(inputNum >= 0) 
            System.out.println(ckeckArmstrong(inputNum));
        else 
            System.out.println("ERROR: El número introduït ha de ser un número positiu.");
        
        sc.close();
    }
}