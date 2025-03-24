package m5a5;

public class Main {
    public static void main(String[] args){
        Automobil civic = new Automobil("Honda", "Civic Mk6", "2489BKS");
        Automobil xantia = new Automobil("Citroën", "Xantia Activa", "1893ABJ");
        Automobil model3 = new Automobil("Tesla", "Model 3 Highland", "3287MYZ");

        System.out.println(civic.mostrarDades());
        System.out.println(xantia.mostrarDades());
        System.out.println(model3.mostrarDades());

        System.out.println(civic.validarMatricula(civic.matricula));
        System.out.println(civic.validarMatricula(xantia.matricula));
        System.out.println(civic.validarMatricula(model3.matricula));

    }


}
