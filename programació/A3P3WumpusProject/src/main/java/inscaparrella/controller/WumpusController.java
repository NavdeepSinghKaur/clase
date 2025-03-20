package main.java.inscaparrella.controller;

import main.java.inscaparrella.model.Cell;
import main.java.inscaparrella.model.Player;
import main.java.inscaparrella.model.WumpusLaberynth;
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
        boolean bGameStarted = false;
        // TEMPORATY INSTALL
        gameEnded = false;
        laberynth.createNewLaberynth();
        if (laberynth.getInitialCell() != null) {
            won = false;
            player.setStartingCell(0, 0);
            echoes = getLastEchoes();
            traverseMessage = "";
            bGameStarted = true;
        }
        return bGameStarted;
    }

    public void movePlayer(MovementDirection dir) {
        if (!gameEnded) {
            laberynth.movePlayer(dir);
            if (!gameEnded) {
                laberynth.moveBats();
            }
        }
    }

    public void huntTheWumpus(ShootDirection dir) {
        if (!gameEnded && player.getPowerUpQuantity(PowerUp.ARROW) > 0) {
            if (laberynth.shootArrow(dir)){
                won = true;
                gameEnded = true;
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
        return laberynth.toString();
    }
}
