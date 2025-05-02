package exercises.linkedlist;

import java.util.LinkedList;
import java.util.Scanner;

public class Exercici5 {
    public static void main(String[] args) {
        LinkedList<String> estudiants = new LinkedList<>();

        estudiants.add("Estudiant 1");
        estudiants.add("Estudiant 2");
        estudiants.add("Estudiant 3");
        estudiants.add("Estudiant 4");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Indica el nom de l'estudiant a agregar: ");
        String name = scanner.nextLine();

        System.out.println("Indica la posició a guardar: ");
        int position = scanner.nextInt();

        estudiants.add(position, name);
    }
}
