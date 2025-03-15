package main.java.inscaparrella.model;

import main.java.inscaparrella.utils.CellType;

public class WellCell extends Cell{
    public WellCell() {
        super();
        super.ctype = CellType.WELL;
    }

    public WellCell(int row, int col) {
        super(row, col);
        super.ctype = CellType.WELL;
    }

    public WellCell(WellCell cell) {
        super(cell);
        super.ctype = CellType.WELL;
    }

    @Override
    public String emitEcho() {
        return "FFFFfffff...";
    }

    @Override
    public boolean isDangerous() {
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + " - Tipus WELL";
    }
}
