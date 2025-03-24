package model;

public class Alumne {
    private String nom;
    private String cognoms;
    private int edat;
    private String dni;

    public Alumne() {
        this.nom = "";
        this.cognoms = "";
        this.edat = 0;
        this.dni = "";
    }

    public Alumne(String nom, String cognoms, int edat, String dni) {
        this.nom = nom;
        this.cognoms = cognoms;
        this.edat = edat;
        this.dni = dni;
    }

    public Alumne(Alumne alumne) {
        this.nom = alumne.getNom();
        this.cognoms = alumne.getCognoms();
        this.edat = alumne.getEdat();
        this.dni = alumne.getDni();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognoms() {
        return cognoms;
    }

    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
