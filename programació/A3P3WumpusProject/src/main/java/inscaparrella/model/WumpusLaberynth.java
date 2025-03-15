package main.java.inscaparrella.model;

import main.java.inscaparrella.utils.*;

import java.lang.reflect.Array;
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

    public void setLaberynth(ArrayList<ArrayList<Cell>> laberynth) { // CHECK <-----
        Random random = new Random();
        this.laberynth = new ArrayList<>();
        this.wumpuspos = new int[2];
        this.batspos = new int[laberynth.size()];

        for (ArrayList<Cell> row : laberynth) {
            ArrayList<Cell> tempArray = new ArrayList<>();
            for (Cell cell : row) {
                if (cell instanceof NormalCell) {
                    tempArray.add(new NormalCell((NormalCell) cell));
                } else if (cell instanceof PowerUpCell) {
                    tempArray.add(new PowerUpCell((PowerUpCell) cell));
                } else if (cell instanceof WellCell) {
                    tempArray.add(new WellCell((WellCell) cell));
                }
            }
            this.laberynth.add(tempArray);
        }
    }

    public void createNewLaberynth() { // Check for errors later
        Random random = new Random();

        // cell dimensions
        int tableX = random.nextInt(5, 16);
        int tableY = random.nextInt(5, 16);
        int cellTypeCounter = 0;

        // Initialize arrayLists
        ArrayList<ArrayList<Cell>> generatedLaberynth = new ArrayList<>();
        ArrayList<Cell> generatedCells = new ArrayList<>();

        int numberOfWellCells = random.nextInt(2, (int) (laberynth.toArray().length*0.05));
        int numberOfPowerUpCells = random.nextInt(2, (int) (laberynth.toArray().length*0.1));

        // Number of normal cells variable used to calculate number of bats
        int normalCellNum = 0;

        // initialize
        for (int i = 0; i < tableX; i++) {
            for (int i1 = 0; i1 < tableY; i1++) {
                if (random.nextBoolean() && numberOfWellCells > 0) {
                    generatedCells.add(new WellCell(i, i1));
                    numberOfWellCells--;
                } else if (random.nextBoolean() && numberOfPowerUpCells > 0) {
                    generatedCells.add(new PowerUpCell(i, i1));
                    numberOfPowerUpCells--;
                } else {
                    generatedCells.add(new NormalCell(i, i1));
                    normalCellNum++;
                }
            }
            generatedLaberynth.add(generatedCells);
        }
        setLaberynth(generatedLaberynth);

        // Calculate number of bats
        int numberOfBats = random.nextInt(2, (int) (normalCellNum*0.1));
        int numberOfWumpus = numberOfBats;
        // initialize positions of wumpuspus & bats
        for (int i = 0; i < laberynth.size(); i++) {
            for (int j = 0; j < laberynth.get(i).size(); j++) {
                if (laberynth.get(i).get(j).getCtype() == CellType.NORMAL && !(laberynth.get(i).get(j).isDangerous())) {
                    if (random.nextBoolean() && numberOfBats > 0) {
                        NormalCell habitatnt = (NormalCell) this.laberynth.get(i).get(j);
                        habitatnt.setInhabitantType(InhabitantType.BAT);
                        numberOfBats--;
                    } else if (random.nextBoolean() && numberOfWumpus > 0) {
                        NormalCell habitatnt = (NormalCell) this.laberynth.get(i).get(j);
                        habitatnt.setInhabitantType(InhabitantType.WUMPUS);
                        numberOfWumpus--;
                    }
                }
            }
        }
    }

    public int[] getInitialCell() {
        Random random = new Random();
        ppos = null;
        boolean popsCalculated = false;

        if (!this.laberynth.isEmpty()) {
            for (int i = 0; i < this.laberynth.size(); i++) {
                for (int j = 0; j < this.laberynth.get(i).size(); j++) {
                    if (laberynth.get(i).get(j).getCtype() == CellType.NORMAL) {
                        NormalCell nc = (NormalCell) laberynth.get(i).get(j);
                        if (nc.getInhabitantType() == InhabitantType.NONE && random.nextBoolean() && !popsCalculated) {
                            nc.openCell();
                            ppos = new int[]{i, j};
                            popsCalculated = true;
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
        if (laberynth != null && ppos != null) {
            Random random = new Random();
            if (random.nextInt() % 2 == 0) {
                
            }
        }
    }

}
