package main.java.inscaparrella;

import main.java.inscaparrella.controller.WumpusController;
import main.java.inscaparrella.utils.ConsoleColors;
import main.java.inscaparrella.utils.MovementDirection;
import main.java.inscaparrella.utils.ShootDirection;

import java.io.IOException;
import java.util.Scanner;

/**
 * Membres del grup:
 *  - Navdeep Singh Kaur
 */

public class WumpusMain {
    public static void main(String[] args) {
        WumpusController controller = new WumpusController();
        Scanner scanner = new Scanner(System.in);
        boolean exitGame = false;
        boolean startGame = false;

        while (!exitGame) {
            System.out.println(menu());
            
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
                    startGame = loadFile(controller, location);
                    if (!startGame) {
                        System.out.println(saveLoadFileError());
                    }
                    break;
                case 2:
                    System.out.println("Indica la ubicació del fitxer sense la extensió a on es guardarà la partida (per defecte ./files/wumpus1.txt): ");
                    String fileName = scanner.nextLine();
                    startGame = saveFile(fileName, controller);
                    if (!startGame) {
                        System.out.println(saveLoadFileError());
                    }
                    break;
                default:
                    System.out.println(errorMsg());
            }
            
            if (startGame) {
                controller.startGame();
                while (!controller.isGameEnded()) {
                    System.out.println();
                    System.out.println(controller.toString());
                    System.out.println("w -> moure amunt; s -> moure avall; a -> moure esquerra; d -> moure dreta\n" +
                            "W -> disparar amunt; S -> disparar avall; A -> disparar esquerra; D -> disparar dreta" +
                            "Opció: ");
                    System.out.println(moveAndShot(scanner.nextLine(), controller));
                }
                if (controller.isGameEnded() && controller.isGameWon()) {
                    System.out.println(ConsoleColors.BLUE_BRIGHT + "HAS GUANYAT!" + ConsoleColors.RESET);
                } else {
                    System.out.println("HAS PERDUT...");
                }
                startGame = false;
            }
        }
    }

    private static String saveLoadFileError() {
        return "Hi ha hagut un error al carregar o crear el fitxer. Torna a intentar-ho.";
    }

    private static boolean loadFile(WumpusController controller, String location) {
        boolean bFileLoaded = false;

        try {
            controller.loadLaberynth(location);
            bFileLoaded = true;
        } catch (Exception _) {

        }

        return bFileLoaded;
    }

    private static boolean saveFile(String fileName, WumpusController controller) {
        boolean bFileSaved = false;
        try {
            if (!fileName.isEmpty()) {
                controller.saveLaberynth(fileName);
            } else {
                controller.saveLaberynth("wumpus1");
            }
            bFileSaved = true;

        } catch (IOException _) {

        }

        return bFileSaved;
    }

    public static String menu() {
        return "~~~ HUNT THE WUMPUS ~~~" + "\n" +
                    "0. Sortir" + "\n" +
                    "1. Carregar partida"  + "\n" +
                    "2. Crear nova partida"  + "\n" +
                    
                    "Entrada:";
    }
    
    public static String moveAndShot(String movement, WumpusController controller) {
        String outputMessage = "";

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
            default: errorMsg();
        }
        return outputMessage;
    }
    
    public static String errorMsg() {
        return ConsoleColors.RED_BOLD + "ERROR. No has elegit una opció correcta.\nTorna a intentar-ho." + ConsoleColors.RESET;
    }
}
