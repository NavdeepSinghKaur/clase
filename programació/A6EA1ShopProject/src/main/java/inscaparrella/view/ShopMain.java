package main.java.inscaparrella.view;

import main.java.inscaparrella.controller.ShopController;
import main.java.inscaparrella.model.Product;
import main.java.inscaparrella.utils.ConsoleColors;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ShopMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exitProgram = false;
        ShopController controller = new ShopController();

        while(!exitProgram) {
            System.out.println(ConsoleColors.BLUE_BOLD + """
                ~~~~ Gestió de la Botiga ~~~~
                0. Sortir
                1. Carregar els productes des del fitxer
                2. Afegir un nou producte
                3. Vendre producte
                4. Comprar producte ( reestock )
                5. Eliminar un producte del magatzem
                6. Fer la caixa
                7. Mostrar la botiga
                
                Entrada:
                """ + ConsoleColors.RESET);

            int input = sc.nextInt();
            sc.nextLine();

            switch (input) {
                case 0:
                    sc.close();
                    exitProgram = true;
                    System.out.println(ConsoleColors.CYAN_BACKGROUND_BRIGHT + "OK" + ConsoleColors.RESET);
                    break;
                case 1:
                    System.out.println("Inserta la ubicació del fitxer: \n");
                    String productsPath = sc.nextLine();
                    try {
                        controller.loadProducts(productsPath);
                        System.out.println(ConsoleColors.YELLOW_BOLD_BRIGHT + "OK" + ConsoleColors.RESET);
                    } catch (FileNotFoundException e) {
                        System.out.println(ConsoleColors.RED + "La ubicació no existeix." + ConsoleColors.RESET);
                    }
                    catch (IOException e) {
                        System.out.println(errorMessage());
                    }
                    break;
                case 2:
                    System.out.println("Introdueïx el barcode: ");
                    String barcode = sc.nextLine();
                    System.out.println("Introdueïx el nom del producte: ");
                    String productName = sc.nextLine();
                    System.out.println("Introdueix les quantitats del producte: ");
                    int productQuantities = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Finalment, introdueix el preu del producte: ");
                    float price = sc.nextFloat();
                    sc.nextLine();

                    if(controller.buyProduct(new Product(barcode, productName, price), productQuantities)) {
                        System.out.println("La compra s'ha fet correctament.");
                    } else {
                        System.out.println(errorMessage());
                    }
                    break;
                case 3: // sell
                    boolean sellProductInvalidInput = true;
                    while (sellProductInvalidInput) {
                        System.out.println(controller.getProducts());
                        System.out.println("Quin producte vols: ");
                        String sellProductBarcode = sc.nextLine();
                        System.out.println("Inserta les unitats: ");
                        int sellProductQuantity = sc.nextInt();
                        sc.nextLine();
                        if (controller.sellProduct(sellProductBarcode, sellProductQuantity)) {
                            System.out.println("La compra s'ha fet correctament.");
                            sellProductInvalidInput = false;
                        } else {
                            System.out.println(errorMessage());
                        }
                    }
                    break;
                case 4:
                    boolean buyProductInvalidInput = true;
                    while (buyProductInvalidInput) {
                        System.out.println(controller.getProductsForReestock());
                        System.out.println("Quin producte vols (introdueix el barcode): ");
                        String buyProductBarcode = sc.nextLine();
                        System.out.println("Inserta les unitats: ");
                        int buyProductQuantity = sc.nextInt();
                        sc.nextLine();
                        if (controller.buyProduct(buyProductBarcode, buyProductQuantity)) {
                            System.out.println("La compra s'ha fet correctament.");
                            buyProductInvalidInput = false;
                        } else {
                            System.out.println(errorMessage());
                        }
                    }
                    break;
                case 5:
                    System.out.println("Inserta el barcode del producte a eliminar: ");
                    String deleteProductBarcode = sc.nextLine();
                    if(controller.delistProduct(deleteProductBarcode)) {
                        System.out.println(ConsoleColors.GREEN_BOLD + "El producte s'ha eliminat correctament." + ConsoleColors.RESET);
                    } else {
                        System.out.println(errorMessage());
                    }
                    break;
                case 6:
                    System.out.println(controller.closeCash());
                    break;
                case 7:
                    System.out.println(controller.getAllProducts());
                    System.out.println(controller.closeCash());
                    break;
                default:
                    System.out.println(ConsoleColors.RED_BOLD + "ERROR: Has elegit una opció incorrecta" + ConsoleColors.RESET);
            }
        }
    }

    public static String errorMessage() {
        return ConsoleColors.RED_BOLD + "Hi ha hagut un error. Torna a intentar-ho." + ConsoleColors.RESET;
    }
}
