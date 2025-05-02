package exercises.linkedlist;

import java.util.LinkedList;

public class Exercici6 {
    public static void main(String[] args) {
        LinkedList<String> estudiants = new LinkedList<>();

        estudiants.add("Estudiant 1");
        estudiants.add("Estudiant 2");
        estudiants.add("Estudiant 3");
        estudiants.add("Estudiant 4");

        estudiants.add(0, "estudiant 5");
        estudiants.add("Estudiant 6");

        estudiants.add(estudiants.size() - estudiants.size(), "Estudiant 7");
        estudiants.add(estudiants.size(), "Estudiant 8");


    }
}
