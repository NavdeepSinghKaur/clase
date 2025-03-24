package potitos;

import java.util.Arrays;

public class Apat {
    private int nPotitos;

    Potito[] arrPotito;

    public Apat(int nPotitos) {
        this.nPotitos = nPotitos;
        this.arrPotito = new Potito[nPotitos];
    }

    @Override
    public String toString() {
        return "Apat{" +
                "nPotitos=" + nPotitos +
                ", arrPotito=" + arrPotito +
                '}';
    }
}