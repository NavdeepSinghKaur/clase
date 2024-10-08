import java.util.Scanner;
 
public class Activitat_1_1 { 
	
    public static void main(String[] args)
    {       
		
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nEntra el nom : ");
        String nom = scanner.nextLine();

        System.out.println("\nEntra la edat : "); 
        int edat = scanner.nextInt();

        final int anyNaixement = 2024 - edat;

		String showEdat = (edat < 18) ? ("\n l'alumne/a " + nom + " es MENOR d'edat. Va neixer el " + anyNaixement) : ("\n l'alumne/a " + nom + " es MAJOR d'edat Va neixer el " + anyNaixement);
        scanner.close(); // tanquem la captura del teclat        
		
		System.out.println(showEdat);
		
    }
  
}

