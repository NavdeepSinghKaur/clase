package main.java.inscaparrella.controller;

import main.java.inscaparrella.model.*;
import main.java.inscaparrella.utils.Danger;
import main.java.inscaparrella.utils.MovementDirection;
import main.java.inscaparrella.utils.PowerUp;
import main.java.inscaparrella.utils.ShootDirection;

import java.io.*;
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

    public void loadLaberynth(String filename) throws IOException {
        ArrayList<ArrayList<Cell>> inputLaberynth = new ArrayList<>();
        ArrayList<Cell> inputLaberynthRows = new ArrayList<>();
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        Scanner sr = new Scanner(br);
        int counter = 0;
        int[] wumpuspos = new int[0];
        int[] batspos = new int[0];
        while (sr.hasNextLine()) {
            String line = sr.nextLine();
            String[] lineElements = line.split(" ");
            if (line.endsWith("N ") || line.endsWith("P ") || line.endsWith("W ")) {
                for (int i = 0; i < lineElements.length; i++) {
                    if (lineElements[i].equals("N")) {
                        inputLaberynthRows.add(new NormalCell(counter, i));
                    } else if (lineElements[i].equals("P")) {
                        inputLaberynthRows.add(new PowerUpCell(counter, i));
                    } else if (lineElements[i].equals("W")) {
                        inputLaberynthRows.add(new WellCell(counter, i));
                    }
                }
                inputLaberynth.add(inputLaberynthRows);
                inputLaberynthRows = new ArrayList<>();
                counter++;
            } else {
                String[] wumpusStrList = line.split(" ");
                wumpuspos = new int[wumpusStrList.length];
                for (int i = 0; i < wumpusStrList.length; i++) {
                    wumpuspos[i] = Integer.parseInt(wumpusStrList[i]);
                }
                line = sr.nextLine();
                String[] batsList = line.split(" ");
                batspos = new int[batsList.length];
                for (int i = 0; i < batsList.length; i++) {
                    batspos[i] = Integer.parseInt(batsList[i]);
                }
            }
        }
        laberynth.setLaberynth(inputLaberynth, wumpuspos, batspos);
        sr.close();
        br.close();
        fr.close();
    }

    public void saveLaberynth(String filename) throws IOException {
        ArrayList<ArrayList<Cell>> outputLaberynth = laberynth.getLaberynth();
        FileWriter fw = new FileWriter("files" + File.separator + filename + ".txt");
        BufferedWriter bw = new BufferedWriter(fw);
        for (int i = 0; i < outputLaberynth.size(); i++) {
            String line = "";
            for (int j = 0; j < outputLaberynth.get(i).size(); j++) {
                if (outputLaberynth.get(i).get(j) instanceof NormalCell) {
                    line += "N ";
                } else if (outputLaberynth.get(i).get(j) instanceof WellCell) {
                    line += "W ";
                } else if (outputLaberynth.get(i).get(j) instanceof PowerUpCell) {
                    line += "P ";
                }
            }
            bw.write(line + "\n");

        }
        bw.close();
        fw.close();
    }
// CALL createNewLaberynth from startGame when loadLaberynth method has noot been called. Avoid Calling it when loadLaberynth is not called
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
            echoes = "";//laberynth.emitEchoes();
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
                    System.out.println("El Wumpus s'ha espantat. Wumpus controller class message");
                } else {
                    System.out.println("el wumpus no s'ha espantat. Wumpus controller class message");
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