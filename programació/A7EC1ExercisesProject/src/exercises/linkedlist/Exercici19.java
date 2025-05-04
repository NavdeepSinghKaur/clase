package exercises.linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;

public class Exercici19 {
    public static void main(String[] args) {
        LinkedList<String> estudiants = new LinkedList<>();
        estudiants.add("Estudiant 1 LinkedList");
        estudiants.add("Estudiant 2 LinkedList");
        estudiants.add("Estudiant 3 LinkedList");
        estudiants.add("Estudiant 4 LinkedList");

        //Utilitzant el constructor ArrayList
        ArrayList<String> estudiantsArrayListCast = new ArrayList<>(estudiants);

        // Utulitzant un bucle For
        ArrayList<String> estudiantsArrayListFor = new ArrayList<>();
        for (int i = 0; i < estudiants.size(); i++) {
            estudiantsArrayListFor.add(estudiants.get(i));
        }

    }
}
