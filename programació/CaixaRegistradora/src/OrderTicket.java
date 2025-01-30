public class OrderTicket {
    private static final int TOTAL_ORDERS = 10;
    private final OrderLine[] line;
    String[] products;
    private int productCount;

    public OrderTicket() {
        this.line = new OrderLine[TOTAL_ORDERS];
        this.products = new String[TOTAL_ORDERS];
        this.productCount = 0;
    }

    /**
     * @Params
     * Name, units, unitprice
     *
     */
    public boolean addOrderLine(OrderLine line) {

        boolean availableSpace = true;

        if(this.productCount < (TOTAL_ORDERS)) {
            if(this.line[this.productCount] == null ) {
                this.line[this.productCount] = line;
            }
            this.productCount++;
        }
        else {
            availableSpace = false;
        }

        return availableSpace;
    }


    public String getOrder(int position) {
        String returnElement;
        if (line[position] == null) {
            returnElement = "Has introduït una posició que no conté productes.";
        }
        else {
            returnElement = this.line[position].toString();
        }
        return returnElement;
    }
    
    public String[] getAllOrders() {
        this.products = new String[productCount];
        for (int i = 0; i < this.productCount; i++) {
            if (this.line[i] != null) {
                this.products[i] = this.line[i].toString();
            }
        }
        return this.products;
    }

    public double getTotalPrice() {
        double price = 0.0;
        for (int i = 0; i < this.productCount; i++) {
            price += this.line[i].getUnitPrice()*this.line[i].getUnits();
        }
        return price;
    }
}
