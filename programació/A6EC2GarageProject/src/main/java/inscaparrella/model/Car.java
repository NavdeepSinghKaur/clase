package inscaparrella.model;

public class Car {
    private static final int CHANGE_OIL = 15000;
    private static final int CHANGE_WHEEL = 50000;

    private Owner owner;
    private Report lastReport;
    private String brand;
    private String model;
    private String lisence;
    private int tankCapacity;
    private float currentFuel;
    private float lastConsume;
    private float totalKM;
    private float lastRestartKM;
    private float lastOilKM;
    private float lastWheelsKM;

    public Car() {
        this.owner = new Owner("", "", "", "");
        this.lastReport = new Report(false, false, false);
        this.brand = "";
        this.model = "";
        this.lisence = "";
        this.tankCapacity = 0;
        this.currentFuel = 0.0f;
        this.lastConsume = 0.0f;
        this.totalKM = 0.0f;
        this.lastRestartKM = 0.0f;
        this.lastOilKM = 0.0f;
        this.lastWheelsKM = 0.0f;
    }

    public Car(Owner owner, Report lastReport, String brand, String model, String lisence,
               int tankCapacity, float currentFuel, float lastConsume,
               float totalKM, float lastRestartKM, float lastOilKM, float lastWheelsKM) {
        //Shallow Copy
        /*this.owner = owner;
        this.lastReport = lastReport;*/
        //Deep Copy
        this.owner = new Owner(owner.getName(), owner.getSurname1(),
                owner.getSurname2(), owner.getId());
        this.lastReport = new Report(lastReport.isTankFilled(),
                lastReport.isOilChanged(), lastReport.isWheelsChanged());

        this.brand = brand;
        this.model = model;
        this.lisence = lisence;
        this.tankCapacity = tankCapacity;
        this.currentFuel = currentFuel;
        this.lastConsume = lastConsume;
        this.totalKM = totalKM;
        this.lastRestartKM = lastRestartKM;
        this.lastOilKM = lastOilKM;
        this.lastWheelsKM = lastWheelsKM;
    }

    public Car(Car car) {
        //Shallow Copy
        /*this.owner = car.owner;
        this.lastReport = car.lastReport;*/
        //Deep Copy
        this.owner = new Owner(car.owner.getName(), car.owner.getSurname1(),
                car.owner.getSurname2(), car.owner.getId());
        this.lastReport = new Report(car.lastReport.isTankFilled(),
                car.lastReport.isOilChanged(), car.lastReport.isWheelsChanged());

        this.brand = car.brand;
        this.model = car.model;
        this.lisence = car.lisence;
        this.tankCapacity = car.tankCapacity;
        this.currentFuel = car.currentFuel;
        this.lastConsume = car.lastConsume;
        this.totalKM = car.totalKM;
        this.lastRestartKM = car.lastRestartKM;
        this.lastOilKM = car.lastOilKM;
        this.lastWheelsKM = car.lastWheelsKM;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setLisence(String lisence) {
        this.lisence = lisence;
    }

    public void setTankCapacity(int tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public void setCurrentFuel(float currentFuel) {
        this.currentFuel = currentFuel;
    }

    public void setLastOilKM(float lastOilKM) {
        this.lastOilKM = lastOilKM;
    }

    public void setLastWheelsKM(float lastWheelsKM) {
        this.lastWheelsKM = lastWheelsKM;
    }

    public void setLastReport(Report lastReport) {
        this.lastReport = new Report(lastReport.isTankFilled(),
                lastReport.isOilChanged(), lastReport.isWheelsChanged());
    }

    public String getLisence() {
        return this.lisence;
    }

    public void setTotalKM(float totalKM) {
        this.totalKM = totalKM;
    }

    public float fillTank() {
        float fuelLiters = this.tankCapacity - this.currentFuel; //54 - 23 = 31
        this.currentFuel += fuelLiters;
        //this.currentFuel = this.tankCapacity;

        return fuelLiters;  //31
    }

    public float fillTank(float liters) {
        float extraLiters = 0;

        this.currentFuel += liters;
        if(this.currentFuel > this.tankCapacity) {
            extraLiters = this.currentFuel - this.tankCapacity;
            this.currentFuel -= extraLiters;
            //this.currentFuel = this.tankCapacity;
        }

        return extraLiters;
    }

    public boolean oilChangeRequired() {
        boolean oilChanged = false;
        if(this.lastOilKM >= Car.CHANGE_OIL) oilChanged = true;
        return oilChanged;

        //return (this.lastOilKM >= Car.CHANGE_OIL);
    }

    public boolean wheelsChangeRequired() {
        boolean wheelsChanged = false;
        if(this.lastWheelsKM >= Car.CHANGE_WHEEL) {
            wheelsChanged = true;
        }
        return wheelsChanged;

        //return (this.lastWheelsKM >= Car.CHANGE_WHEEL);
    }

    @Override
    public boolean equals(Object obj) {
        boolean areEquals = false;
        if(obj instanceof Car) {
            Car c = (Car) obj;
            areEquals = this.brand.equals(c.brand)
                    && this.model.equals(c.model)
                    && this.lisence.equals(c.lisence)
                    && this.tankCapacity == c.tankCapacity
                    && Float.compare(this.totalKM, c.totalKM) == 0;
        }
        return areEquals;
    }

    @Override
    public String toString() {
        return this.lisence.toUpperCase() + " " + this.brand + " " + this.model;
    }
}
