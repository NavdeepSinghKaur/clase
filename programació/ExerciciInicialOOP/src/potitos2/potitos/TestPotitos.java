package potitos2.potitos;

import java.util.Scanner;

public class TestPotitos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = "";
        Apat[] arrApat = new Apat[25];
        int iApats= 0;
        int n;
        while (!line.equals("0")) {
            line = sc.nextLine();
            try {
                n = Integer.parseInt(line);
                if (n > 0) {
                    arrApat[iApats] = new Apat(n);
                    iApats++;
                }
            } catch (NumberFormatException _) {
                Potito p = new Potito(line);
                arrApat[iApats-1].addPotito(p);
                //System.out.println(p);
            }
        }

        for (Apat apat : arrApat) {
            String[] arrPotitosLike;
            String potitosLike = "";
            String potitosDislike = "";
            String[] arrPotitosDislike = new String[0];
            if (apat != null) {
                for (Potito potito : apat.arrPotito) {
                    if (potito.bAgradar) {
                        for (Ingredient ingredient : potito.rgIngredients) {
                            potitosLike += ingredient.getName() + " ";
                        }
                    } else {
                        for (Ingredient ingredient : potito.rgIngredients) {
                            potitosDislike += ingredient.getName() + " ";
                        }
                        arrPotitosDislike = potitosDislike.split(" ");
                    }
                }
                potitosDislike = "";
                arrPotitosLike = potitosLike.split(" ");
                for (String i : arrPotitosDislike) {
                    boolean hasElement = false;
                    for (String j : arrPotitosLike) {
                        if (i.equals(j)) {
                            hasElement = true;
                        }
                    }
                    if (!hasElement) {
                        potitosDislike += i + " ";
                    }
                }
                System.out.println(potitosDislike);
            }
        }
    }
}