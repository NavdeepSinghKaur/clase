package main.java.inscaparrella.model;

import main.java.inscaparrella.utils.CellType;
import main.java.inscaparrella.utils.InhabitantType;

import java.util.Objects;

public abstract class Cell {
    private int row;
    private int col;
    protected CellType ctype;
    protected boolean open;

    public Cell() {
        this.row = -1;
        this.col = -1;
        this.ctype = CellType.NONE;
        this.open = false;
    }

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.ctype = CellType.NONE;
        this.open = false;
    }

    public Cell (Cell cell) { // how to get row & col (they don't have getters) & should I do a deep copy?
        this.row = cell.row;
        this.col = cell.col;
        this.ctype = cell.ctype;
        this.open = cell.open;
    }

    public CellType getCtype() {
        return this.ctype;
    }

    public boolean isOpen() {
        return this.open;
    }

    public void openCell() {
        this.open = true;
    }

    public abstract String emitEcho();

    public abstract boolean isDangerous();

    @Override
    public String toString() {
        return "Cel·la [" + this.row + ", " + this.col + "]";
    }

    @Override
    public boolean equals(Object obj) {
        boolean bEquals = false;
        if (obj instanceof Cell cell) {
            bEquals = this.row == cell.row
                    && this.col == cell.col
                    && this.open == cell.open
                    && this.ctype == cell.ctype;
        }
        return bEquals;
    }
}
