package main.java.inscaparrella.model;

import main.java.inscaparrella.utils.CellType;
import main.java.inscaparrella.utils.InhabitantType;

import java.util.Objects;

public class NormalCell extends Cell{
    private InhabitantType iType;

    public NormalCell() {
        super();
        iType = InhabitantType.NONE;
    }

    public NormalCell(CellType ctype, int row, int col) {
        super(row, col);
        super.ctype = CellType.NORMAL;
        iType = InhabitantType.NONE;
    }

    public NormalCell(NormalCell nc) {
        super(nc);
        iType = nc.iType;
    }

    @Override
    public String emitEcho() {
        String strEmitEcho = "";
        if (iType == InhabitantType.WUMPUS) {
            strEmitEcho = "gggrrr... gggGGGGGRRRRRrrr...";
        } else if (iType == InhabitantType.BAT) {
            strEmitEcho = "Flap, flap, flap";
        }

        return strEmitEcho;
    }

    @Override
    public boolean isDangerous() {
        return (iType != InhabitantType.NONE);
    }

    @Override
    public String toString() {
        String toStringReturnText = super.toString();

        if (iType == InhabitantType.NONE) {
            toStringReturnText += "Tipus: NORMAL.";
        }
        else if (iType == InhabitantType.WUMPUS) {
            toStringReturnText += "NORMAL (habitada pel Wumpus).";
        } else {
            toStringReturnText += "Tipus NORMAL (habitada per un ratpenat).";
        }

        return toStringReturnText;
    }

    @Override
    public boolean equals(Object obj) { // CHECK IF IT'S OK
        boolean bEquals = false;
        if (obj instanceof NormalCell nc) {
            bEquals = super.equals(nc) && (this.iType == nc.iType);
        }

        return bEquals;
    }
}
