package exercises.linkedlist;

import java.util.LinkedList;

public class Exercici1 {
    public static void main(String[] args) {
        LinkedList<String> estudiants = new LinkedList<>();

        estudiants.add("Estudiant 1");
        estudiants.add("Estudiant 2");
        estudiants.add("Estudiant 3");
        estudiants.add("Estudiant 4");


        estudiants.forEach(estudiant -> System.out.println("Estudiant:" + estudiant));
    }
}
