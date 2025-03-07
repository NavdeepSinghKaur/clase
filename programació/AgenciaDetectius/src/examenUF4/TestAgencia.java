package examenUF4;

public class TestAgencia {
    AgenciaDetectius ad = new AgenciaDetectius();

    public static void main(String[] args) {
        System.out.println("""
                Agencia de Detectius. Alumne: Navdeep Singh Kaur
                −−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−----------−−−−−−
                [1] Carregar informació en l’agència
                [2] Llistar els noms dels detectius actuals.
                [3] Llistar els casos de l'agència
                [4] Buidar l'agència de les seves dades.
                [0] Sortir.
                """);
    }

    ///////////////////////////////////////////////////////////////////////
    // Funció per carregar les Dades dins l'objecte ad ( AgenciaDetectius )
    ///////////////////////////////////////////////////////////////////////
    public void carregarDades() {
        ad = new AgenciaDetectius();
        Cas c1 = new Cas ( "Robatori1","Robatori en un banc de la ciutat" );
        DetectiuRobatoris d1 = new DetectiuRobatoris ("Miss Marple", 61 );
        c1.assignarDetectiu(d1);
        ad.agregarCas(c1);
        Cas c2 = new Cas ( "Robatori2", "Robatori del diamant de la Pantera Rosa");
        DetectiuRobatoris d2 = new DetectiuRobatoris ( "Jaques Clouseau", 52 );
        c2.assignarDetectiu(d2);
        ad.agregarCas(c2);
        Cas c3 = new Cas ( "Homicidi1", "Mort del lloro d'un DJ famos");
        DetectiuHomicidis d3 = new DetectiuHomicidis ( "Hercules Poirot", 43);
        c3.assignarDetectiu(d3);
        ad.agregarCas(c3);
        Cas c4 = new Cas ( "Segrest1", "Segrest de Tintin ");
        DetectiuSegrestos d4 = new DetectiuSegrestos(" Dupond et Dupont", 55);
        c4.assignarDetectiu(d4);
        ad.agregarCas(c4);
        Cas c5 = new Cas ( "Homicidi2", "Mort de IronMan");
        c5.assignarDetectiu(d3);
        ad.agregarCas(c5);
        System.out.println("Imprimir tots els casos:");
        imprimirCasos( ad.getCasos() );
        d3.trobarPistes();
        d3.resoldreCas(c3);
        c3.canviarEstat("Resolt");
        d4.trobarPistes();
        d4.resoldreCas(c4);
        c4.canviarEstat("Resolt");
        System.out.println("\nImprimir casos del detectiu Hercules Poirot:");
        imprimirCasos( ad.obtenirCasosDetectiu(d3) );
        System.out.println("Eliminem el cas c4");
        ad.eliminarCas(c4);
    }
}
