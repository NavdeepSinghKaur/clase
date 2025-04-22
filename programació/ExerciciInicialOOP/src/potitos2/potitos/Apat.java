package potitos2.potitos;

public class Apat {
    private int nPotitos;

    Potito[] arrPotito;

    public Apat(int nPotitos) {
        this.nPotitos = nPotitos;
        this.arrPotito = new Potito[nPotitos];
    }

    public boolean addPotito(Potito p) {
        int i = 0;
        while (arrPotito[i] != null && i < nPotitos) {
            i++;
        }

        if (i == nPotitos) return false;
        else {
            arrPotito[i] = p;
            return true;
        }
    }

}