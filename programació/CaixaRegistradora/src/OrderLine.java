public class OrderLine {
    private String barcode;
    private String productName;
    private int units;
    private float unitPrice;

    // constructors
    public OrderLine() {
        this.barcode = "";
        this.productName = "";
        this.units = 0;
        this.unitPrice = 0.0f;
    }

    public OrderLine(String barcode, String productName, int units, float unitPrice) {
        this.barcode = barcode;
        this.productName = productName;
        this.units = units;
        this.unitPrice = unitPrice;
    }

    public OrderLine(OrderLine line) {
        this.barcode = line.barcode;
        this.units = line.units;
        this.unitPrice = line.unitPrice;
        this.productName = line.productName;
    }

    // getters & setters
    public String getBarcode() {
        return this.barcode;
    }
    public String getProductName() {
        return this.productName;
    }
    public int getUnits() {
        return this.units;
    }
    public float getUnitPrice() {
        return this.unitPrice;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public void setUnits(int units) {
        this.units = units;
    }
    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        boolean areEquals = false;
        if (obj instanceof OrderLine) {
            OrderLine line = (OrderLine) obj;
            areEquals = this.barcode.equals(line.barcode) && this.productName.equals(line.productName)
                    && this.units == line.units && Float.compare(this.unitPrice, line.unitPrice) == 0;
        }
        return areEquals;
    }

    @Override
    public String toString() {
        return this.productName + " { Barcode: " + this.barcode + " } " + " { Unitats: "+ this.units + " } " + "{ Preu unitari (€): " + this.unitPrice + " } ";
    }

}
