package exercicis;

import java.util.Scanner;

class Options {
	private String text = "";
	
	public String writeText(String input) {
		text = input;
		return text;
	}

	public int countWords() {
		return 0;
	}
	
	public int getLength() {
		return text.length();
	}
	
	public String findWords() {
		return "";
	}
	
	
}

public class Exercici1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		byte choice;
		
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
		 choice = sc.nextByte();
		 sc.close();
		 
		 switch(choice) {
		 	case 0:
		 		break;
		 	case 4:
		 		Options.getLength();
		 	default:
		 		System.out.println("Has elegit una opció que no es troba aquí, torna a exercutar el programa.");
		 }
	}

}
