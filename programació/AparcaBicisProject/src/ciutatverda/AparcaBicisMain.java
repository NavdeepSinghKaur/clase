package ciutatverda;

import java.io.*;
import java.util.*;
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
                aparcaBicis.forEach(aparcaBici -> System.out.println(aparcaBici.toString()));
                break;
            case 2:
                System.out.println("Indica el carrer: ");
                String carrer = scanner.nextLine();
                aparcaBicis.stream()
                        .filter(aparcabici -> aparcabici.getCarrer().equals(carrer))
                        .forEach(aparcaBici -> System.out.println(aparcaBici));
                break;
            case 3:
                aparcaBicis.stream()
                                .filter(aparcaBici -> aparcaBici.isProtegitambPilona())
                                .forEach(aparcaBici -> System.out.println(aparcaBici));
                break;
            case 4:
                Map<String, List<Integer>> numeroAparcaBicisPerBarri = convertAparcabicisToMap(aparcaBicis);

                numeroAparcaBicisPerBarri.entrySet().stream()
                    .sorted(Map.Entry.comparingByKey())
                    .forEach(aparcaBici -> System.out.println("Carrer " + aparcaBici.getKey() + " " + aparcaBici.getValue()));
                break;
            case 0:
                scanner.close();
                break;
            default:
                System.out.println("Has elegit una opció incorrecta.");
        }
    }


    private static Map<String, List<Integer>> convertAparcabicisToMap(List<AparcaBici> aparcaBicis) {
            return aparcaBicis.stream()
                    .collect(
                            Collectors.groupingBy(
                                    aparcabici -> aparcabici.getCarrer(),
                                    Collectors.collectingAndThen(
                                            Collectors.mapping(aparcaBici -> aparcaBici.getNum(), Collectors.toList()),
                                            list -> {
                                                Collections.sort(list);
                                                return list;
                                            }
                                    )
                            )
                    );
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
