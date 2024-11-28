package Exercici_5;

public class Prova3 {
    public static void main(String[] args) {
        VerificarMatricula verificador = new VerificarMatricula();
        String matricula = "34567BCD";
       
        int i;
        int nums = 0;
        int chars = 0;

        for (i=0;i<matricula.length();i++) {
            if(Character.isDigit(matricula.charAt(i))){
                System.out.println("Número : " + i + "  " + matricula.charAt(i));
                nums++;
            }
            else
            {
                System.out.println("Lletra : " + i + "  " + matricula.charAt(i));
                chars++;
            }
        }
        System.out.println(verificador.verificador(nums, chars));

    }
}
