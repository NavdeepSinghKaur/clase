package main.java.inscaparrella;

import main.java.inscaparrella.controller.WumpusController;
import main.java.inscaparrella.utils.MovementDirection;
import main.java.inscaparrella.utils.ShootDirection;

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
                        switch (movement) {
                            case "w":
                                controller.movePlayer(MovementDirection.UP);
                                break;
                            case "a":
                                controller.movePlayer(MovementDirection.LEFT);
                                break;
                            case "s":
                                controller.movePlayer(MovementDirection.DOWN);
                                break;
                            case "d":
                                controller.movePlayer(MovementDirection.RIGHT);
                                break;
                            case "W":
                                controller.huntTheWumpus(ShootDirection.UP);
                                break;
                            case "A":
                                controller.huntTheWumpus(ShootDirection.LEFT);
                                break;
                            case "S":
                                controller.huntTheWumpus(ShootDirection.DOWN);
                                break;
                            case "D":
                                controller.huntTheWumpus(ShootDirection.RIGHT);
                                break;
                            default:
                                System.out.println("ERROR. No has introduït una opció correcta.\nTorna a intentar-ho.");
                        }
                    }
                    if (controller.isGameEnded() && controller.isGameWon()) {
                        System.out.println("Yuo won");
                    } else {
                        System.out.println("you lost");
                    }
                    break;
                default:
                    System.out.println("ERROR. No has introduït una opció correcta.\nTorna a intentar-ho.");
            }
        }
    }
}
