package main.java.inscaparrella.controller;

import main.java.inscaparrella.model.Cell;
import main.java.inscaparrella.model.Player;
import main.java.inscaparrella.model.WumpusLaberynth;
import main.java.inscaparrella.utils.Danger;
import main.java.inscaparrella.utils.MovementDirection;
import main.java.inscaparrella.utils.PowerUp;
import main.java.inscaparrella.utils.ShootDirection;

import java.util.ArrayList;

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

    public void loadLaberynth(String filename) {

    }

    public void saveLaberynth() {

    }

    public boolean startGame() {
        int[] playerPosition;
        boolean bGameStarted = false;
        // TEMPORATY INSTALL
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
        returnText += player.toString();
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
    }
}
