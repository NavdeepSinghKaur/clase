package exercicis;

import java.util.Scanner;

class Options {
	private static String str1 = "";
	
	public static String option1(String input) {
		str1 = input;
		return str1;
	}

	public static int option2() {
		return str1.length();
	}
	
	public static int option3() {
		String[] lengthOfSentece = str1.split("\\s+");
		return lengthOfSentece.length;
	}
	
	public static String option4(String word) {
		if(str1.contains(word)) 
			return "La cadena, revisada en case-sensitive, está en la posició: " + str1.indexOf(word);
		else 
			return "La cadena, revisada en case-sensitive, no conté la subcadena: " + word;
	}
	
	public static int option5(String word) {
        String[] str1SplitWords = str1.split("\\s+");
        int i = 0;
        for(String n:str1SplitWords){
            if(word.equalsIgnoreCase(n)){
                i++;
            }
        }
        return i;
	}
	
	public static String option6(String str2) {
		if(str1.compareToIgnoreCase(str2)==0)
			return "Les cadenes són iguals.";
		else if(str2.length()<str1.length())
			return "És més petita la cadena: " + str2;
		else 
			return "És més petita la cadena: " + str1;
	}
	
	public static String option7() {
		String reversedStr = "";
		for(int i=str1.length()-1; i>=0; i--) {
			reversedStr += str1.charAt(i);
		}
		return reversedStr;

		// return new StringBuilder(str1).reverse().toString();
	}
	
	public static String option8(int position) {
        try {
    		int str1ToAscii = (int)str1.charAt(position);
            return "Caràcter ASCII: " + (char)str1ToAscii;
        } 
        catch (Exception e) {
            return "Torna a reiniciar l'exercici. La entrada no és válida. \nL'input ha de ser igual o menor a: " + (str1.length()-1);
        }
	}
	
	public static String option9(int position) {
        try {
            return "Caràcter: " + str1.charAt(position);
        } 
        catch (Exception e) {
            return "Torna a reiniciar l'exercici. La entrada no és válida. \nL'input ha de ser igual o menor a: " + (str1.length()-1);
        }
	}
	
	public static String option10(String word) {
		if(str1.contains(word)) 
			return "La cadena, revisada en case-sensitive, está en la posició: " + str1.indexOf(word);
		else 
			return "La cadena, revisada en case-sensitive, no conté la subcadena: " + word;
	}
	
	public static String option11(String word) {
		if(str1.toLowerCase().lastIndexOf(word.toLowerCase()) != 1) 
			return "La cadena, revisada en NON case-sensitive, está en la posició: " + str1.lastIndexOf(word);
		else 
			return "La cadena, revisada en NON case-sensitive, no conté la subcadena: " + word;
	}	
	
	public static String option12(String newChar, String oldChar) {
		String oldStr = str1;
		String replacedStr = str1.replace(oldChar, newChar);
		if (oldStr.equals(replacedStr))
			return "La cadena no s'ha canviat.";
		else
			str1 = replacedStr;
		return "Nova cadena: " + str1;
		
	}
	
	public static String option13(String substr) {
		if(str1.startsWith(substr))
			return "La cadena SI comença amb la cadena introduïda.";
		else
			return "La cadema NO comença amb la cadena introduïda.";
	}
	
	public static String option14(String substr) {
		if(str1.toLowerCase().endsWith(substr.toLowerCase()))
			return "La cadena SI acaba amb la cadena introduïda (NO case-sensitivs).";
		else
			return "La cadena NO acaba amb la cadena introduïda (NO case-sensitivs).";
	}
	
	
	public static String option15(int x, int y) {
		try {
			return str1.substring(x, y);
		}
		catch (Exception e) {
			return "Torna a intentar-ho. Els valors introduïts són erronis.";
		}
	}
	
	public static void message() {
		System.out.println("Inserta primer un text en l'opció 1.");
	}
	
