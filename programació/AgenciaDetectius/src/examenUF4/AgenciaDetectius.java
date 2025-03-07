package examenUF4;

public class AgenciaDetectius {
    Cas[] cassos;

    public AgenciaDetectius() {
        cassos = new Cas[20];
    }

    public void agregarCas(Cas cas) {
        int i = 0;
        while (cassos[i] != null && i < cassos.length -1) {
            i++;
        }
        cassos[i] = cas;
        }

    public void eliminarCas(Cas cas) {
        int i = 0;
        try {
            while (cassos[i] != cas) {
                i++;
            }
        } catch (Exception _) {
            System.out.println("El cas no existeix.");
        }
    }

    public Cas[] getCassos() {
        return cassos;
    }

//    public Cas[] obtenirCasosDetectiu(Detectiu detectiu) {
//
//    }
}
