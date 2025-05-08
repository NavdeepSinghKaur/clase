import java.io.FileNotFoundException;

public class CorrectorTest {
    public static void main(String argv[]) throws FileNotFoundException {
        try {
            CorrectorAutomatic a=new CorrectorAutomatic(argv);

            System.out.println("Diccionari carregat amb les següents paraules:");
            a.veureParaulesDiccionari();
            System.out.println("\n\nDocument carregat amb les següents paraules:");
            a.veureParaulesDocument();

            System.out.println("\n\nParaules detectades no trobades al diccionari:");
            a.trobarParaulesforaDiccionari();

            System.out.println("\n\nParaules ordenades del document i freqüència d'aparició:");
            a.imprimirFreqs();
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }
}