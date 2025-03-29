package main.java.inscaparrella.model;

import main.java.inscaparrella.utils.*;

import java.util.ArrayList;
import java.util.Random;

public class WumpusLaberynth {
    ArrayList<ArrayList<Cell>> laberynth;
    int[] ppos;
    int[] wumpuspos;
    int[] batspos;
    private final Random random = new Random(); // Random generator used by methods

    public WumpusLaberynth() {
        laberynth = new ArrayList<>();
        ppos = null;
        wumpuspos = null;
        batspos = null;
    }

    //GETTERS & SETTERS
    public ArrayList<ArrayList<Cell>> getLaberynth() {
        ArrayList<ArrayList<Cell>> cells = new ArrayList<>();
        for(ArrayList<Cell> row : laberynth) {
            ArrayList<Cell> i = new ArrayList<>();
            for (Cell cell : row) {
                if (cell instanceof NormalCell) {
                    i.add(new NormalCell((NormalCell) cell));
                } else if (cell instanceof PowerUpCell) {
                    i.add(new PowerUpCell((PowerUpCell) cell));
                } else if (cell instanceof WellCell) {
                    i.add(new WellCell((WellCell) cell));
                }
            }
            cells.add(i);
        }
        return cells;
    }

    public void setLaberynth(ArrayList<ArrayList<Cell>> laberynth, int[] wumpuspos, int[] batspos) {
        this.wumpuspos = wumpuspos;
        this.batspos = batspos;


        for (int i = 0; i < laberynth.size(); i++) {
            ArrayList<Cell> laberynthRow = new ArrayList<>();
            for (int j = 0; j < laberynth.get(i).size(); j++) {
                Cell cell = laberynth.get(i).get(j);
                if (cell instanceof NormalCell nc) {
                    laberynthRow.add(new NormalCell(nc));
                } else if (cell instanceof PowerUpCell pc) {
                    laberynthRow.add(new PowerUpCell(pc));
                } else if (cell instanceof WellCell wc) {
                    laberynthRow.add(new WellCell(wc));
                }
            }
            this.laberynth.add(laberynthRow);
        }

        for (int i = 0; i < this.batspos.length; i+=2) {
            ((NormalCell)this.laberynth.get(batspos[i]).get(batspos[i+1])).setInhabitantType(InhabitantType.BAT);
        }

        ((NormalCell)this.laberynth.get(this.wumpuspos[0]).get(this.wumpuspos[1])).setInhabitantType(InhabitantType.WUMPUS);
    }

    // Create new laberynth if player doesn't enter one
    public void createNewLaberynth() {

        // cell dimensions
        int tableX = random.nextInt(5, 16);
        int tableY = random.nextInt(5, 16);

        // calculate num of cells and bats
        int numberOfWellCells = 2;
        int numberOfPowerUpCells = 2;
        int numberOfBats = 4;
        int tableSize = tableX*tableY;

        if (tableSize > 60) {
            numberOfWellCells = random.nextInt(2, (int)(tableSize * 0.05));
        }
        if (tableSize > 20) {
            numberOfPowerUpCells = random.nextInt(2, (int)(tableSize * 0.1));
            numberOfBats = random.nextInt(2, (int)(tableSize * 0.1))*2;
        }


        for (int i = 0; i < tableX; i++) {
            ArrayList<Cell> generatedCells = new ArrayList<>();
            for (int j = 0; j < tableY; j++) {
                int num = random.nextInt(7);
                if (num == 0 && numberOfWellCells > 0) {
                    generatedCells.add(new WellCell(i, j));
                    numberOfWellCells--;
                } else if (num == 1 && numberOfPowerUpCells > 0) {
                    generatedCells.add(new PowerUpCell(i, j));
                    numberOfPowerUpCells--;
                } else {
                    generatedCells.add(new NormalCell(i, j));
                }
            }
            laberynth.add(generatedCells);
        }
        initializeBatspos(numberOfBats);
        initializeWumpus();
    }


    public int[] getInitialCell() {
        ppos = null;
        boolean bPposCalculated = false;
        int playerXPos = random.nextInt(0, laberynth.size());
        int playerYPos = random.nextInt(0, laberynth.getFirst().size());

        if (!laberynth.isEmpty()) {
            while (!bPposCalculated) {
                if (laberynth.get(playerXPos).get(playerYPos) instanceof NormalCell nc &&
                    nc.getInhabitantType() == InhabitantType.NONE)
                {
                    nc.openCell();
                    ppos = new int[]{playerXPos, playerYPos};
                    bPposCalculated = true;
                } else {
                    playerXPos = random.nextInt(0, laberynth.size());
                    playerYPos = random.nextInt(0, laberynth.getFirst().size());
                }
            }
        }
        return ppos;
    }

