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
        ArrayList<ArrayList<Cell>> cell = new ArrayList<>();
        for(ArrayList<Cell> row : laberynth) {
            ArrayList<Cell> i = new ArrayList<>();
            for (Cell cell1 : row) {
                if (cell1 instanceof NormalCell) {
                    i.add(new NormalCell((NormalCell) cell1));
                } else if (cell1 instanceof PowerUpCell) {
                    i.add(new PowerUpCell((PowerUpCell) cell1));
                } else if (cell1 instanceof WellCell) {
                    i.add(new WellCell((WellCell) cell1));
                }
            }
            cell.add(i);
        }
        return cell;
    }

//    public void setLaberynth(ArrayList<ArrayList<Cell>> laberynth) { // CHECK <-----
//        Random random = new Random();
//        int normalCellCounter = 0;
//        this.generatedLaberynth = new ArrayList<>();
//        wumpuspos = new int[2];
//
//        for (ArrayList<Cell> row : laberynth) {
//            ArrayList<Cell> tempArray = new ArrayList<>();
//            for (Cell cell : row) {
//                if (cell instanceof NormalCell) {
//                    tempArray.add(new NormalCell((NormalCell) cell));
//                    normalCellCounter++;
//                } else if (cell instanceof PowerUpCell) {
//                    tempArray.add(new PowerUpCell((PowerUpCell) cell));
//                } else if (cell instanceof WellCell) {
//                    tempArray.add(new WellCell((WellCell) cell));
//                }
//            }
//            this.generatedLaberynth.add(tempArray);
//        }
//
//        batspos = new int[random.nextInt(4, normalCellCounter*2)];
//    }

    public void createNewLaberynth() { // Check for errors later
        Random random = new Random();

        // cell dimensions
        int tableX = random.nextInt(5, 16);
        int tableY = random.nextInt(5, 16);

        int numberOfWellCells = random.nextInt(2, tableX*tableY);
        int numberOfPowerUpCells = random.nextInt(2, tableX*tableY);

        int normalCellNum = 0;

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
                    normalCellNum++;
                }
            }
            laberynth.add(generatedCells);
        }

        // initialize positions of wumpuspus & batspos
        int numberOfBats = random.nextInt(4, normalCellNum*2);
        int generatedBats = 0;
        int numberOfWumpus = 1;
        for (ArrayList<Cell> cells : laberynth) {
            for (Cell cell : cells) {
                if (random.nextBoolean() && numberOfBats > 0) {
                    NormalCell habitatnt = (NormalCell) cell;
                    habitatnt.setInhabitantType(InhabitantType.BAT);
                    numberOfBats--;
                    generatedBats++;
                } else if (random.nextBoolean() && numberOfWumpus > 0) {
                    NormalCell habitatnt = (NormalCell) cell;
                    habitatnt.setInhabitantType(InhabitantType.WUMPUS);
                    numberOfWumpus--;
                }
            }
        }

        int batsposXCounter = 0;
        batspos = new int[generatedBats];

        for (int i = 0; i < laberynth.size(); i++) {
            for (int j = 0; j < laberynth.getFirst().size(); j++) {
                if (laberynth.get(i).get(j) instanceof NormalCell) {
                    NormalCell nc = ((NormalCell) laberynth.get(i).get(j));
                    if (nc.getInhabitantType() == InhabitantType.BAT) {
                        batspos[batsposXCounter] = i;
                        batspos[batsposXCounter+1] = j;
                        batsposXCounter++;
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

        if (!this.laberynth.isEmpty()) {
            for (int i = 0; i < this.laberynth.size(); i++) {
                for (int j = 0; j < this.laberynth.getFirst().size(); j++) {
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
        int[] newPosition = null;
        if (!this.laberynth.isEmpty()) {
            if (this.ppos != null) {
                if (dir == MovementDirection.LEFT && !(this.ppos[1] == 0)) {
                    this.ppos[1]--;
                    newPosition = ppos;
                } else if (dir == MovementDirection.UP && !(this.ppos[0] == 0)) {
                    this.ppos[0]--;
                    newPosition = ppos;
                }else if (dir == MovementDirection.DOWN && !(this.ppos[0] == laberynth.size())) {
                    this.ppos[0]++;
                    newPosition = ppos;
                } else if (dir == MovementDirection.RIGHT && !(this.ppos[1] == laberynth.getFirst().size())) {
                    this.ppos[1]++;
                    newPosition = ppos;
                }
            }
        }
        return newPosition;
    }

    public Danger getDanger() {
        Danger dangerType = Danger.NONE;
        if (!laberynth.isEmpty() && ppos != null) {
            Cell cellPosition = laberynth.get(ppos[0]).get(ppos[1]);
            if (cellPosition instanceof NormalCell) {
                NormalCell nc = (NormalCell) cellPosition;
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

    public int[] batKidnapping() {
        Random random = new Random();
        int[] newPosition = null;
        if (!laberynth.isEmpty() && ppos != null) {
            Cell cellType = laberynth.get(ppos[0]).get(ppos[1]);
            if (cellType instanceof NormalCell) {
                NormalCell nc = (NormalCell) cellType;
                newPosition = new int[]{random.nextInt(laberynth.size()), random.nextInt(laberynth.getFirst().size())};
                while (newPosition[0] != ppos[0] && newPosition[1] != ppos[1]) {
                    newPosition = new int[]{random.nextInt(laberynth.size()), random.nextInt(laberynth.getFirst().size())};
                }
                ppos[0] = newPosition[0];
                ppos[1] = newPosition[1];
            }
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
                    int[] coordinates = new int[]{random.nextInt(laberynth.size()), random.nextInt(laberynth.getFirst().size())};
                    Cell newWumpusPosition = laberynth.get(coordinates[0]).get(coordinates[1]);
                    if (newWumpusPosition instanceof NormalCell
                            && (coordinates[0] != ppos[0] && coordinates[1] != ppos[1]))
                    {
                        if (((NormalCell) newWumpusPosition).getInhabitantType() == InhabitantType.NONE) {
                            ((NormalCell) laberynth.get(wumpuspos[0]).get(wumpuspos[1])).setInhabitantType(InhabitantType.NONE);
                            wumpuspos = coordinates;
                            validPosition = true;
                            ((NormalCell) newWumpusPosition).setInhabitantType(InhabitantType.WUMPUS);
                        }
                    }
                }
            }
        }

        return validPosition;
    }

    public void moveBats() {
        Random random = new Random();
        int batsposCounter = 0;
        int batsLength = batspos.length/2;
        int i = 0;
        if (!laberynth.isEmpty()) {
            while (i < batsLength) {
                int xPosition = random.nextInt(0, laberynth.size());
                int yPosition = random.nextInt(0, laberynth.getFirst().size());
                if (laberynth.get(xPosition).get(yPosition).getCtype() == CellType.NORMAL && !(xPosition == ppos[0] && yPosition == ppos[1])) {
                    NormalCell cell = (NormalCell) laberynth.get(xPosition).get(yPosition);
                    if (cell.getInhabitantType() == InhabitantType.NONE) {
                        NormalCell batsCell = (NormalCell) laberynth.get(batspos[batsposCounter]).get(batsposCounter + 1);
                        batsCell.setInhabitantType(InhabitantType.NONE);
                        batspos[batsposCounter] = xPosition;
                        batspos[batsposCounter + 1] = yPosition;
                        batsCell = (NormalCell) laberynth.get(batspos[batsposCounter]).get(batsposCounter + 1);
                        batsCell.setInhabitantType(InhabitantType.BAT);
                        i++;
                    }
                }
            }
        }
    }

    public String emitEchoes() {
        String echoes = "";

        for (int i = ppos[0]-1; i <= ppos[0]+1; i++) {
            for (int j = ppos[1]-1; j <= ppos[1]+1; j++) {
                if (i <= laberynth.size()-1 && j <= laberynth.getFirst().size() && i >= 0 && j >= 0) {
                    if (!(i == ppos[0] && j == ppos[1])) {
                        echoes += "\n" + laberynth.get(i).get(j).emitEcho();
                    }
                }
            }
        }

        return echoes;
    }

}
