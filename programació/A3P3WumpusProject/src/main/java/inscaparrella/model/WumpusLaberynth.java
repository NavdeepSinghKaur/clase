package main.java.inscaparrella.model;

import main.java.inscaparrella.utils.*;

import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Random;

public class WumpusLaberynth {
    ArrayList<ArrayList<Cell>> laberynth;
    int[] ppos;
    int[] wumpuspos;
    int[] batspos;

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
    }

    // Create new laberynth if player doesn't enter one
    public void createNewLaberynth() { // Check for errors later
        Random random = new Random();

        // cell dimensions
        int tableX = random.nextInt(5, 16);
        int tableY = random.nextInt(5, 16);

        int numberOfWellCells = 2;
        int numberOfPowerUpCells = 2;
        int numberOfBats = 4;
        if (tableX*tableY*0.05 > 3) {
            numberOfWellCells = random.nextInt(2, (int)(tableX * tableY * 0.05));
            numberOfPowerUpCells = random.nextInt(2, (int)(tableX * tableY * 0.1));
            numberOfBats = random.nextInt(2, (int)(tableX * tableY * 0.1))*2;
        }

        for (int i = 0; i < tableX; i++) {
            ArrayList<Cell> generatedCells = new ArrayList<>();
            for (int j = 0; j < tableY; j++) {
                if (random.nextBoolean() && numberOfWellCells > 0) {
                    generatedCells.add(new WellCell(i, j));
                    numberOfWellCells--;
                } else if (random.nextBoolean() && numberOfPowerUpCells > 0) {
                    generatedCells.add(new PowerUpCell(i, j));
                    numberOfPowerUpCells--;
                } else {
                    generatedCells.add(new NormalCell(i, j));
                }
            }
            laberynth.add(generatedCells);
        }

        // initialize positions of wumwpus & bats
        int generatedBats = 0;
        int numberOfWumpus = 1;
        for (int i = 0; i < laberynth.size(); i++) {
            for (int j = 0; j < laberynth.getFirst().size(); j++) {
                if (random.nextBoolean() && numberOfBats > 0 && laberynth.get(i).get(j) instanceof NormalCell) {
                    NormalCell habitatnt = (NormalCell) laberynth.get(i).get(j);
                    habitatnt.setInhabitantType(InhabitantType.BAT);
                    numberOfBats--;
                    generatedBats++;
                } else if (random.nextBoolean() && numberOfWumpus > 0 && laberynth.get(i).get(j) instanceof NormalCell) {
                    NormalCell habitatnt = (NormalCell) laberynth.get(i).get(j);
                    wumpuspos = new int[]{i, j};
                    habitatnt.setInhabitantType(InhabitantType.WUMPUS);
                    numberOfWumpus--;
                }
            }
        }

        int batsposXCounter = 0;
        batspos = new int[generatedBats];

        for (int i = 0; i < laberynth.size(); i++) {
            for (int j = 0; j < laberynth.getFirst().size(); j++) {
                if (laberynth.get(i).get(j) instanceof NormalCell nc) {
                    nc = ((NormalCell) laberynth.get(i).get(j));
                    if (nc.getInhabitantType() == InhabitantType.BAT) {
                        if (batsposXCounter % 2 == 0) {
                            batspos[batsposXCounter] = i;
                            batsposXCounter++;
                        } else {
                            batspos[batsposXCounter] = j;
                            batsposXCounter++;
                        }
                    } else if (nc.getInhabitantType() == InhabitantType.WUMPUS) {
                        wumpuspos[0] = i;
                        wumpuspos[1] = j;
                    }
                }
            }
        }
    }

    public int[] getInitialCell() {
        Random random = new Random();
        ppos = null;
        boolean pposCalculated = false;

        if (!laberynth.isEmpty()) {
            for (int i = 0; i < laberynth.size(); i++) {
                for (int j = 0; j < laberynth.getFirst().size(); j++) {
                    if (laberynth.get(i).get(j).getCtype() == CellType.NORMAL) {
                        NormalCell nc = (NormalCell) laberynth.get(i).get(j);
                        if (nc.getInhabitantType() == InhabitantType.NONE && random.nextBoolean() && !pposCalculated) {
                            nc.openCell();
                            ppos = new int[]{i, j};
                            pposCalculated = true;
                        }
                    }
                }
            }
        }
        return ppos;
    }

    public int[] movePlayer(MovementDirection dir) {
        int[] newPosition = ppos;
        if (!laberynth.isEmpty() && ppos != null) {
            if (dir == MovementDirection.LEFT && ppos[1] > 0) {
                ppos[1]--;
                laberynth.get(ppos[0]).get(ppos[1]).openCell();
            } else if (dir == MovementDirection.UP && ppos[0] > 0) {
                ppos[0]--;
                laberynth.get(ppos[0]).get(ppos[1]).openCell();
            }else if (dir == MovementDirection.DOWN && ppos[0] < laberynth.size()-1) {
                ppos[0]++;
                laberynth.get(ppos[0]).get(ppos[1]).openCell();
            } else if (dir == MovementDirection.RIGHT && ppos[1] < laberynth.getFirst().size()-1) {
                ppos[1]++;
                laberynth.get(ppos[0]).get(ppos[1]).openCell();
            }
            newPosition = ppos;
        }
        return newPosition;
    }

    public Danger getDanger() {
        Danger dangerType = Danger.NONE;
        if (!laberynth.isEmpty() && ppos != null) {
            Cell cellPosition = laberynth.get(ppos[0]).get(ppos[1]);
            if (cellPosition instanceof NormalCell nc) {
                InhabitantType htype = nc.getInhabitantType();
                if (htype.equals(InhabitantType.BAT)) {
                    dangerType = Danger.BAT;
                } else if (htype.equals(InhabitantType.WUMPUS)) {
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

    // REQUIRES MORE OPTIMIZATION
    public int[] batKidnapping() {
        Random random = new Random();
        int[] newPosition = new int[2];
        int[] oldPpos = ppos;
        if (!laberynth.isEmpty() && ppos != null) {
            do {
                newPosition = new int[]{random.nextInt(laberynth.size()), random.nextInt(laberynth.getFirst().size())};
                Cell cellType = laberynth.get(newPosition[0]).get(newPosition[1]);
                if (cellType instanceof NormalCell nc && nc.getInhabitantType() == InhabitantType.NONE) {
                    ppos[0] = newPosition[0];
                    ppos[1] = newPosition[1];
                }
            } while (oldPpos[0] != ppos[0] && oldPpos[1] != ppos[1]);
        }
        return newPosition;
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
        boolean validPosition = false;
        if (laberynth != null && ppos != null) {
            Random random = new Random();
            if (random.nextInt() % 2 == 0) {
                while (!validPosition) {
                    int xPosition = random.nextInt(0, laberynth.size());
                    int yPosition = random.nextInt(0, laberynth.getFirst().size());
                    Cell newWumpusPosition = laberynth.get(xPosition).get(yPosition);
                    if (newWumpusPosition instanceof NormalCell
                            && (xPosition != ppos[0] && yPosition != ppos[1])
                            && ((NormalCell) newWumpusPosition).getInhabitantType() == InhabitantType.NONE)
                    {
                            ((NormalCell) laberynth.get(wumpuspos[0]).get(wumpuspos[1])).setInhabitantType(InhabitantType.NONE);
                            wumpuspos = new int[]{xPosition, yPosition};
                            ((NormalCell) newWumpusPosition).setInhabitantType(InhabitantType.WUMPUS);
                            validPosition = true;
                    }
                }
            }
        }

        return validPosition;
    }

    public void moveBats() {
        Random random = new Random();
        int batsposCounter = 0;
        int i = 0;
        if (!laberynth.isEmpty() && ppos != null) {
            while (i < Math.floor((double) batspos.length /2)) {
                int xPosition = random.nextInt(0, laberynth.size());
                int yPosition = random.nextInt(0, laberynth.getFirst().size());
                if (laberynth.get(xPosition).get(yPosition).getCtype().equals(CellType.NORMAL) && !(xPosition == ppos[0] && yPosition == ppos[1])) {
                    NormalCell cell = (NormalCell) laberynth.get(xPosition).get(yPosition);
                    if (cell.getInhabitantType() == InhabitantType.NONE && cell.getCtype() == CellType.NORMAL) {
                        NormalCell batsCell = ((NormalCell) laberynth.get(batspos[batsposCounter]).get(batspos[batsposCounter + 1]));
                        batsCell.setInhabitantType(InhabitantType.NONE);
                        batspos[batsposCounter] = xPosition;
                        batspos[batsposCounter + 1] = yPosition;
                        batsCell = (NormalCell) laberynth.get(batspos[batsposCounter]).get(batspos[batsposCounter + 1]);
                        batsCell.setInhabitantType(InhabitantType.BAT);
                        batsposCounter += 2;
                        i++;
                    }
                }
            }
        }
    }

    public String emitEchoes() {
        /*
        * ERROR WHEN PLAYER GETS TO A BORDER, THE FUNCTION SEES WHAT'S IN THE LEFT AND RIGHT BORDER.
        * AND WHEN FOR EXAMPLE A BRODER IS NOT THERE THE FUNCTION GETS INTO AN INDEX OUT OF BONDS
        * SEE THE NEXT PART FOR EXAMPLE: int j = ppos[1] - 1; j <= ppos[1] + 1; j++
        * * WHERE ppos[1] -1 IS THE PREVIOUS CELL AND ppos[1] + 1 DOESN'T EXIST WHEN THE PLAYER IS IN THE RIGHT BORDER.
        * **/
        String echoes = "";

        if (!laberynth.isEmpty() && ppos != null) {
            for (int i = ppos[0] - 1; i <= ppos[0] + 1; i++) {
                for (int j = ppos[1] - 1; j <= ppos[1] + 1; j++) {
                    if (i <= laberynth.size() - 1 && j <= laberynth.getFirst().size() && i >= 0 && j >= 0 && !(i == ppos[0] && j == ppos[1])) {
                        echoes += "\n" + laberynth.get(i).get(j).emitEcho();
                    }
                }
            }
        }

        return echoes;
    }

    /**
     * NOTE: FOR TESTING PURPOSES ONLY.
     * @return String
     */
    @Override
    public String toString() {
        String stringOutput = "";

        for (int i = 0; i < laberynth.size(); i++) {
            for (int j = 0; j < laberynth.getFirst().size(); j++) {
                boolean alredyFilled = false;
                for (int k = 0; k < batspos.length / 2; k++) {
                    if (batspos[k] == i && batspos[k + 1] == j) {
                        stringOutput += " * ";
                        alredyFilled = true;
                    }
                }
                if (!alredyFilled) {
                    if (i == ppos[0] && j == ppos[1]) {
                        stringOutput += " P ";
                    } else if (laberynth.get(i).get(j).ctype == CellType.WELL) {
                        stringOutput += " O ";
                    } else if (i == wumpuspos[0] && j == wumpuspos[1]) {
                        stringOutput += " W ";
                    } else if (laberynth.get(i).get(j).isOpen()) {
                        stringOutput += "   ";
                    } else if (laberynth.get(i).get(j).ctype == CellType.POWERUP) {
                        stringOutput += " ↑ ";
                    } else {
                        stringOutput += " # ";
                    }
                }
            }
            stringOutput += "\n";
        }

        return stringOutput;
    }
}
