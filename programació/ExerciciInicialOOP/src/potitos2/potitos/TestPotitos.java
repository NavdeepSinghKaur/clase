package potitos2.potitos;

import java.util.Scanner;

public class TestPotitos {
    public static void main(String[] args){
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
                System.out.println("Apat " + iApats + " " + arrApat[iApats-1]);
                System.out.println(arrApat);
                Potito p = new Potito(line);
                System.out.println(p);
                System.out.println(arrApat[iApats-1].addPotito(p));
            }
        }

        System.out.println(arrApat[1].arrPotito[0].rgIngredients[2]);
        System.out.println(arrApat.);
    }
}