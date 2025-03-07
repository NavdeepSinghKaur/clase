package main.java.inscaparrella;

import java.util.Scanner;

/**
 * Membres del grup:
 *  - Navdeep Singh Kaur
 */

public class WumpusMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exitGame = false;

        while (!exitGame) {
            System.out.println("""
                    ~~~ HUNT THE WUMPUS ~~~
                    0. Sortir
                    1. Carregar partida
                    2. Crear nova partida
                    
                    Entrada:
                    """);
            int option = scanner.nextInt();

            switch (option) {
                case 0:
                    System.out.println("Ok.");
                    scanner.close();
                    exitGame = true;
                    break;
                case 1:
                    break;
                case 2:
                    break;
                default:
                    System.out.println("ERROR. No has introduït una opció correcta.\nTorna a intentar-ho.");
            }
        }
    }
}
