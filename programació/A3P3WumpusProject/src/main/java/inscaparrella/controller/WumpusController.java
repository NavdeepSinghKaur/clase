package main.java.inscaparrella.controller;

import main.java.inscaparrella.model.*;
import main.java.inscaparrella.utils.Danger;
import main.java.inscaparrella.utils.MovementDirection;
import main.java.inscaparrella.utils.PowerUp;
import main.java.inscaparrella.utils.ShootDirection;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class WumpusController {
    private WumpusLaberynth laberynth;
    private Player player;
    private String traverseMessage;
    private String echoes;
    private boolean gameEnded;
    private boolean won;
    private boolean bUserLoadLaberynth = false;

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
                    switch (lineElements[i]) {
                        case "N": inputLaberynthRows.add(new NormalCell(counter, i));
                            break;
                        case "P": inputLaberynthRows.add(new PowerUpCell(counter, i));
                            break;
                        case "W": inputLaberynthRows.add(new WellCell(counter, i));
                            break;
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
        bUserLoadLaberynth = true;
    }

    public void saveLaberynth(String filename) throws IOException {
        ArrayList<ArrayList<Cell>> outputLaberynth = laberynth.getLaberynth();
        FileWriter fw = new FileWriter("files" + File.separator + filename + ".txt");
        BufferedWriter bw = new BufferedWriter(fw);
        for (ArrayList<Cell> cells : outputLaberynth) {
            String line = "";
            for (Cell cell : cells) {
                if (cell instanceof NormalCell) {
                    line += "N ";
                } else if (cell instanceof WellCell) {
                    line += "W ";
                } else if (cell instanceof PowerUpCell) {
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

        if (!bUserLoadLaberynth) {
            laberynth.createNewLaberynth();
        }

        playerPosition = laberynth.getInitialCell();
        traverseCell();
        if (playerPosition != null) {
            won = false;
            player.setStartingCell(playerPosition[0], playerPosition[1]);
            echoes = laberynth.emitEchoes();
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

    public void huntTheWumpus(ShootDirection dir) {
        if (!gameEnded && player.getPowerUpQuantity(PowerUp.ARROW) > 0 && player.usePower(PowerUp.ARROW)) {
            if (laberynth.shootArrow(dir)){
                won = true;
                gameEnded = true;
            } else {
                laberynth.startleWumpus();
            }
        }
    }

    // Getters
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
        returnText += "ECOS:" + "\n";
        returnText += getLastTraverseMessage();
        returnText += getLastEchoes() + "\n";
        returnText += player.toString() + "\n";
        returnText += laberynth.toString();

        return returnText;
    }

    private void traverseCell() {
        if (laberynth.getDanger() == Danger.WUMPUS) {
            won = false;
            gameEnded = true;
            traverseMessage += "\t" + "El Wumpus ha atacat i malferit al jugador!" + "\n";
        }
        if (laberynth.getDanger() == Danger.WELL) {
            if ( player.getPowerUpQuantity(PowerUp.JUMPER_BOOTS) < 1) {
                won = false;
                gameEnded = true;
                traverseMessage += "\t" + "El jugador ha caigut en un pou i ha quedat malferit!" + "\n";
            } else {
                player.usePower(PowerUp.JUMPER_BOOTS);
                traverseMessage += "\t" + "El jugador ha estat a punt de caure en un pou, però, per sort, portava les JUMPER BOOTS" + "\n";
            }
        }
        if (laberynth.getDanger() == Danger.BAT) {
            int[] newPosition = laberynth.batKidnapping();
            player.move(newPosition[0], newPosition[1]);
            traverseMessage += "\t" + "Un ratpenat s’enduu el jugador!" + "\n";
            traverseCell();
        }
        PowerUp powerType = laberynth.getPowerUp();
        if (powerType != PowerUp.NONE) {
            player.addPower(powerType);
            if (powerType.equals(PowerUp.ARROW)) {
                traverseMessage += "\t" + "El jugador ha trobat una unitat del poder ARROW" + "\n";
            } else {
                traverseMessage += "\t" + "El jugador ha trobat una unitat del poder JUMPER_BOOTS" + "\n";
            }
        }
    }
}