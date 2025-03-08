package main.java.inscaparrella.model;

import main.java.inscaparrella.utils.PowerUp;

import java.util.Arrays;
import java.util.Random;

public class PowerUpCell extends Cell{
    private PowerUp power;
    private Random random = new Random();

    public PowerUpCell() {
        super();
        int randomOption = random.nextInt(PowerUp.values().length);
        this.power = PowerUp.values()[randomOption];
    }

    public PowerUpCell(int row, int col) {
        super(row, col);
        int randomOption = random.nextInt(PowerUp.values().length);
        this.power = PowerUp.values()[randomOption];
    }

    public PowerUpCell(PowerUpCell power) { // Is this a more correct way to create a copy constructor (deep copying)
        super(power);
        this.power = power.power;
    }

    private void createPowerUp() {
        this.power = PowerUp.values()[random.nextInt(1, 3)];
    }

    public PowerUp consumePowerUp() {
        PowerUp powerUpToReturn = PowerUp.NONE;
        if (super.isOpen()) {
            powerUpToReturn = this.power;
            this.power = PowerUp.NONE;
        }

        return powerUpToReturn;
    }

    @Override
    public String emitEcho() {
        String echo = "";
        if (this.power != PowerUp.NONE ) {
            echo = "Clic, clic...";
        }

        return echo;
    }

    @Override
    public boolean isDangerous() {
        return false;
    }

    @Override
    public String toString() {
        String returnString = super.toString();

        if (this.power == PowerUp.NONE) {
            returnString += " - Tipus POWERUP";
        } else if (this.power == PowerUp.ARROW) {
            returnString += " - Tipus POWERUP (concedeix el poder ARROW)";
        } else {
            returnString += " - Tipus POWERUP (concedeix el poder JUMPER BOOTS)";
        }

        return returnString;
    }

    @Override
    public boolean equals(Object obj) {
        boolean bEquals = false;

        if (obj instanceof PowerUpCell puc) {
           bEquals = super.equals(puc) && this.power == puc.power;
        }

        return bEquals;
    }
}
