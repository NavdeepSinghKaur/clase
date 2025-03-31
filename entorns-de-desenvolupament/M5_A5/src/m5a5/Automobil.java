package m5a5;

import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.UpperCase;

public class Automobil {
    public String marca;
    public String model;
    public String matricula;

    public Automobil(String marca, String model, String matricula) {
        this.marca = marca;
        this.model = model;
        this.matricula = matricula;
    }

    public String mostrarDades() {
        return "Marca: " + this.marca + "\n" + "Model: " + this.model + "\n" + "Matrícula: " + this.matricula;
    }

    /**
     * Funció que retorna true si una matrícula és vàlida a Espanya
     * @param matricula : String
     * @return True: Matrícula correcta, False: en altre cas
     */
    public boolean validarMatricula(String matricula){
        boolean value = true;
        String[] arrayMatricula = matricula.split("");
        if (matricula.length() <= 1) {
           value = false;
        }
        else {
            for (int i = 0; i < arrayMatricula.length; i++) {
                char matriculaChar = matricula.charAt(i);
                if (i < 4 && !(Character.isDigit(matriculaChar)) ||
                        i >= 4 && !(Character.isUpperCase(matriculaChar))) {
                    value = false;
                }
            }
        }
        return value;
    }

}
