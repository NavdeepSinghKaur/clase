import java.util.Objects;

public class ComputerScientist extends OnGoingWork {
    private String nom;
    private String cognoms;
    private int edat;
    private String titol;
    private int anyGraduacio;
    private int experienciaLaboral;
    private double sou;

    public ComputerScientist() {
        this.nom = "";
        this.cognoms = "";
        this.edat = 0;
        this.titol = "";
        this.anyGraduacio = 0;
        this.experienciaLaboral = 0;
        this.sou = 0;
    }

    public ComputerScientist(String nom, String cognoms, int edat, String titol, int anyGraduacio, int experienciaLaboral, double sou) {
        this.nom = nom;
        this.cognoms = cognoms;
        this.edat = edat;
        this.titol = titol;
        this.anyGraduacio = anyGraduacio;
        this.experienciaLaboral = experienciaLaboral;
        this.sou = sou;
    }

    public ComputerScientist(ComputerScientist computerScientist) {
        this.nom = computerScientist.nom;
        this.cognoms = computerScientist.cognoms;
        this.edat = computerScientist.edat;
        this.titol = computerScientist.titol;
        this.anyGraduacio = computerScientist.anyGraduacio;
        this.experienciaLaboral = computerScientist.experienciaLaboral;
        this.sou = computerScientist.sou;
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

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public int getAnyGraduacio() {
        return anyGraduacio;
    }

    public void setAnyGraduacio(int anyGraduacio) {
        this.anyGraduacio = anyGraduacio;
    }

    public int getExperienciaLaboral() {
        return experienciaLaboral;
    }

    public void setExperienciaLaboral(int experienciaLaboral) {
        this.experienciaLaboral = experienciaLaboral;
    }

    public double getSou() {
        return sou;
    }

    public void setSou(double sou) {
        this.sou = sou;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ComputerScientist cs)) return false;
        return this.edat == cs.edat && this.anyGraduacio == cs.anyGraduacio && this.experienciaLaboral == cs.experienciaLaboral && Double.compare(this.sou, cs.sou) == 0 && Objects.equals(this.nom, cs.nom) && Objects.equals(this.cognoms, cs.cognoms) && Objects.equals(this.titol, cs.titol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, cognoms, edat, titol, anyGraduacio, experienciaLaboral, sou);
    }

    @Override
    public String toString() {
        return "ComputerScientist{" +
                "nom='" + nom + '\'' +
                ", cognoms='" + cognoms + '\'' +
                ", edat=" + edat +
                ", titol='" + titol + '\'' +
                ", anyGraduacio=" + anyGraduacio +
                ", experienciaLaboral=" + experienciaLaboral +
                ", sou=" + sou +
                '}';
    }

    @Override
    public String onGoingWork() {
        return "";
    }
}
