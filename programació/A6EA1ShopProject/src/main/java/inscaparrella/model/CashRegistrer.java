package main.java.inscaparrella.model;

import java.util.Objects;
import java.util.Random;

public class CashRegistrer {
    private static final float ERROR_PERCENTAGE = 0.01F;
    private float initialCash;
    private float inCash;
    private float outCash;
    private float currentCash;

    public CashRegistrer() {
        this.initialCash = 3000f;
        this.inCash = 0f;
        this.outCash = 0f;
        this.currentCash = 0f;
    }

    @Override
    public boolean equals(Object obj) {
        boolean bEquals = false;
        if (obj instanceof CashRegistrer) {
            CashRegistrer cr = (CashRegistrer) obj;
            bEquals = Float.compare(this.initialCash, cr.initialCash) == 0
                   && Float.compare(this.inCash, cr.inCash) == 0
                   && Float.compare(this.outCash, cr.outCash) == 0
                   && Float.compare(this.currentCash, cr.currentCash) == 0;
        }
        return bEquals;
    }

    @Override
    public int hashCode() {
        return Objects.hash(initialCash, inCash, outCash, currentCash);
    }

    @Override
    public String toString() {
        return "CashRegistrer{" +
                "initialCash=" + initialCash +
                ", inCash=" + inCash +
                ", outCash=" + outCash +
                ", currentCash=" + currentCash +
                '}';
    }

    public void manageSale(float value) {
        Random random = new Random();
        int randomValue = random.nextInt(1, 101);
        if (randomValue%2 != 0) {
            if (random.nextBoolean()) {
                value += value * ERROR_PERCENTAGE;
            } else {
                value -= value * ERROR_PERCENTAGE;
            }
        }
        this.inCash += value;
        this.currentCash += value;
    }

    public void managePurchase(float value) {
        Random random = new Random();
        int randomValue = random.nextInt(1, 101);
        if (randomValue%2 != 0) {
            if (random.nextBoolean()) {
                value += value * ERROR_PERCENTAGE;
            } else {
                value -= value * ERROR_PERCENTAGE;
            }
        }
            this.outCash += value;
            this.currentCash -= value;
    }

    public float closeCash() { //??????
        return this.initialCash + this.inCash - this.outCash;
    }
}
