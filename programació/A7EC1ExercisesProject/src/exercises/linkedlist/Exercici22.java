package exercises.linkedlist;

import java.util.LinkedList;
import java.util.Scanner;

public class Exercici22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<String> estudiants = new LinkedList<>();
        estudiants.add("Estudiant 1 LinkedList");
        estudiants.add("Estudiant 2 LinkedList");
        estudiants.add("Estudiant 3 LinkedList");
        estudiants.add("Estudiant 4 LinkedList");

        System.out.println("Introdueïx un estudiant: ");
        String input = scanner.nextLine();
        estudiants.set(1, input);

        System.out.println(estudiants);
    }
}
