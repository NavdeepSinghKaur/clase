package exercises.linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Exercici7A11 {
    public static void main(String[] args) {
        System.out.println("Exercici 7");
        Scanner scanner = new Scanner(System.in);
        LinkedList<String> estudiants = new LinkedList<>();

        estudiants.add("Estudiant 1 LinkedList");
        estudiants.add("Estudiant 2 LinkedList");
        estudiants.add("Estudiant 3");
        estudiants.add("Estudiant 4 LinkedList");

        ArrayList<String> estudiantsArrayList = new ArrayList<>();

        estudiantsArrayList.add("Estudiant 1 ArrayList");
        estudiantsArrayList.add("Estudiant 2 ArrayList");
        estudiantsArrayList.add("Estudiant 3");
        estudiantsArrayList.add("Estudiant 4 ArrayList");

        System.out.println("Indica la posició de la LinkedList a on s'insertarà l'ArrayList: ");
        int position = scanner.nextInt();
        scanner.nextLine();
        estudiants.addAll(position, estudiantsArrayList);
        System.out.println(estudiants);

        // Exercici 8
        System.out.println("Exercici 8");
        System.out.println("Indica un nom dels estudiants: ");
        String name = scanner.nextLine();
        System.out.println("Primera posició a l'array: " + estudiants.indexOf(name) + "\nÚlitma posició a l'array: " + estudiants.lastIndexOf(name));

        // Exercici 9
        System.out.println("Exercici 9");
        System.out.println("Inserta la posició d'un element per borrar-lo: ");
        System.out.println("Abans:" + estudiants);
        position = scanner.nextInt();
        estudiants.remove(position);
        System.out.println("Després" + estudiants);

        // Exercici 10
        System.out.println("Exercici 10");
        estudiants.removeFirst();
        estudiants.removeLast();
        System.out.println(estudiants);

        // Exercici 11
        System.out.println("Exercici 11");
        estudiants.clear();
        System.out.println(estudiants);
    }
}
