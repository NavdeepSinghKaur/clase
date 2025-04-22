package recursivity;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;

public class BacktrackingExercici1 {
    public static void main(String[] args) {
        File f = new File("results/knight.txt");

        try {
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);

            int[][] table = new int[8][8];
            table[0][0] = 1;
            int[] knight = {0, 0};
            int counter = 2;

            while (counter < 64) {
                moveKnight(table, knight[0], knight[1], counter);
                counter++;
            }

            fileWriter(table, bw);

        } catch (Exception _) {}

    }
    final static int[][] validMovements = {
            {2, 1},
            {1, 2},
            {-1, 2},
            {-2, 1},
            {-2,-1},
            {-1,-2},
            {1, -2},
            {2, -1}
    };

    private static void fileWriter(int[][] table, BufferedWriter bw) throws IOException {
        for (int[] line : table) {
            for (int i : line) {
                if (i > 9) {
                    bw.write(i + " ");
                } else {
                    bw.write(" " + i + " ");
                }
            }
            bw.newLine();
            bw.flush();
        }
    }

    private static boolean moveKnight(int[][] table, int row, int col, int counter) {
        if (counter > table.length*table.length) {
            return true;
        }
        for (int[] movement : validMovements) {
            int[] newMovmeent = {row + movement[0], col + movement[1]};
            if (newMovmeent[0] >= 0 && newMovmeent[0] <= 7 && newMovmeent[1] >= 0 && newMovmeent[1] <= 7 && table[newMovmeent[0]][newMovmeent[1]] == 0) {
                table[newMovmeent[0]][newMovmeent[1]] = counter;
                if (moveKnight(table, newMovmeent[0], newMovmeent[1], counter + 1)) {
                    return true;
                }
                table[newMovmeent[0]][newMovmeent[1]] = 0;
            }
        }

        return false;
    }

}
