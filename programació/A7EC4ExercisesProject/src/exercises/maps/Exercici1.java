package exercises.maps;

import java.util.*;
import java.util.stream.Collectors;

public class Exercici1 {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        HashMap<Integer, RandomTuple> hashMap = new HashMap<>();
        LinkedHashMap<Integer, RandomTuple> linkedHashMap = new LinkedHashMap<>();
        TreeMap<Integer, RandomTuple> treeMap = new TreeMap<>();

        // Exercici 2
        int num = 0;

        while (num > 40 || num < 5) {
            System.out.println("Indica el nombre de dades a emmagatzemar (mínim 5 i màxim 40): ");
            num = scanner.nextInt();
        }

        // Exercici 3
        for (int i = 0; i < num; i++) {
            hashMap.put(i, new RandomTuple());
            linkedHashMap.put(i, new RandomTuple());
            treeMap.put(i, new RandomTuple());
        }

        // Exercici 5
        System.out.println("HashMap: " + hashMapToString(hashMap));
        System.out.println("LinkedHashMap: " + linkedHashMapToString(linkedHashMap));
        System.out.println("TreeMap: " + treeMapToString(treeMap));

        // Exercici 6
        System.out.println("Claus HashMap: ");
        hashMap.entrySet().forEach(entry -> System.out.println(entry.getKey()));
        System.out.println("Claus LinkedHashMap: ");
        linkedHashMap.entrySet().forEach(entry -> System.out.println(entry.getKey()));
        System.out.println("Claus TreeMap: ");
        treeMap.entrySet().forEach(entry -> System.out.println(entry.getKey()));

        System.out.println("Valors HashMap: ");
        hashMap.entrySet().forEach(entry -> System.out.println(entry.getValue()));
        System.out.println("Valors LinkedHashMap: ");
        linkedHashMap.entrySet().forEach(entry -> System.out.println(entry.getValue()));
        System.out.println("Valors TreeMap: ");
        treeMap.entrySet().forEach(entry -> System.out.println(entry.getValue()));

        System.out.println("Tupla clau 3 HashMap: ");
        System.out.println(hashMap.get(3));
        System.out.println("Eliminació de la tupla amb clau 2 hashMap: ");
        System.out.println(hashMap.remove(2));

        System.out.println("Modificació del valor de la clau 4 linkedHashMap: ");
        RandomTuple val = new RandomTuple();
        System.out.println("Valor antic: " + linkedHashMap.get(4));
        System.out.println("Nou valor: " + val);
        linkedHashMap.replace(4, val);
        System.out.println("Nou valor dins del linkedHashMap: " + linkedHashMap.get(4));
    }

    //Exercici 4
    public static String hashMapToString(HashMap<Integer, RandomTuple> hm) {
        return hm
                .entrySet()
                .stream()
                .map(element -> "{" + element.getKey() + ", " + element.getValue() + "}" + "\n")
                .collect(Collectors.joining());
    }

    //Exercici 4
    public static String linkedHashMapToString(LinkedHashMap<Integer, RandomTuple> lhs) {
        return lhs
                .entrySet()
                .stream()
                .map(element -> "{" + element.getKey() + ", " + element.getValue() + "}" + "\n")
                .collect(Collectors.joining());
    }

    //Exercici 4
    public static String treeMapToString(TreeMap<Integer, RandomTuple> tm) {
        return tm
                .entrySet()
                .stream()
                .map(element -> "{" + element.getKey() + ", " + element.getValue() + "}" + "\n")
                .collect(Collectors.joining());
    }
}
