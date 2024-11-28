package Exercici_4;

public class Prova2 {
    public static void main(String[] args) {
        int i;
        i = 0; // La varaible i no estava inicialitzada
        while(i<=10){ // La condició ha de ser <= i no =>, ja que com que i no és més gran o igual que 10 
            System.out.println("Hola,classe");
            i++; // La variable i no estava incrementada
        }
    }
}