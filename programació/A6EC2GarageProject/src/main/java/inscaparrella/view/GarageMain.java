package inscaparrella.view;

import inscaparrella.controller.GarageController;
import inscaparrella.model.Car;
import inscaparrella.model.Owner;
import inscaparrella.model.Report;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GarageMain {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        GarageController controller = new GarageController();
        Random rnd = new Random();
        String brand, model, lisence;
        Report report;
        Car c;
        int option;

        do {
            System.out.println("~~~~ Gestió del Taller Mecànic ~~~~");
            System.out.println("\t0. Sortir");
            System.out.println("\t1. Entrada d'un nou cotxe");
            System.out.println("\t2. Revisar un cotxe");
            System.out.println("\t3. Llistar tots els cotxes del taller");
            System.out.print("Opció: ");
            option = keyboard.nextInt();
            keyboard.nextLine();

            switch(option) {
                case 0:
                    System.out.println("Tancant...");
                    break;
                case 1:
                    System.out.println("Si us plau indiqui les dades del nou cotxe");
                    System.out.print("Marca: ");
                    brand = keyboard.nextLine();
                    System.out.print("Model: ");
                    model = keyboard.nextLine();
                    System.out.print("Matrícula: ");
                    lisence = keyboard.nextLine();

                    c = new Car();
                    c.setBrand(brand);
                    c.setModel(model);
                    c.setLisence(lisence);
                    c.setTankCapacity(rnd.nextInt(30, 64));
                    c.setCurrentFuel(rnd.nextFloat(10.0f, 25.5f));
                    c.setTotalKM(rnd.nextFloat(10000.0f, 150000.0f));

                    if(controller.addCar(c)) {
                        System.out.println("Nou cotxe al taller");
                    } else {
                        System.out.println("El cotxe ja estava al taller");
                    }

                    break;
                case 2:
                    System.out.println("Si us plau, indiqui la matrícula del cotxe que vol revisar");
                    System.out.print("Matrícula: ");
                    lisence = keyboard.nextLine();
                    report = controller.checkCar(lisence);
                    if(report == null) {
                        System.out.println("Al taller no hi ha cap cotxe amb la matrícula indicada");
                    } else {
                        System.out.println("Revisió completada\n" + report.toString());
                    }
                    break;
                case 3:
                    System.out.println(controller.toString());
                    break;
                default:
                    System.out.println("Opció incorrecta...");
            }

        } while(option != 0);






    }
}
