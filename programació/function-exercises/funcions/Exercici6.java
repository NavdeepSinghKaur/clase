package funcions;

import java.util.Scanner;

public class Exercici6 {
    public static void anagramCheck(String word1, String word2) {
        if(word1.length() != word2.length()) {
            System.out.println("No son anagrames.");
        }
        else {
            int isEqual = 0;
            String[] anagramsArr = word2.split("");
            for(int i=0; i<anagramsArr.length; i++) {
                if(word1.contains(anagramsArr[i])) {
                    isEqual++;
                }
            }
            if(isEqual == anagramsArr.length) {
                System.out.println("Son anagrames.");
            }
            else {
                System.out.println("No son anagrames.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserta la primera cadena: ");
        String word1 = sc.nextLine();
        System.out.println("Inserta la segona cadena: ");
        String word2 = sc.nextLine();
        anagramCheck(word1, word2);
        sc.close();
    }
    
}