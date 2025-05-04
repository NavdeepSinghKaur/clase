package exercises.linkedlist;

import java.util.LinkedList;

public class Exercici14 {
    public static void main(String[] args) {
        LinkedList<String> estudiants = new LinkedList<>();

        LinkedList<String> estudiants1 = new LinkedList<>();
        estudiants1.add("Estudiant 1 LinkedList");
        estudiants1.add("Estudiant 2 LinkedList");
        estudiants1.add("Estudiant 3 LinkedList");
        estudiants1.add("Estudiant 4 LinkedList");

        LinkedList<String> estudiants2 = new LinkedList<>();
        estudiants2.add("Estudiant 5 LinkedList");
        estudiants2.add("Estudiant 6 LinkedList");
        estudiants2.add("Estudiant 7 LinkedList");
        estudiants2.add("Estudiant 8 LinkedList");

        estudiants.addAll(estudiants1);
        estudiants.addAll(estudiants2);

        estudiants.forEach(estudiant -> System.out.println(estudiant));
    }
}
