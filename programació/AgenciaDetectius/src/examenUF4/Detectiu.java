package examenUF4;

public abstract class Detectiu {
    protected String nom;
    private int edat;
    private String especialitat;

    public Detectiu(String nom, int edat, String especialitat) {
        this.nom = nom;
        this.edat = edat;
        this.especialitat = especialitat;
    }

    public String resoldreCas(Cas cas) {

    }
}