    public int[] movePlayer(MovementDirection dir) {

        if (!laberynth.isEmpty() && ppos != null) {
            int[] newPosition = {ppos[0], ppos[1]};
            int[][] positions = {{-1, 0}, {1, 0}, {0, -1},  {0, 1}};

            switch (dir) {
                case LEFT:
                    newPosition[0] = ppos[0] + positions[2][0];
                    newPosition[1] = ppos[1] + positions[2][1];
                    break;
                case UP:
                    newPosition[0] = ppos[0] + positions[0][0];
                    newPosition[1] = ppos[1] + positions[0][1];
                    break;
                case DOWN:
                    newPosition[0] = ppos[0] + positions[1][0];
                    newPosition[1] = ppos[1] + positions[1][1];
                    break;
                case RIGHT:
                    newPosition[0] = ppos[0] + positions[3][0];
                    newPosition[1] = ppos[1] + positions[3][1];
                    break;
            }

            if (checkCorrectCell(newPosition[0], newPosition[1]))
            {
                ppos[0] = newPosition[0];
                ppos[1] = newPosition[1];
                laberynth.get(ppos[0]).get(ppos[1]).openCell();
            }
        }
        return ppos;
    }

    public Danger getDanger() {
        Danger dangerType = Danger.NONE;

        if (!laberynth.isEmpty() && ppos != null) {
            Cell cellPosition = laberynth.get(ppos[0]).get(ppos[1]);

            if (cellPosition instanceof NormalCell nc) {
                InhabitantType htype = nc.getInhabitantType();

                if (htype == InhabitantType.BAT) {
                    dangerType = Danger.BAT;
                } else if (htype == InhabitantType.WUMPUS) {
                    dangerType = Danger.WUMPUS;
                }

            } else if (cellPosition instanceof WellCell) {
                dangerType = Danger.WELL;
            }
        }
        return dangerType;
    }

    public PowerUp getPowerUp() {
        PowerUp cellPowerUp = PowerUp.NONE;

        if (!this.laberynth.isEmpty() && this.ppos != null
            && this.laberynth.get(this.ppos[0]).get(this.ppos[1]) instanceof PowerUpCell) {
            cellPowerUp = ((PowerUpCell) this.laberynth.get(this.ppos[0]).get(this.ppos[1])).consumePowerUp();
        }

        return cellPowerUp;
    }

    public int[] batKidnapping() {
        boolean bValidPosition = false;
        int[] newPosition = new int[2];

        if (!laberynth.isEmpty() && ppos != null) {
            while (!bValidPosition && !(newPosition[0] == ppos[0] && newPosition[1] == ppos[1])) {
                newPosition = new int[]{random.nextInt(laberynth.size()), random.nextInt(laberynth.getFirst().size())};
                Cell cellType = laberynth.get(newPosition[0]).get(newPosition[1]);

                if (cellType instanceof NormalCell nc && nc.getInhabitantType() == InhabitantType.NONE) {
                    laberynth.get(newPosition[0]).get(newPosition[1]).openCell();
                    bValidPosition = true;
                    ppos = newPosition;
                }
            }
        }
        return ppos;
    }

    public boolean shootArrow(ShootDirection dir) {
        boolean returnValue = false;

        if (ppos != null) {
            switch (dir) {
                case LEFT:
                    returnValue = ((!(ppos[1] == 0)) && (wumpuspos[0] == ppos[0] && wumpuspos[1] == ppos[1] - 1));
                    break;
                case RIGHT:
                    returnValue = (!(ppos[1] == laberynth.getFirst().size()) && (wumpuspos[0] == ppos[0] && wumpuspos[1] == ppos[1]+1));
                    break;
                case UP:
                    returnValue = (!(ppos[0] == 0) && (wumpuspos[0] == ppos[0]-1 && wumpuspos[1] == ppos[1]));
                    break;
                case DOWN:
                    returnValue = (!(ppos[0] == laberynth.size()) && (wumpuspos[0] == ppos[0]+1 && wumpuspos[1] == ppos[1]));
                    break;
            }
        }
        return returnValue;
    }

    public boolean startleWumpus() {
        boolean bLegalPosition = false;

        if (laberynth != null && ppos != null && random.nextBoolean()) {
            while (!bLegalPosition) {
                int xPosition = random.nextInt(0, laberynth.size());
                int yPosition = random.nextInt(0, laberynth.getFirst().size());
                Cell position = laberynth.get(xPosition).get(yPosition);

                if (position instanceof NormalCell nc
                    && nc.getInhabitantType() == InhabitantType.NONE
                    && (xPosition != ppos[0] && yPosition != ppos[1])
                )
                {
                    ((NormalCell) laberynth.get(wumpuspos[0]).get(wumpuspos[1])).setInhabitantType(InhabitantType.NONE);
                    wumpuspos = new int[]{xPosition, yPosition};
                    nc.setInhabitantType(InhabitantType.WUMPUS);
                    bLegalPosition = true;
                }
            }
        }

        return bLegalPosition;
    }

