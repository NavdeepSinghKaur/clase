package potitos2.potitos;

import java.util.Arrays;

public class Potito {
    boolean bAgradar;

    Ingredient[] rgIngredients;

    public Potito(String line) {
        String[] rg = line.split(" ");

        bAgradar = rg[0].equals("SI:");

        rgIngredients = new Ingredient[rg.length-2];

        for (int i=1; i < rg.length -1; i++) {
            rgIngredients[i-1] = new Ingredient(rg[i]);
        }
    }

    @Override
    public String toString() {
        return "Potito{" +
                "bAgradar=" + bAgradar +
                ", rgIngredients=" + Arrays.toString(rgIngredients) +
                '}';
    }
}