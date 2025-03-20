package main.java.inscaparrella;

import main.java.inscaparrella.controller.WumpusController;
import main.java.inscaparrella.utils.MovementDirection;

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
                    System.out.println("Indica el nom del fitxer a on es guardarà la partida: ");
                    String fileName = scanner.nextLine();
                    WumpusController controller = new WumpusController();
                    controller.startGame();
                    while (!controller.isGameEnded()) {
                        System.out.println();
                        System.out.println(controller.toString());
                        System.out.println("Indica el moviment que faràs WASD: ");
                        String movement = scanner.nextLine();
                        if (movement.equals("w")) {
                            controller.movePlayer(MovementDirection.UP);
                        } else if (movement.equals("a")) {
                            controller.movePlayer(MovementDirection.LEFT);
                        } else if (movement.equals("s")) {
                            controller.movePlayer(MovementDirection.DOWN);
                        } else if (movement.equals("d")) {
                            controller.movePlayer(MovementDirection.RIGHT);
                        } else {
                            System.out.println("ERROR.");
                        }
                    }
                    if (controller.isGameEnded() && controller.isGameWon()) {
                        System.out.println("Yuo won. :)");
                    } else {
                        System.out.println("you lost. :(");
                    }
                    break;
                default:
                    System.out.println("ERROR. No has introduït una opció correcta.\nTorna a intentar-ho.");
            }
        }
    }
}
