package exercises.linkedlist;

import java.util.LinkedList;

public class Exercici20 {
    public static void main(String[] args) {
        LinkedList<String> estudiants = new LinkedList<>();
        estudiants.add("Estudiant 1 LinkedList");
        estudiants.add("Estudiant 2 LinkedList");
        estudiants.add("Estudiant 3 LinkedList");
        estudiants.add("Estudiant 4 LinkedList");

        LinkedList<String> estudiants1 = new LinkedList<>();
        estudiants1.add("Estudiant 1 LinkedList");
        estudiants1.add("Estudiant 2 LinkedList");
        estudiants1.add("Estudiant 3 LinkedList");
        estudiants1.add("Estudiant 4 LinkedList");

        boolean equalElements = isEqualElementsFor(estudiants, estudiants1);

        equalElements = isEqualElementsForEnhanced(estudiants, estudiants1, equalElements);

        idEqualElementsWhile(estudiants, equalElements, estudiants1);
    }

    private static void idEqualElementsWhile(LinkedList<String> estudiants, boolean equalElements, LinkedList<String> estudiants1) {
        int i = 0;
        while (i < estudiants.size() && equalElements) {
            equalElements = estudiants.get(i).equals(estudiants1.get(i));
            i++;
        }
    }

    private static boolean isEqualElementsForEnhanced(LinkedList<String> estudiants, LinkedList<String> estudiants1, boolean equalElements) {
        for (String estudiant : estudiants) {
            for (String estudiant1 : estudiants1) {
                if (!estudiant.equals(estudiant1)) {
                    equalElements = false;
                }
            }
        }
        return equalElements;
    }

    private static boolean isEqualElementsFor(LinkedList<String> estudiants, LinkedList<String> estudiants1) {
        boolean equalElements = true;
        for (int i = 0; i < estudiants.size(); i++) {
            if (!estudiants.get(i).equals(estudiants1.get(i))) {
                equalElements = false;
            }
        }
        return equalElements;
    }
}