	public static void allOptions() {
		System.out.println("~~~~ MENÚ ~~~~\n"
				+ "0. Sortir\n"
				+ "1. Introduir una cadena de caràcters ( String )\n"
				+ "2. Indicar la longitud de la cadena de caràcters\n"
				+ "3. Comptar paraules\n"
				+ "4. Buscar una paraula ( case - sensitive )\n"
				+ "5. Comptar les vegades que apareix una paraula ( non case - sensitive )\n"
				+ "6. Comparar cadenes ( non case - sensitive )\n"
				+ "7. Capgirar la cadena de caràcters\n"
				+ "8. Mostrar el codi ASCII del caràcter situat a la posició x\n"
				+ "9. Mostrar el caràcter situat a la posició x\n"
				+ "10. Mostrar la posició on apareix , per primer cop , una paraula\n"
				+ "( case - sensitive )\n"
				+ "11. Mostrar la posició on apareix , per darrer cop , una paraula\n"
				+ "( non case - sensitive )\n"
				+ "12. Substituir una paraula\n"
				+ "13. Comprovar si la cadena comença per un conjunt de caràcters\n"
				+ "( case - sensitive )\n"
				+ "14. Comprovar si la cadena acaba amb un conjunt de caràcters\n"
				+ "( non case - sensitive )\n"
				+ "15. Obtenir una subcadena");
	}
}

public class Exercici1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean strNotVoid = false;
		boolean isOut = false;
		Scanner sc = new Scanner(System.in);
		byte choice = 0;
        
        while(!isOut) {
			Options.allOptions();
			try {
				choice = sc.nextByte();
			}
			catch (Exception e) {
				System.out.println("Hi ha hagut un error, torna a intentar-ho de nou"); 
			}
			sc.nextLine();

			if (choice==0) isOut = true;
			else if(choice==1) {
				strNotVoid = true;
				System.out.println("Introdueix la cadena de text: ");
				String text1 = sc.nextLine();
				System.out.println("S'ha introduït el text: " + Options.option1(text1));
			}
			else if(choice==2 && strNotVoid) {
				System.out.println("La longitud de la cadena és: " + Options.option2());
			}
			else if(choice==3 && strNotVoid ) {
				System.out.println("La cadena té el següent número de paraules: " + Options.option3());
			}
			else if(choice==4 && strNotVoid) {
				System.out.println("Indica la paraula a buscar: ");
				System.out.println(Options.option4(sc.nextLine()));
			}
			else if(choice==5 && strNotVoid ) {
				System.out.println("Indica la paraula: ");
				System.out.println("La paraula apareix: " + Options.option5(sc.nextLine()) + " vegades.");
			}
			else if(choice==6 && strNotVoid) {
				System.out.println("Introdueix la cadena a comparar: ");
				System.out.println(Options.option6(sc.nextLine()));
			}
			else if(choice==7 && strNotVoid ) {
				System.out.println(Options.option7());
			}
			else if(choice==8 && strNotVoid) {
				System.out.println("Indica la posició per mostrar el carácter ASCII: ");
				System.out.println(Options.option8(sc.nextInt()));
			}
			else if(choice==9 && strNotVoid ) {
				System.out.println("Indica la posició per mostrar el carácter: ");
				System.out.println(Options.option9(sc.nextInt()));
			}
			else if(choice==10 && strNotVoid ) {
				System.out.println("Indica la paraula: ");
				System.out.println(Options.option10(sc.nextLine()));
			}
			else if(choice==11 && strNotVoid ) {
				System.out.println("Indica la paraula: ");
				System.out.println(Options.option11(sc.nextLine()));
			}
			else if(choice==12 && strNotVoid ) {
				System.out.println("Introdueix la paraula que ha de ser substituida: ");
				String val1 = sc.nextLine();
				System.out.println("Introdueix la nova paraula: ");
				String val2 = sc.nextLine();
			    System.out.println(Options.option12(val1, val2));
			}
			else if(choice==13 && strNotVoid ) {
				System.out.println("Introdueix la paraula: ");
				System.out.println(Options.option13(sc.nextLine()));
			}
			else if(choice==14 && strNotVoid) {
				System.out.println("Introdueix la paraula: ");
				System.out.println(Options.option14(sc.nextLine()));
			}
			else if(choice==15 && strNotVoid) {
				System.out.println("Indica la posició inicial: ");
				int x = sc.nextInt();
				System.out.println("Indica la posició final: ");
				int y = sc.nextInt();
				System.out.println(Options.option15(x, y));
			}
			else  {
				if(choice>15 || choice<0) System.out.println("ERROR: HAS DE ELEGIR UNA OPCIÓ VÁLIDA");
				if (!strNotVoid && (choice<=15 && choice>=0)) System.out.println("ERROR: HAS DE ELEGIR PRIMER LA OPCIÓ 1");
			}
			
        }
		sc.close();
    }
}