import java.util.Scanner;

public class Exercise2HardMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean exitMenu = false;
        boolean unlockAllOptions = false;
        float squareDimensions = 0;
        while (!exitMenu) {
            System.out.println("""
                    ~~~~ MEN Ú ~~~~
                    0. Sortir
                    1. Quadrat
                    2. Perímetre
                    3. Àrea
                    
                    Entrada:
                    """);
            int option = sc.nextInt();

            switch (option) {
                case 0:
                    System.out.println("Tancant el programa...");
                    sc.close();
                    exitMenu = true;
                    break;
                case 1:
                    System.out.println("Introdueix la mida del costat del quadrat: ");
                    squareDimensions = sc.nextFloat();
                    System.out.println("OK.");
                    unlockAllOptions = true;
                    break;
                case 2:
                    if (!unlockAllOptions) {
                        System.out.println("Has de primer, introduïr la mida del quadrat (opció 1).");
                    } else {
                        System.out.println("El perímetre del quadrat és: " + perimeter(squareDimensions));
                    }
                    break;
                case 3:
                    if (!unlockAllOptions) {
                        System.out.println("Has de primer, introduïr la mida del quadrat (opció 1).");
                    } else {
                        System.out.println("L'àrea del quadrat és: " + area(squareDimensions));
                    }
                    break;
                default:
                    System.out.println("Has introduït una opció invàlida. Torna a intentar-ho.");
            }
        }
    }
    public static float perimeter(float value) {
        return value*4;
    }
    public static float area(float value) {
        return value*value;
    }
}
