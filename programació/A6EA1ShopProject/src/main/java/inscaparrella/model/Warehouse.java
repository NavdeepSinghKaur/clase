package main.java.inscaparrella.model;

import java.util.ArrayList;
import java.util.Objects;
// OK -> CONVERTED TO DEEP COPY
public class Warehouse {
    private static final int REESTOCK_UNITS = 0;
    private ArrayList<Product> products;
    private ArrayList<Integer> quantities;

    public Warehouse() { // OK
        this.products = new ArrayList<>();
        this.quantities = new ArrayList<>();
    }

    public Warehouse(ArrayList<Product> products, ArrayList<Integer> quantities) { // OK
        this.products = new ArrayList<>();
        this.quantities = new ArrayList<>();

        for (int i = 0; i < products.size(); i++) {
            this.products.add(new Product(products.get(i)));
            this.quantities.add(quantities.get(i));
        }
    }

    public Warehouse(Warehouse warehouse) { // OK
        this.products = new ArrayList<>();
        this.quantities = new ArrayList<>();

        for (int i = 0; i < warehouse.products.size(); i++) {
            this.products.add(new Product(warehouse.products.get(i)));
            this.quantities.add(warehouse.quantities.get(i));
        }
    }

    @Override
    public boolean equals(Object obj) {
        boolean equals = true;
        int i = 0;

        if (obj instanceof Warehouse) {
            Warehouse wh = (Warehouse) obj;

            while (i < this.products.size()) {
                if ( !(this.products.get(i).equals(wh.products.get(i)))
                        || !(this.quantities.get(i).equals(wh.quantities.get(i)))) {
                    equals = false;
                }
                i++;
            }
        }

        return equals;
    }

    @Override
    public int hashCode() {
        return Objects.hash(products, quantities);
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "products=" + products +
                ", quantities=" + quantities +
                '}';
    }

    public boolean addProduct(Product product) { // OK
        boolean bAdded = false;

        if (!this.products.contains(product)) {
            this.products.add(new Product(product));
            bAdded = true;
        }

        return bAdded;
    }

    public void addProduct(Product product, int quantity) { // OK
        if (!(this.products.contains(product))) {
            this.products.add(new Product(product));
            this.quantities.add(quantity);
        } else {
            int position = this.getProductPosition(product.getBarcode());
            if (position != -1) {
                int currentQuantities = this.quantities.get(position);
                this.quantities.add(position, currentQuantities + quantity);
            }
        }
    }

    public boolean deleteProduct(String barcode) { // OK
        int pos = this.getProductPosition(barcode);
        if (pos != -1) {
            this.products.remove(pos);
            this.quantities.remove(pos);
        }

        return (pos != -1);
    }

    public boolean reduceProduct(String barcode, int quantity) { // OK
        int pos = this.getProductPosition(barcode);
        boolean productFound = false;
        if (pos != -1) {
            productFound = this.quantities.get(pos) >= quantity;
            if (productFound) {
                this.quantities.set(pos, this.quantities.get(pos) - quantity);
            }
        }
        return productFound;
    }

    public ArrayList<Product> getProductsForReestock() {
        ArrayList<Product> lowStockProducts = new ArrayList<>();
        int i=0;
        while (i<this.products.toArray().length){
            if (this.quantities.get(i) <= 5) {
                lowStockProducts.add(new Product(this.products.get(i)));
            }
            i++;
        }
        return lowStockProducts;
    }

    public ArrayList<Product> getProducts() {
        ArrayList<Product> productsWithStock = new ArrayList<>();
        int i=0;
        while (i<this.products.toArray().length) {
            if (this.quantities.get(i) >= 1) {
                productsWithStock.add(products.get(i));
            }
            i++;
        }
        return productsWithStock;
    }

    public ArrayList<Product> getAllProducts() {
        return this.products;
    }

    public Product getProduct(String barcode) {
        Product objectToReturn = null;

        int position = getProductPosition(barcode);
        if (position != -1) {
            objectToReturn = (new Product(this.products.get(position)));
        }

        return objectToReturn;
    }

    private int getProductPosition(String barcode) {
        int productPosition = -1;
        for (int i = 0; i < this.products.toArray().length; i++) {
            if (this.products.get(i).getBarcode().equals(barcode)) {
                productPosition = i;
            }
        }

        return productPosition;
    }
}
