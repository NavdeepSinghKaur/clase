package Exercici_5;



public class VerificarMatricula {
    public String verificador(int contadorNumeros, int contadorChars) {
        if (contadorNumeros == 4 && contadorChars == 3) 
            return "La matricula es correcta";
        else
            return "La matricula no es correcta";
    }
}
