package main.java.inscaparrella.model;

import main.java.inscaparrella.utils.PowerUp;

public class Player {
    private int row;
    private int col;
    private int[] powers;

    public Player() {
        row = -1;
        col = -1;
        powers = new int[]{2, 0};
    }

    public Player(int row, int col) {
        this.row = row;
        this.col = col;
        powers = new int[]{2, 0};
    }

    public void setStartingCell(int row, int col) {
        if (this.row == -1 && this.col == -1) {
            this.row = row;
            this.col = col;
        }
    }

    public void move(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getPowerUpQuantity(PowerUp power) {
        int powerQty = 0;
        if (power.equals(PowerUp.ARROW)) {
            powerQty = powers[0];
        } else if (power.equals(PowerUp.JUMPER_BOOTS)) {
            powerQty = powers[1];
        }

        return powerQty;
    }

    public boolean usePower(PowerUp power) {
        boolean bPowerUsed = false;
        if (power.equals(PowerUp.ARROW) && powers[0] > 0) {
            powers[0]--;
            bPowerUsed = true;
        } else if (power.equals(PowerUp.JUMPER_BOOTS) && powers[0] > 0) {
            powers[1]--;
            bPowerUsed = true;
        }

        return bPowerUsed;
    }

    public void addPower(PowerUp power) {
        if (power == PowerUp.ARROW) {
            powers[0]++;
        } else if (power == PowerUp.JUMPER_BOOTS) {
            powers[1]++;
        }
    }

    @Override
    public String toString() {
        String returnText = "";

        returnText += "Posició del jugador (";
        returnText += row + ", " + col + ")" + "\n";
        returnText += "\t" + "ARROW: " + powers[0] + "\n";
        returnText += "\t" + "JUMPER_BOOTS: " + powers[1];

        return returnText + "\n";
    }
}
