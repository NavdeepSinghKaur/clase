package ciutatverda;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.nio.charset.StandardCharsets;

public class AparcaBicisMain {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        List<AparcaBici> aparcaBicis = new LinkedList<>();
        //load file
        aparcaBicis = loadFile(aparcaBicis);
        //main menu
        System.out.println(getMenu());
        int opcio = scanner.nextInt();
        scanner.nextLine();

        switch (opcio) {
            case 1:
                System.out.println(getBicis(aparcaBicis));
                break;
            case 2:
                System.out.println("Indica el carrer: ");
                String carrer = scanner.nextLine();
                String streets = getStreet(aparcaBicis, carrer);
                System.out.println(streets);
                break;
            case 3:
                System.out.println(getProtected(aparcaBicis));
                break;
            case 0:
                scanner.close();
                break;
            default:
                System.out.println("Has elegit una opció incorrecta.");
        }
    }

    private static String getStreet(List<AparcaBici> aparcaBicis, String carrer) {
        String output = "";
        output = aparcaBicis.stream().filter(aparcaBici -> aparcaBici.getCarrer().equals(carrer)).toList().toString();
        return output;
    }

    private static String getProtected(List<AparcaBici> aparcaBicis) {
        String output = "";
        output = aparcaBicis.stream().filter(aparcaBici -> aparcaBici.isProtegitambPilona()).toList().toString();

        return output;
    }

    private static List<AparcaBici> loadFile(List<AparcaBici> aparcaBicis) throws FileNotFoundException {
        File f = new File("/home/nsingh/Downloads/aparcabicis.csv");
        InputStream inputF = new FileInputStream(f);
        InputStreamReader reader = new InputStreamReader(inputF, StandardCharsets.ISO_8859_1);
        BufferedReader br = new BufferedReader(reader);

        try {
            aparcaBicis = br.lines()
                    .skip(1)
                    .map(line -> new AparcaBici(line))
                    .collect(Collectors.toList());
        } catch (Exception _){}

       return aparcaBicis;
    }

    private static String getBicis(List aparcaBicis) {
        String output = "";
        for (Object aparcaBici : aparcaBicis) {
            output += aparcaBici + "\n";
        }

        return output;
    }

    private static String getMenu() {
        return """
                1. Llistar tots els aparcabicis carregats
                2. Llistar aparcabicis per nom de carrer
                3. Llistar tots els aparcabicis protegits amb pilona
                4. Mostrar situació dels aparcabicis a cada carrer
                0. Sortir
                """;
    }
}
