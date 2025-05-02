package exercises.linkedlist;

import java.util.LinkedList;
import java.util.Scanner;

public class Exercici3 {
    public static void main(String[] args) {
        LinkedList<String> estudiants = new LinkedList<>();

        estudiants.add("Estudiant 1");
        estudiants.add("Estudiant 2");
        estudiants.add("Estudiant 3");
        estudiants.add("Estudiant 4");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Indica la posició: ");
        int position = scanner.nextInt();

        // fori
        for (int i = position; i < estudiants.size(); i++) {
            System.out.println("Estudiant: " + estudiants.get(i));
        }

        //while
        while (position < estudiants.size()) {
            System.out.println("Estudiant: " + estudiants.get(position));
            position++;
        }

    }
}
