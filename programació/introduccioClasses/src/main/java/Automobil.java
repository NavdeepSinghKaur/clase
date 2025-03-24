// Definció de classe (Típus de dades)
public class Automobil {
    // variables de instància (atributs)
    private String marca;
    private String model;

    // constructor
    public Automobil(String m, String mo){
        this.marca = m;
        this.model = mo;
    }
    // mètode
    public String mostrarDades() {
        return "Marca: " + this.marca + "\n" + "Model: " + this.model;
    }
}
