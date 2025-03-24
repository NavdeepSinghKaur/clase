package potitos;

import java.util.Scanner;

public class TestPotitos {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String line = "";
        Apat[] arrApat = new Apat[25];
        int iApats= 0;
        int n;
        int i = 0;
        while (!line.equals("0")) {
            line = sc.nextLine();
            try {
                n = Integer.parseInt(line);
                if (n > 0) {
                    arrApat[iApats] = new Apat(n);
                    iApats++;
                    i=0;

                }
            } catch (NumberFormatException _) {
                System.out.println("Apat " + iApats + " " + arrApat[iApats-1]);
                Potito p = new Potito(line);
                System.out.println(p);
                arrApat[iApats-1].arrPotito[i]=p;
                i++;
            }
        }

        /*for (Apat a: arrApat) {
            System.out.println(a.toString());
        }*/

        System.out.println(arrApat[1].arrPotito[0].rgIngredients[2]);
    }
}