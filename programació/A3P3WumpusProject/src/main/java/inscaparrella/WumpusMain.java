package main.java.inscaparrella;

import main.java.inscaparrella.controller.WumpusController;
import main.java.inscaparrella.utils.MovementDirection;
import main.java.inscaparrella.utils.ShootDirection;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Membres del grup:
 *  - Navdeep Singh Kaur
 */

public class WumpusMain {
    public static void main(String[] args) {
        WumpusController controller;
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
            scanner.nextLine();
            switch (option) {
                case 0:
                    System.out.println("Ok.");
                    scanner.close();
                    exitGame = true;
                    break;
                case 1:
                    controller = new WumpusController();
                    System.out.println("Indica la ubicació del arxiu: ");
                    String location = "";
                    location = scanner.nextLine();
                    try {
                        System.out.println(location);
                        controller.loadLaberynth(location);
                    } catch (Exception e) {
                        // fix this later and print the exception more correctlhy (also, get the exception in a better way from the controller)
                        System.out.println(e);
                    }
                    controller.startGame();
                    while (!controller.isGameEnded()) {
                        System.out.println();
                        System.out.println(controller.toString());
                        System.out.println("Indica el moviment que faràs WASD: ");
                        String movement = scanner.nextLine();
                        switch (movement) {
                            case "w": controller.movePlayer(MovementDirection.UP);
                                break;
                            case "a": controller.movePlayer(MovementDirection.LEFT);
                                break;
                            case "s": controller.movePlayer(MovementDirection.DOWN);
                                break;
                            case "d": controller.movePlayer(MovementDirection.RIGHT);
                                break;
                            case "W": controller.huntTheWumpus(ShootDirection.UP);
                                break;
                            case "A": controller.huntTheWumpus(ShootDirection.LEFT);
                                break;
                            case "S": controller.huntTheWumpus(ShootDirection.DOWN);
                                break;
                            case "D": controller.huntTheWumpus(ShootDirection.RIGHT);
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
                case 2:
                    controller = new WumpusController();
                    controller.startGame();
                    System.out.println("Indica el nom del fitxer a on es guardarà la partida: ");
                    String fileName = scanner.nextLine();
                    try {
                        controller.saveLaberynth(fileName);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    while (!controller.isGameEnded()) {
                        System.out.println();
                        System.out.println(controller.toString());
                        System.out.println("Indica el moviment que faràs WASD: ");
                        String movement = scanner.nextLine();
                        switch (movement) {
                            case "w": controller.movePlayer(MovementDirection.UP);
                                break;
                            case "a": controller.movePlayer(MovementDirection.LEFT);
                                break;
                            case "s": controller.movePlayer(MovementDirection.DOWN);
                                break;
                            case "d": controller.movePlayer(MovementDirection.RIGHT);
                                break;
                            case "W": controller.huntTheWumpus(ShootDirection.UP);
                                break;
                            case "A": controller.huntTheWumpus(ShootDirection.LEFT);
                                break;
                            case "S": controller.huntTheWumpus(ShootDirection.DOWN);
                                break;
                            case "D": controller.huntTheWumpus(ShootDirection.RIGHT);
                                break;
                            default: System.out.println("ERROR. No has introduït una opció correcta.\nTorna a intentar-ho.");
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
