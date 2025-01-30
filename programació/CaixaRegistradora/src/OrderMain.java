import java.util.Scanner;

public class OrderMain {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean mainLoop = true;
        OrderTicket ticket = new OrderTicket();
        // OrderLine line = new OrderLine();
        boolean outOfSpace = false;

        while (mainLoop) {

            int userMainInput;
            System.out.println("""
                    ~~~~~~~~~~~~MENU~~~~~~~~~~~~
                    0. Sortir.
                    1. Afegir una llista de comanda.
                    2. Consoltar el tiquet.
                    3. Consultar linea de comanda.
                    4. Consultar preu total
                    
                    Entrada:
                    """);
            userMainInput = sc.nextInt();
            sc.nextLine();

            switch (userMainInput) {
                case 0:
                    System.out.println("El programa es tancarà inmediatament.");
                    sc.close();
                    mainLoop = false;
                    break;

                case 1:
                    String productName = "";
                    String barcode = "";
                    int units = 0;
                    float unitPrice = 0;

                    if (!outOfSpace) {
                        System.out.println("Inserta el barcode: ");
                        barcode = sc.nextLine();

                        System.out.println("Introdueix el nom del producte: ");
                        productName = sc.nextLine();

                        System.out.println("Introdueix el número d'unitats del prodcucte: ");
                        units = sc.nextInt();
                        sc.nextLine();

                        System.out.println("Intordueix el preu del producte: ");
                        unitPrice = sc.nextFloat();
                        sc.nextLine();

                    } else {
                        System.out.println("No hi ha suficient espai per almacenar productes.");
                    }

                    if(!ticket.addOrderLine(new OrderLine(barcode, productName, units, unitPrice)) && !outOfSpace){
                        outOfSpace = true;
                    }
                    break;

                case 2:
                    String[] orders = ticket.getAllOrders();
                    System.out.println("~~~~~~~~~~~~TICKET~~~~~~~~~~~~");
                    for (String order:orders) {
                        System.out.println(order);
                    }
                    System.out.println("Total: " + ticket.getTotalPrice() + " €");
                    break;

                case 3:
                    int elementToReturn;
                    System.out.println("Inserta la posició del element a retornar: ");
                    elementToReturn = sc.nextInt();
                    sc.nextLine();
                    System.out.println(ticket.getOrder(elementToReturn));
                    break;

                case 4:
                    System.out.println(ticket.getTotalPrice() + "€");
                    break;

                default:
                    System.out.println("Has introduït un valor invàlid. Torna a intentar-ho. ");
            }
        }
    }
}