    public void moveBats() {
        int cBatspos = 0;
        int i = 0;

        if (!laberynth.isEmpty() && ppos != null) {
            while (i < batspos.length/2) {
                int xPosition = random.nextInt(0, laberynth.size());
                int yPosition = random.nextInt(0, laberynth.getFirst().size());

                if (laberynth.get(xPosition).get(yPosition) instanceof NormalCell nc
                    && nc.getInhabitantType() == InhabitantType.NONE
                    && !(xPosition == ppos[0] && yPosition == ppos[1]))
                {
                    NormalCell batsCell = (NormalCell) laberynth.get(batspos[cBatspos]).get(batspos[cBatspos + 1]);
                    batsCell.setInhabitantType(InhabitantType.NONE);
                    batspos[cBatspos] = xPosition;
                    batspos[cBatspos + 1] = yPosition;
                    batsCell = (NormalCell) laberynth.get(batspos[cBatspos]).get(batspos[cBatspos + 1]);
                    batsCell.setInhabitantType(InhabitantType.BAT);
                    cBatspos += 2;
                    i++;
                }
            }
        }
    }

    public String emitEchoes() {
        String echoes = "";
        if (!laberynth.isEmpty() && ppos != null) {
            int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1},};

            for (int[] dir : dirs) {
                int row = ppos[0] + dir[0];
                int col = ppos[1] + dir[1];

                if (checkCorrectCell(row, col)) {
                    echoes += laberynth.get(row).get(col).emitEcho();
                }
            }
        }
            return echoes;
    }

    @Override
    public String toString() {
        String stringOutput = "";
        stringOutput += "CEL·LA ACTUAL:" + "\n";
        stringOutput += "\t" + laberynth.get(ppos[0]).get(ppos[1]).toString() + "\n\n";

        for (int i = 0; i < laberynth.size(); i++) {
            if (i == 0) {
                stringOutput += "   ";
                for (int k = 0; k < laberynth.getFirst().size(); k++) {
                    if (k >= 10) {
                        stringOutput += k + " ";
                    } else {
                        stringOutput += "0" + k + " ";
                    }
                    }
                stringOutput += "\n";
            }
            for (int j = 0; j < laberynth.getFirst().size(); j++) {
                    if (j == 0) {
                        if (i > 9) {
                            stringOutput += i + " ";
                        } else {
                            stringOutput += "0" + i + " ";
                        }
                    }
                    if (laberynth.get(i).get(j) instanceof NormalCell nc && nc.getInhabitantType() == InhabitantType.BAT) {
                        stringOutput += ConsoleColors.GREEN_BOLD + " * " + ConsoleColors.RESET;
                    } else if (i == ppos[0] && j == ppos[1]) {
                        stringOutput += ConsoleColors.CYAN + " P " + ConsoleColors.RESET;
                    } else if (laberynth.get(i).get(j).isOpen()) {
                        stringOutput += "   ";
                    } else {
                        stringOutput += ConsoleColors.PURPLE + " # " + ConsoleColors.RESET;
                    }
                }
            stringOutput += "\n";
        }
        return stringOutput;
    }

    private boolean checkCorrectCell(int row, int col) {
        return row < laberynth.size() && row >= 0 &&
                col >= 0 && col < laberynth.getFirst().size();
    }

    // Initializes the position of every bat
    private void initializeBatspos(int numberOfBats) {
        if (!laberynth.isEmpty()) {
            batspos = new int[numberOfBats];

            while (numberOfBats > 0) {
                int[] positions = {random.nextInt(laberynth.size()), random.nextInt(laberynth.getFirst().size())};
                if (laberynth.get(positions[0]).get(positions[1]) instanceof NormalCell nc &&
                        nc.getInhabitantType() == InhabitantType.NONE) {
                    batspos[(batspos.length) - numberOfBats] = positions[0];
                    batspos[(batspos.length) - numberOfBats + 1] = positions[1];
                    nc.setInhabitantType(InhabitantType.BAT);
                    numberOfBats -= 2;
                }
            }
        }
    }

    // Initializes the position of the wumpus
    private void initializeWumpus() {
        boolean bWumpusposCalculated = false;
        if (!laberynth.isEmpty() && wumpuspos == null) {
            int[] positions = {random.nextInt(laberynth.size()), random.nextInt(laberynth.getFirst().size())};

            while (!bWumpusposCalculated) {
                if (laberynth.get(positions[0]).get(positions[1]) instanceof NormalCell nc &&
                        nc.getInhabitantType() == InhabitantType.NONE)
                {
                    wumpuspos = positions;
                    nc.setInhabitantType(InhabitantType.WUMPUS);
                    bWumpusposCalculated = true;
                }
            }
        }
    }
}