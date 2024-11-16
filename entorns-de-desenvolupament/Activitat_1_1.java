
/*
 * Exemple de classe 
 * MP05 - Entorns de desenvolupament
 * UF1 A1 - Activitat 4
 */  // <- COMENTARI

// importem les llibreries  <- COMENTARI
import java.util.Scanner;
 
public class Activitat_1_1 { 
	
    // constants
    static final int ANY_ACTUAL = 2023;   // CONSTANT

    // funció principal <- COMENTARI
    public static void main(String args[])
    {       
        // definició de variables <- COMENTARI I VARIABLES (LES 3 SEGUENTS)
        String nom;
        int edat; 
        int anyNaixement;

        // objecte scanner per capturar el teclat <- COMENTARI
        Scanner scanner = new Scanner(System.in); 
        
        // crida a sistema, escriure al terminal
        System.out.println("\nEntra el nom : ");
        nom = scanner.nextLine();  // assignem valor a la variable nom

        System.out.println("\nEntra la edat : "); // sortida a terminal <- COMENTARI
        edat = scanner.nextInt(); // assignem valor a la variable nom

        anyNaixement = ANY_ACTUAL - edat; // operació matemàtica <- COMENTARI

        // estructura de control condicional <- COMENTARI
        if (edat < 18){  // ESTRUCTURA DE CONTROL
            System.out.println("\n l'alumne/a " + nom + " es MENOR d'edat. Va neixer el " + anyNaixement);
        } else {
            System.out.println("\n l'alumne/a " + nom + " es MAJOR d'edat Va neixer el " + anyNaixement);
        }       

        scanner.close(); // tanquem la captura del teclat  <- COMENTARI   
    }
  
}

