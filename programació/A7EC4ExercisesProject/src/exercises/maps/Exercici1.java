package exercises.maps;

import java.util.*;

public class Exercici1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<RandomTuple, RandomTuple> hashMap = new HashMap<>();
        LinkedHashMap<RandomTuple, RandomTuple> linkedHashMap = new LinkedHashMap<>();
        TreeMap<RandomTuple, RandomTuple> treeMap = new TreeMap<>();

        // Exercici 2
        int num = 0;

        while (num > 40 || num < 5) {
            System.out.println("Indica el nombre de dades a emmagatzemar (mínim 5 i màxim 40): ");
            num = scanner.nextInt();
        }

        hashMap.
    }
}
