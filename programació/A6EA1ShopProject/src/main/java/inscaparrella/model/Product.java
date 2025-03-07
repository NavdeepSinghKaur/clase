package main.java.inscaparrella.model;

import java.util.Objects;

public class Product {
    private String barcode;
    private String name;
    private float unitPrice;

    public Product() {
        this.barcode = "";
        this.name = "";
        this.unitPrice = 0f;
    }

    public Product(String barcode, String name, float unitPrice) {
        this.barcode = barcode;
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public Product(Product product) {
        this.barcode = product.getBarcode();
        this.name = product.getName();
        this.unitPrice = product.getUnitPrice();
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public boolean equals(Object obj) {
        boolean bEquals = true;

        if ((obj instanceof Product)) {
            Product product = (Product) obj;
            bEquals =  Float.compare(unitPrice, product.unitPrice) == 0 && barcode.equals(product.barcode) && name.equals(product.name);
        }

        return bEquals;
    }

    @Override
    public int hashCode() {
        return Objects.hash(barcode, name, unitPrice);
    }

    @Override
    public String toString() {
        return "Product{" +
                "barcode='" + barcode + '\'' +
                ", name='" + name + '\'' +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
