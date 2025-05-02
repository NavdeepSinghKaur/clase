package guardiaurbana;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

public class GestioAccidentsMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Accident> accidents = new LinkedList<>();

        try {
            accidents = loadData("resources/2022_accidents_causa_conductor_gu_bcn_.csv");
        } catch (Exception e) {
            e.printStackTrace();
        }

        boolean endProgram = false;
        while (!endProgram) {
            System.out.println(menuMessage());
            int option = scanner.nextInt();
            switch (option) {
                case 0:
                    endProgram = true;
                    scanner.close();
                case 1:
                    accidents.forEach(s -> System.out.println(s.toString()));
                    break;

                case 2:
                    System.out.println("Indica el mes en número (de 1 a 12): ");
                    int month = scanner.nextInt();
                    while (month < 1 || month > 12) {
                        System.out.println("El més ha d'estar entre 1 i 12. Torna a intetnar-ho: ");
                        month = scanner.nextInt();
                    }
                    int finalMonth = month;
                    System.out.println("En el mes " + finalMonth + " hi ha hagut " +
                            accidents
                                .stream()
                                .filter(accident -> accident.getMesAny() == finalMonth)
                                .count() + " accidents."
                    );
                    break;

                case 3:
                    System.out.println("Total accidents = " +
                            accidents
                                    .stream()
                                    .count()
                    );
                    System.out.println("Total accidnets matí = " +
                            accidents
                                    .stream()
                                    .filter(accident -> accident.getDescripcioTorn().equals("Matí"))
                                    .count()
                    );
                    System.out.println("Total accidnets tarda = " +
                            accidents
                                    .stream()
                                    .filter(accident -> accident.getDescripcioTorn().equals("Tarda"))
                                    .count()
                    );
                    System.out.println("Total accidents nit = " +
                            accidents
                                    .stream()
                                    .filter(accident -> accident.getDescripcioTorn().equals("Nit"))
                                    .count()
                    );
                    break;

                case 4:
                    Map<String, Long> countAccidents = accidents
                            .stream()
                            .collect(Collectors.groupingBy(
                                    accident -> accident.getNomBarri(),
                                    Collectors.counting()
                            ));

                    countAccidents
                            .entrySet()
                            .stream()
                            .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder()))
                            .limit(10)
                            .forEach(
                                    stringLongEntry -> System.out.println(stringLongEntry.getValue() + "accidents en " + stringLongEntry.getKey())
                            );
                    break;

                case 5:
                    Map<String, Long> countCauses = accidents
                            .stream()
                            .collect(Collectors.groupingBy(
                                    accident -> accident.getDescripcioCausaMediata(),
                                    Collectors.counting()
                            ));

                    countCauses
                            .entrySet()
                            .stream()
                            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                            .forEach(
                                    stringLongEntry -> System.out.println(stringLongEntry.getValue() + " accidents produïts per: " + stringLongEntry.getKey())
                            );
                break;
                default:
                    System.out.println("Torna a intentar-ho:");
            }
        }
    }

    private static List<Accident> loadData(String filename) throws IOException {
        File f = new File(filename);
        FileReader fr = new FileReader(f, StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(fr);

        return br.lines()
                .skip(1)
                .map(line -> mapFile(line))
                .collect(Collectors.toList());
    }

    private static Accident mapFile(String line) {
        // detecta lo siguiente como un salto de linea Sant Pere, Santa Caterina i la Ribera la coma (,)
        String[] registry = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
        return new Accident(registry[0].replace("\"", "").trim(),
                Integer.parseInt(registry[1].trim()),
                registry[2].replace("\"", "").trim(),
                Integer.parseInt(registry[3].trim()),
                registry[4].replace("\"", "").trim(),
                Integer.parseInt(registry[5].trim()),
                registry[6].replace("\"", "").trim(),
                registry[7].replace("\"", "").trim(),
                registry[8].replace("\"", "").trim(),
                Integer.parseInt(registry[9].trim()),
                Integer.parseInt(registry[10].trim()),
                registry[11].replace("\"", "").trim(),
                Integer.parseInt(registry[12].trim()),
                Integer.parseInt(registry[13].trim()),
                registry[14].replace("\"", "").trim(),
                registry[15].replace("\"", "").trim(),
                Double.parseDouble(registry[16].trim()),
                Double.parseDouble(registry[17].trim()),
                Double.parseDouble(registry[18].trim()),
                Double.parseDouble(registry[19].trim())
        );
    }

    private static String menuMessage() {
        return """
                Anàlisi accidents BCN 2022. (Navdeep Singh Kaur)
                1. Llistar tots els accidents
                2. Accidents que hi ha en un determinat mes/any (indicar mes numericament):
                3. Comptar accidents: matí, tarda i nit:
                4. Llistat ordenat descendent dels 10 barris amb més accidents
                5. Llistat de les causes dels accidents ordenats per freqüència
                0. Sortir
                """;
    }
}
