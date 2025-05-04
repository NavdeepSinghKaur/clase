package exercises.linkedlist;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Exercici12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedList<String> estudiants = new LinkedList<>();
        estudiants.add("Estudiant 1 LinkedList");
        estudiants.add("Estudiant 2 LinkedList");
        estudiants.add("Estudiant 3 LinkedList");
        estudiants.add("Estudiant 4 LinkedList");

        System.out.println("Introdueix dos números separats per coma (exemple -> 1,3): ");
        String numbers = scanner.nextLine().replace(" ", "");
        int number0 = Integer.parseInt(numbers.split(",")[0]);
        int number1 = Integer.parseInt(numbers.split(",")[1]);
        String tempVar = "";
        tempVar = estudiants.get(number0);
        estudiants.set(number0, estudiants.get(number1));
        estudiants.set(number1, tempVar);

        System.out.println("Resultat (manualment): ");
        estudiants.forEach(estudiant -> System.out.println(estudiant));

        tempVar = estudiants.get(number0);
        estudiants.set(number0, estudiants.get(number1));
        estudiants.set(number1, tempVar);

        System.out.println("\nResultat (utilitzant la classe collections): ");
        Collections.swap(estudiants, number0, number1);
        estudiants.forEach(estudiant -> System.out.println(estudiant));

    }
}
