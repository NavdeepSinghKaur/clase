package comparison.main;

import comparison.controller.Album;
import comparison.models.Sticker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class StickersCollectionMain {
    public static void main(String[] args) {
        final String path = "files";
        Album album = new Album();

        try {
            File f1 = new File(path + "/stickers_500.csv");
            File f2 = new File(path + "/stickers_1000.csv");
            FileReader fr1 = new FileReader(f1);
            FileReader fr2 = new FileReader(f2);
            BufferedReader br1 = new BufferedReader(fr1);
            BufferedReader br2 = new BufferedReader(fr2);
            br1.lines()
                    .skip(1)
                    .filter(line -> line != null)
                    .forEach(
                        line -> {
                            System.out.println("Temps càrrega ArrayList: " + album.loadFileIntoArrayList(line) + " nanosegons");
                            System.out.println("Temps càrrega HashSet: " + album.loadFileIntoHasSet(line) + " nanosegons");
                            System.out.println("Temps càrrega TreeSet: " + album.loadFileIntoTreeSet(line) + " nanosegons");
                        }
                    );

            br2.lines()
                    .skip(1)
                    .filter(line -> line != null)
                    .forEach(
                            line -> {
                                System.out.println("Temps càrrega ArrayList: " + album.loadFileIntoArrayList(line) + " nanosegons");
                                System.out.println("Temps càrrega HashSet: " + album.loadFileIntoHasSet(line) + " nanosegons");
                                System.out.println("Temps càrrega TreeSet: " + album.loadFileIntoTreeSet(line) + " nanosegons");
                            }
                    );

            album.loadFileIntoArrayList("Cockatoo (roseate),2012");
            album.loadFileIntoHasSet("Cockatoo (roseate),2012");
            album.loadFileIntoTreeSet("Cockatoo (roseate),2012");

            album.loadFileIntoArrayList("Gila monster,2005");
            album.loadFileIntoHasSet("Gila monster,2005");
            album.loadFileIntoTreeSet("Gila monster,2005");

            album.loadFileIntoArrayList("Griffon vulture,1987");
            album.loadFileIntoHasSet("Griffon vulture,1987");
            album.loadFileIntoTreeSet("Griffon vulture,1987");

            album.loadFileIntoArrayList("Grikatoo,2025");
            album.loadFileIntoHasSet("Grikatoo,2025");
            album.loadFileIntoTreeSet("Grikatoo,2025");

            long start = 0;
            long end = 0;
            // 1a
            primeraEnganxina(start, album, end);
            // Enganxina del mig
            enganxinaMig(start, album, end);
            //Enganxina final
            enganxinaFinal(start, album, end);
            // enganxina diferent
            enganxinaDiferent(start, album, end);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void primeraEnganxina(long start, Album album, long end) {
        for (int i = 0; i < 1000; i++) {
            start = System.nanoTime();
            album.containsStickerArrayList(new Sticker("Cockatoo (roseate)", 2012));
            end = System.nanoTime();
        }
        System.out.println("Temps ArrayList per torbar la primera enganxina: " + (end-start) + "nanosegons");

        for (int i = 0; i < 1000; i++) {
            start = System.nanoTime();
            album.containsStickerHashSet(new Sticker("Cockatoo (roseate)", 2012));
            end = System.nanoTime();
        }
        System.out.println("Temps HashSet per torbar la primera enganxina: " + (end-start) + "nanosegons");

        for (int i = 0; i < 1000; i++) {
            start = System.nanoTime();
            album.containsStickerTreeSet(new Sticker("Cockatoo (roseate)", 2012));
            end = System.nanoTime();
        }
        System.out.println("Temps TreeSet per torbar la primera enganxina: " + (end-start) + "nanosegons");

    }
    private static void enganxinaMig(long start, Album album, long end) {
        for (int i = 0; i < 1000; i++) {
            start = System.nanoTime();
            album.containsStickerArrayList(new Sticker("Gila monster",2005));
            end = System.nanoTime();
        }
        System.out.println("Temps TreeSet per torbar l'enganxina del mig: " + (end - start) + "nanosegons");

        for (int i = 0; i < 1000; i++) {
            start = System.nanoTime();
            album.containsStickerHashSet(new Sticker("Gila monster",2005));
            end = System.nanoTime();
        }
        System.out.println("Temps TreeSet per torbar l'enganxina del mig: " + (end - start) + "nanosegons");

        for (int i = 0; i < 1000; i++) {
            start = System.nanoTime();
            album.containsStickerTreeSet(new Sticker("Gila monster",2005));
            end = System.nanoTime();
        }
        System.out.println("Temps TreeSet per torbar l'enganxina del mig: " + (end - start) + "nanosegons");
    }
    private static void enganxinaFinal(long start, Album album, long end) {
        for (int i = 0; i < 1000; i++) {
            start = System.nanoTime();
            album.containsStickerTreeSet(new Sticker("Griffon vulture",1987));
            end = System.nanoTime();
        }
        System.out.println("Temps TreeSet per torbar l'última enganxina: " + (end - start) + "nanosegons");

        for (int i = 0; i < 1000; i++) {
            start = System.nanoTime();
            album.containsStickerArrayList(new Sticker("Griffon vulture",1987));
            end = System.nanoTime();
        }
        System.out.println("Temps TreeSet per torbar l'última enganxina: " + (end - start) + "nanosegons");

        for (int i = 0; i < 1000; i++) {
            start = System.nanoTime();
            album.containsStickerHashSet(new Sticker("Griffon vulture",1987));
            end = System.nanoTime();
        }
        System.out.println("Temps TreeSet per torbar l'última enganxina: " + (end - start) + "nanosegons");

    }
    private static void enganxinaDiferent(long start, Album album, long end) {
        for (int i = 0; i < 1000; i++) {
            start = System.nanoTime();
            album.containsStickerArrayList(new Sticker("Grikatoo",2025));
            end = System.nanoTime();
        }
        System.out.println("Temps TreeSet per torbar una enganxina diferent: " + (end - start) + "nanosegons");

        for (int i = 0; i < 1000; i++) {
            start = System.nanoTime();
            album.containsStickerHashSet(new Sticker("Grikatoo",2025));
            end = System.nanoTime();
        }
        System.out.println("Temps TreeSet per torbar una enganxina diferent: " + (end - start) + "nanosegons");

        for (int i = 0; i < 1000; i++) {
            start = System.nanoTime();
            album.containsStickerTreeSet(new Sticker((String)"Grikatoo",2025));
            end = System.nanoTime();
        }
        System.out.println("Temps TreeSet per torbar una enganxina diferent: " + (end - start) + "nanosegons");

    }
}
