package tasques;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import util.GestorBD;

public class TasquesTest {
    GestorBD gestor;
    BufferedReader entrada;
    public static void main(String[] args) throws Exception {
        TasquesTest tasquesBD = new TasquesTest();
        tasquesBD.start();
    }
    public TasquesTest() throws Exception{
        gestor = new GestorBD();
        entrada = new BufferedReader(new InputStreamReader(System.in));
    }
    public void start() throws Exception {
        String linia;
        String eof="0";
        try
        {
            do {
                linia=entrada.readLine();
                processar(linia);
            } while (!linia.equals(eof));
        }
        catch (Exception ex) {
            System.out.println("S’ha produït un error: " + ex + "\n");
        }
        gestor.tancar();
    }
    private void processar(String line) throws Exception {
        String[] paraules=line.split("#|,");

        switch (paraules[0]) {
            case "afegir":
                gestor.afegirTasca(line);
                break;

            case "eliminar":
                gestor.eliminarTasca(line);
                break;

            case "actualitzar":
                gestor.actualitzarTasca(line);
                break;

            case "mostrar":
                gestor.mostrarTasquesperNivell(line);
                break;

            case "0": // Es la opció que permet sortir del programa
                // No ha de fer res
                break;

            default:
                System.out.println("ERROR: opció incorrecta");
                break;
        }

    }
}