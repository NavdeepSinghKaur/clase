package main.java.inscaparrella.controller;

import main.java.inscaparrella.model.*;
import main.java.inscaparrella.utils.Danger;
import main.java.inscaparrella.utils.MovementDirection;
import main.java.inscaparrella.utils.PowerUp;
import main.java.inscaparrella.utils.ShootDirection;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class WumpusController {
    private WumpusLaberynth laberynth;
    private Player player;
    private String traverseMessage;
    private String echoes;
    private boolean gameEnded;
    private boolean won;

    public WumpusController() {
        laberynth = new WumpusLaberynth();
        player = new Player();
        echoes = "";
        gameEnded = true;
        won = false;
    }

    public void loadLaberynth(String filename) throws FileNotFoundException {
        ArrayList<ArrayList<Cell>> inputLaberynth = new ArrayList<>();
        ArrayList<Cell> inputLaberynthRows = new ArrayList<>();
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        Scanner sr = new Scanner(br);
        while (sr.hasNextLine()) {
            String line = sr.nextLine();
            String[] lineElements = line.split(" ");
            if (line.endsWith("N ") || line.endsWith("P ") || line.endsWith("W ")) {
                for (int i = 0; i < lineElements.length; i++) {
                    if (lineElements[i].equals("N")) {
                        inputLaberynthRows.add(new NormalCell());
                    } else if (lineElements[i].equals("P")) {
                        inputLaberynthRows.add(new PowerUpCell());
                    } else if (lineElements[i].equals("W")) {
                        inputLaberynthRows.add(new WellCell());
                    }
                }
                inputLaberynth.add(inputLaberynthRows);
                inputLaberynthRows = new ArrayList<>();
            } else {
                System.out.println("wumpus: " + line);
                line = sr.nextLine();
                System.out.println("Bats: " + line);
            }
        }
        for (ArrayList<Cell> cells : inputLaberynth) {
            for (Cell cell : cells) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }

    public void saveLaberynth() {
        
    }

    public boolean startGame() {
        int[] playerPosition;
        boolean bGameStarted = false;
        gameEnded = false;
        laberynth.createNewLaberynth();
        playerPosition = laberynth.getInitialCell();
        traverseCell();
        if (playerPosition != null) {
            won = false;
            player.setStartingCell(playerPosition[0], playerPosition[1]);
            echoes = getLastEchoes();
            traverseMessage = "";
            bGameStarted = true;
        }
        return bGameStarted;
    }

    public void movePlayer(MovementDirection dir) {
        int[] playerPositions;
        if (!gameEnded) {
            traverseMessage = "";
            playerPositions = laberynth.movePlayer(dir);
            player.move(playerPositions[0], playerPositions[1]);
            echoes = laberynth.emitEchoes();
            traverseCell();
            if (!gameEnded) {
                laberynth.moveBats();
            }
        }
    }

    /*
    * WRONG IMPLEMENTATION OF THE METHOD - TO FIX
    * **/
    public void huntTheWumpus(ShootDirection dir) {
        if (!gameEnded && player.getPowerUpQuantity(PowerUp.ARROW) > 0) {
            if (player.usePower(PowerUp.ARROW)) {
                System.out.println("Arrows restants: " + player.getPowerUpQuantity(PowerUp.ARROW));
            }
            if (laberynth.shootArrow(dir)){
                won = true;
                gameEnded = true;
            } else {
                if (laberynth.startleWumpus()){
                    System.out.println("Wumpus s'ha espantat bro. wumpus controller class message");
                } else {
                    System.out.println("el wumpus no s'ha espantat, wumpus controller class message");
                }
            }
        }
    }

    public String getLastTraverseMessage() {
        return traverseMessage;
    }

    public String getLastEchoes() {
        return echoes;
    }

    public boolean isGameEnded() {
        return gameEnded;
    }

    public boolean isGameWon() {
        return won;
    }

    @Override
    public String toString() {
        String returnText = "";
        returnText += player.toString() + "\n";
        returnText += getLastTraverseMessage();
        returnText += getLastEchoes() + "\n";
        returnText += laberynth.toString();

        return returnText;
    }

    private void traverseCell() {
        if (laberynth.getDanger() == Danger.WUMPUS) {
            won = false;
            gameEnded = true;
            traverseMessage += "El Wumpus ha atacat i malferit al jugador!";
        }
        if (laberynth.getDanger() == Danger.WELL) {
            if ( player.getPowerUpQuantity(PowerUp.JUMPER_BOOTS) < 1) {
                won = false;
                gameEnded = true;
                traverseMessage += "El jugador ha caigut en un pou i ha quedat malferit!";
            } else {
                player.usePower(PowerUp.JUMPER_BOOTS);
                traverseMessage += "El jugador ha estat a punt de caure en un pou, però, per sort, portava les JUMPER BOOTS";
            }
        }
        if (laberynth.getDanger() == Danger.BAT) {
            laberynth.batKidnapping();
            traverseMessage += "Un ratpenat s’enduu el jugador!";
            traverseCell();
        }
        PowerUp powerType = laberynth.getPowerUp();
        if (powerType != PowerUp.NONE) {
            player.addPower(powerType);
            if (powerType.equals(PowerUp.ARROW)) {
                traverseMessage += "El jugador ha trobat una unitat del poder ARROW";
            } else {
                traverseMessage += "El jugador ha trobat una unitat del poder JUMPER_BOOTS";
            }
        }
    }
}