import java.util.Scanner;

public class CompanyMain {

    public static String workerType() {
        return "TIPUS D'INFORMATIC:\n0. Programador\n1. Dissenyador gràfic\nEntrada:";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Programmer[] programmers = new Programmer[10];
        ComputerGraphicsExpert[] graphicsExperts = new ComputerGraphicsExpert[10];
        int entry;
        boolean endProgram = false;
        int workerType;

        while (!endProgram) {
            System.out.println("""
                    ---- Gestió de la compra ----
                    0. Sortir
                    1. Afegir un informàtic
                    2. Consultar un informàtic concret de l’empresa
                    3. Consultar, per cada informàtic, en quin projecte està treballant
                    
                    Entrada:
                    """);
            entry = sc.nextInt();
            sc.nextLine();

            switch (entry) {
                case 0:
                    System.out.println("OK");
                    endProgram = true;
                    sc.close();
                    break;
                case 1:
                    System.out.println(workerType());
                    workerType = sc.nextInt();
                    sc.nextLine();
                    int i=0;

                    if (workerType == 0) {
                        while (programmers[i] != null && i < programmers.length - 1) {
                            i++;
                        }
                        if(programmers[i] != null && i == programmers.length -1) {
                            System.out.println("ERROR: l’empresa ja té els 10 treballadors necessaris del tipus que es vol inserir.");
                        }
                        else {
                            System.out.println("Inserta les dades (nom, cognoms, edat, titol, any graduació, experiencia laboral, sou, llenguatge favorit, project manager (true/false), nom del projecte): ");
                            System.out.println("Separa insertant enter, exemple: nom (tecla enter), cognoms...");
                            String nom = sc.nextLine();
                            String cognoms = sc.nextLine();
                            int edat = sc.nextInt();
                            sc.nextLine();
                            String titol = sc.nextLine();
                            int anyGraduacio = sc.nextInt();
                            sc.nextLine();
                            int experienciaLaboral = sc.nextInt();
                            sc.nextLine();
                            double sou = sc.nextDouble();
                            sc.nextLine();
                            String favoriteLang = sc.nextLine();
                            boolean bProjectManager = sc.nextBoolean();
                            sc.nextLine();
                            String projectName = sc.nextLine();
                            programmers[i] = new Programmer(nom, cognoms, edat, titol, anyGraduacio, experienciaLaboral, sou, favoriteLang, bProjectManager, projectName);
                        }
                    }
                    else if (workerType == 1) {
                        while (graphicsExperts[i] != null && i < graphicsExperts.length - 1) {
                            i++;
                        }
                        if(graphicsExperts[i] != null && i == graphicsExperts.length -1) {
                            System.out.println("ERROR: l’empresa ja té els 10 treballadors necessaris del tipus que es vol inserir.");
                        } else {
                            System.out.println("Inserta les dades (nom, cognoms, edat, titol, any graduació, experiencia laboral, sou, game engine, plataforma del joc (0 - 1 - 2 - 3), ), utilitza cuda (true/false): ");
                            System.out.println("Separa insertant enter, exemple: nom (tecla enter), cognoms...");
                            String nom = sc.nextLine();
                            String cognoms = sc.nextLine();
                            int edat = sc.nextInt();
                            sc.nextLine();
                            String titol = sc.nextLine();
                            int anyGraduacio = sc.nextInt();
                            sc.nextLine();
                            int experienciaLaboral = sc.nextInt();
                            sc.nextLine();
                            double sou = sc.nextDouble();
                            sc.nextLine();
                            String gameEngine = sc.nextLine();
                            int platform = sc.nextInt();
                            sc.nextLine();
                            boolean usesCuda = sc.nextBoolean();
                            sc.nextLine();
                            graphicsExperts[i] = new ComputerGraphicsExpert(nom, cognoms, edat, titol, anyGraduacio, experienciaLaboral, sou, gameEngine, platform, usesCuda);
                        }
                    } else {
                        System.out.println("ERROR: TIPUS D'INFORMÀTIC NO VÀLID.");
                    }
                    break;
                case 2:
                    System.out.println(workerType());
                    workerType = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Indica la posició que ocupa a l'array: ");
                    int arrayPosition = sc.nextInt();
                    sc.nextLine();

                    if (workerType == 0) {
                        System.out.println(programmers[arrayPosition]);
                    }

                    if (workerType == 1) {
                        System.out.println(graphicsExperts[arrayPosition]);
                    }
                    break;
                case 3:
                    for (Programmer programmer : programmers){
                        if (programmer != null)
                            System.out.println(programmer.onGoingWork());
                    }
                    for (ComputerGraphicsExpert computerGraphicsExpert : graphicsExperts) {
                        if (computerGraphicsExpert != null) {
                            System.out.println(computerGraphicsExpert.onGoingWork());
                        }
                    }
                    break;
                default:
                    System.out.println("SELECCIONA UNA OPCIÓ VÁLIDA.");
            }
        }
    }
}