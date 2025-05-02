package exam.view;

import exam.model.MarvelActor;
import exam.model.MarvelDataSetLine;
import exam.model.MarvelFilm;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Exercise2Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<MarvelDataSetLine> marvelDataset = new ArrayList<>();
        List<MarvelFilm> marvelFilms = new ArrayList<>();
        List<MarvelActor> marvelActors = new ArrayList<>();

        try {

            File f = new File("./files/marvel.csv");
            FileReader fr = new FileReader(f);
            FileReader fr2 = new FileReader(f);
            FileReader fr3 = new FileReader(f);
            BufferedReader filmBr = new BufferedReader(fr);
            BufferedReader actorBr = new BufferedReader(fr2);
            BufferedReader br = new BufferedReader(fr3);

            marvelDataset = br.lines().skip(1).map(line -> loadData(line)).toList();
            marvelActors = filmBr.lines().skip(1).map(line -> loadActorData(line)).toList();
            marvelFilms = actorBr.lines().skip(1).map(line -> loadFilmData(line)).toList();

        } catch (Exception f) {
            f.printStackTrace();
        }

        boolean exitProgram = false;
        while (!exitProgram) {
            System.out.println(menu());
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 0:
                    scanner.close();
                    exitProgram = true;
                    break;
                case 1:

                        System.out.println("Fase a consultar: ");
                        int phase = scanner.nextInt();
                        marvelFilms.stream()
                                .filter(film -> film.getPhase() == phase)
                                .sorted(Comparator.comparingInt(film -> film.getReleaseDate()))
                                .distinct()
                                .forEach(f -> System.out.println(f));
                    break;
                case 2:
                    marvelActors.stream().sorted(Comparator.comparingInt(actor -> actor.getAge())).distinct().forEach(marvelActor -> System.out.println(marvelActor));
                    break;
                case 3:
                    System.out.println("Personatge a consultar: ");
                    String person = scanner.nextLine();
                    marvelDataset
                            .stream()
                            .sorted(Comparator.comparingInt(film -> film.getFilmReleaseDate()))
                            .limit(5)
                            .filter(film -> film.getFilmTitle().replace("\'", "").startsWith(person))
                            .forEach(marvelFilm -> System.out.println(marvelFilm));

                                        break;
                case 4:
                    System.out.println("Edad a buscar: ");
                    int age = scanner.nextInt();

                    Long olderThan = marvelActors.stream().distinct().filter(actor -> actor.getAge() > 60).count();
                    System.out.println("Actora més grans que " + age + ": " + olderThan);
                    break;
                default:
                    System.out.println("Has d'elegir una opció correcta.");
            }
        }
    }



    private static String menu() {
        return """
                0. Sortir
                1. Mostrar totes les pel·lícules d'una fase (per data i sense repeticions)
                2. Mostrar tots els actors (per edat i sense repeticions)
                3. Mostrar les 5 primeres pel·lícules on surt un personatge determinat (data)
                4. Mostrar quants actos són més grans d'una certa edat (sense repeticions ) 
                """;
    }

        private static MarvelDataSetLine loadData(String line) {
        String[] marvelEverything = line.split(",");
        for (int i = 0; i < marvelEverything.length; i++) {
            marvelEverything[i] = marvelEverything[i].replace("\"", "");
            marvelEverything[i] = marvelEverything[i].replace("\'", "");
        }
        return getMarvelDataSetLines(marvelEverything);
    }
    private static MarvelDataSetLine getMarvelDataSetLines(String[] marvelEverything) {
        return new MarvelDataSetLine(
                Integer.parseInt(marvelEverything[0]),
                marvelEverything[1],
                Integer.parseInt(marvelEverything[2]),
                Integer.parseInt(marvelEverything[3]),
                Integer.parseInt(marvelEverything[4]),
                marvelEverything[5].replace("\"", ""),
                Integer.parseInt(marvelEverything[6]),
                marvelEverything[7],
                marvelEverything[8]
        );
    }

    private static MarvelFilm loadFilmData(String line) {
        String[] marvelEverything = line.split(",");
        for (int i = 0; i < marvelEverything.length; i++) {
            marvelEverything[i] = marvelEverything[i].replace("\"", "");
        }
        return getMovieDataSetLine(marvelEverything);
    }

    private static MarvelFilm getMovieDataSetLine(String[] marvelEverything) {
        return new MarvelFilm(
                Integer.parseInt(marvelEverything[0]),
                marvelEverything[1],
                Integer.parseInt(marvelEverything[2]),
                Integer.parseInt(marvelEverything[3])
        );
    }

    private static MarvelActor loadActorData(String line) {
        String[] marvelEverything = line.split(",");
        for (int i = 0; i < marvelEverything.length; i++) {
            marvelEverything[i] = marvelEverything[i].replace("\"", "");
        }
        return getActorDataSetLine(marvelEverything);
    }

    private static MarvelActor getActorDataSetLine(String[] marvelEverything) {
        return new MarvelActor(
                Integer.parseInt(marvelEverything[4]),
                marvelEverything[5],
                Integer.parseInt(marvelEverything[6]),
                marvelEverything[7],
                marvelEverything[8]
        );
    }

}
