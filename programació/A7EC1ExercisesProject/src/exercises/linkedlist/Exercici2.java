package exercises.linkedlist;


import java.util.LinkedList;

public class Exercici2 {
    public static void main(String[] args) {
        LinkedList<String> estudiants = new LinkedList<>();

        estudiants.add("Estudiant 1");
        estudiants.add("Estudiant 2");
        estudiants.add("Estudiant 3");
        estudiants.add("Estudiant 4");

        // For each
        for (String estudiant : estudiants) {
            System.out.println("Estudiant: " + estudiant);
        }
        // For amb iterador
        for (int i = 0; i < estudiants.size(); i++) {
            System.out.println("Estudiant: " + estudiants.get(i));
        }
        // While amb iterador
        int i=0;
        while (i < estudiants.size()) {
            System.out.println("Estudiant: " + estudiants.get(i));
        }
    }
}
