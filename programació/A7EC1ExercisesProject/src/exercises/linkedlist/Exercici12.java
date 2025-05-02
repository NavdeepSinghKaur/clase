package exercises.linkedlist;

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

        System.out.println("Introdueix dos números separats per coma: ");
        String numbers = scanner.nextLine();
        int number0 = Integer.parseInt(numbers.split(",")[0]);
        int number1 = Integer.parseInt(numbers.split(",")[1]);
        String helper = "";
        helper = estudiants.get(number0);
        estudiants.set(number1, helper);
    }
}
