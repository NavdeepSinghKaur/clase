package main.java.inscaparrella.model;

import main.java.inscaparrella.utils.CellType;
import main.java.inscaparrella.utils.PowerUp;

import java.util.Random;

public class PowerUpCell extends Cell{
    private PowerUp power;
    private final Random random = new Random();

    public PowerUpCell() {
        super();
        super.ctype = CellType.POWERUP;
        int randomOption = random.nextInt(PowerUp.values().length);
        this.power = PowerUp.values()[randomOption];
    }

    public PowerUpCell(int row, int col) {
        super(row, col);
        super.ctype = CellType.POWERUP;
        createPowerUp();
    }

    public PowerUpCell(PowerUpCell power) {
        super(power);
        super.ctype = CellType.POWERUP;
        this.power = power.power;
    }

    private void createPowerUp() {
        power = PowerUp.values()[random.nextInt(1, 3)];
    }

    public PowerUp consumePowerUp() {
        PowerUp powerUpToReturn = PowerUp.NONE;
        if (super.isOpen()) {
            powerUpToReturn = power;
            power = PowerUp.NONE;
        }

        return powerUpToReturn;
    }

    @Override
    public String emitEcho() {
        String echo = "";
        if (power != PowerUp.NONE ) {
            echo = "\t" + "Clic, clic..." + "\n";
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

        if (power == PowerUp.NONE) {
            returnString += " - Tipus POWERUP";
        } else if (power == PowerUp.ARROW) {
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
           bEquals = super.equals(puc) && power == puc.power;
        }

        return bEquals;
    }
}
