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
            }
        }

        for (int i = 0; i < arrApat.length; i++) {
            if (arrApat[i] != null) {
                System.out.println(arrApat[i].arrPotito);
            }
        }
    }
}