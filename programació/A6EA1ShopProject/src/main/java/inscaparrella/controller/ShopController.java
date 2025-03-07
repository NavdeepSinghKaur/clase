package main.java.inscaparrella.controller;

import main.java.inscaparrella.model.CashRegistrer;
import main.java.inscaparrella.model.Product;
import main.java.inscaparrella.model.Warehouse;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

public class ShopController {
    private final Warehouse wh;
    private CashRegistrer cr;
    private Product pr;

    public ShopController() {
        ArrayList<Product> products = new ArrayList<>();
        ArrayList<Integer> quantities = new ArrayList<>();
        wh = new Warehouse(products, quantities);
        cr = new CashRegistrer();
        pr = new Product();
    }

    @Override
    public boolean equals(Object obj) {
        boolean bEquals = false;
        if (obj instanceof ShopController sc) {
            bEquals = this.wh.equals(sc.wh) && this.cr.equals(sc.cr);
        }
        return bEquals;
    }

    @Override
    public int hashCode() {
        return Objects.hash(wh, cr);
    }

    @Override
    public String toString() {
        String str = "PRODUCTES DEL MAGATZEM: " + "\n" + this.wh.toString() + "\n";
        str += "CAIXA REGISTRADORA: " + "\n" + this.cr.toString() + "\n";

        return str;
    }

    public void loadProducts(String filename) throws FileNotFoundException, IOException {
        FileReader freader = new FileReader(filename);
        BufferedReader breader = new BufferedReader(freader);

        breader.lines().forEach((String line) -> {
            if(!line.startsWith("barcode")) {
                String fields[] = line.split(",");
                float unitPrice = Float.valueOf(fields[2].replace("\"", "").substring(1));
                Product prod = new Product(fields[0], fields[1].replace("\"", ""), unitPrice);
                this.wh.addProduct(prod, Integer.valueOf(fields[3]));
            }
        });

        breader.close();
        freader.close();
    }

    public ArrayList<Product> getProductsForReestock() {
        return wh.getProductsForReestock();
    }

    public ArrayList<Product> getProducts() {
        return wh.getProducts();
    }

    public ArrayList<Product> getAllProducts() {
        return wh.getAllProducts();
    }

    public boolean sellProduct(String barcode, int quantity) {
        boolean returnValue = false;
        if (wh.reduceProduct(barcode, quantity)) {
            float totalPrice = 0;
            for (Product product: wh.getAllProducts()) {
                if (product.getBarcode().equals(barcode)) {
                    totalPrice = product.getUnitPrice() * quantity;
                }
            }
            cr.manageSale(totalPrice);
            returnValue = true;
        }

        return returnValue;
    }

    public boolean buyProduct(Product product, int quantity) {
        wh.addProduct(product, quantity);
        float totalPrice = product.getUnitPrice() * quantity;
        cr.managePurchase(totalPrice);
        return true;
    }

    public boolean buyProduct(String barcode, int quantity) {
        boolean productExists = false;
        ArrayList<Product> products;
        products = wh.getAllProducts();
        int i=0;
        while (i<products.toArray().length) {
            if (products.get(i).getBarcode().equals(barcode)) {
                productExists = true;
                wh.addProduct(new Product(products.get(i)), quantity);
                float totalPrice = products.get(i).getUnitPrice() * quantity;
                cr.managePurchase(totalPrice);
            }
            i++;
        }
        return productExists;
    }

    public boolean delistProduct(String barcode) {
        return wh.deleteProduct(barcode);
    }

    public float closeCash() {
        return cr.closeCash();
    }

}
