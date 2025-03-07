package examenUF4;

public class Cas {
    String nom;
    String descripcio;
    String estat;
    Detectiu detectiu;

    public Cas(String nom, String descripcio) {
        this.nom = nom;
        this.descripcio = descripcio;
    }

    public void canviarEstat(String estat) {
        this.estat = estat;
    }

    public void assignarDetectiu(Detectiu detectiu) {
        this.detectiu = detectiu;
    }

    public String getNom() {
        return nom;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public String getEstat() {
        return estat;
    }

    public Detectiu getDetectiu() {
        return detectiu;
    }

    @Override
    public String toString() {
        return "Cas{" +
                "nom='" + nom + '\'' +
                ", descripcio='" + descripcio + '\'' +
                ", estat='" + estat + '\'' +
                ", detectiu=" + detectiu +
                '}';
    }
}
