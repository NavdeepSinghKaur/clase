package inscaparrella.model;

public class Report {
    private boolean tankFilled;
    private boolean oilChanged;
    private boolean wheelsChanged;

    public Report(boolean tankFilled, boolean oilChanged, boolean wheelsChanged) {
        this.tankFilled = tankFilled;
        this.oilChanged = oilChanged;
        this.wheelsChanged = wheelsChanged;
    }

    public boolean isTankFilled() {
        return this.tankFilled;
    }

    public boolean isOilChanged() {
        return this.oilChanged;
    }

    public boolean isWheelsChanged() {
        return this.wheelsChanged;
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        boolean areEquals = false;
        if(obj instanceof Report) {
            Report rpt = (Report) obj;
            areEquals = (this.tankFilled == rpt.tankFilled && this.oilChanged == rpt.oilChanged
                    && this.wheelsChanged == rpt.wheelsChanged);
        }

        return areEquals;
    }

    @Override
    public String toString() {
        String str = "";
        if(this.tankFilled) str += "- Dipòsit omplert";
        if(this.oilChanged) str += "- Oli canviat";
        if(this.wheelsChanged) str += "- Rodes canviades";

        return str;
    }
}
