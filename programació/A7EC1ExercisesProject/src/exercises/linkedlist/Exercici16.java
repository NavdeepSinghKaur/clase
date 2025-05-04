package exercises.linkedlist;

import java.util.LinkedList;

public class Exercici16 {
    public static void main(String[] args) {
        LinkedList<String> estudiants = new LinkedList<>();
        estudiants.add("Estudiant 1 LinkedList");
        estudiants.add("Estudiant 2 LinkedList");
        estudiants.add("Estudiant 3 LinkedList");
        estudiants.add("Estudiant 4 LinkedList");

        System.out.println(estudiants.removeFirst());
    }
}
