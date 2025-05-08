import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Exercici1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashSet<String> hs = new HashSet<>();
        LinkedHashSet<String> ls = new LinkedHashSet<>();
        TreeSet<String> ts = new TreeSet<>();

        // Exercici 2
        int num = 0;

        while (num > 40 || num < 5) {
            System.out.println("Indica el nombre de dades a emmagatzemar (mínim 5 i màxim 40): ");
            num = scanner.nextInt();
        }

        // Exercici 3
        scanner.nextLine();
        for (int i = 0; i < num; i++) {
            System.out.println("Entrada " + (i+1) + " de " + num + ": ");
            String input = scanner.nextLine();
            if (hs.contains(input)) {
                System.out.println("Aquesta entrada ja està inserida: ");
            }
            hs.add(input);
            ls.add(input);
            ts.add(input);
        }

        // Exercici 5
        System.out.println("HashSet: ");
        printHashSet(hs);
        System.out.println("LinkedHashSet: ");
        printLinkedHashSet(ls);
        System.out.println("TreeSet: ");
        printTreeSet(ts);

        // Exercici 6
        // 1
        System.out.println("Mida del treeSet: ");
        System.out.println(ts.size());
        System.out.println("Primer element del treeSet: ");
        System.out.println(ts.getFirst());
        System.out.println("Últim element del treeSet: ");
        System.out.println(ts.getLast());
        // 2
        System.out.println("Inserta un valor: ");
        String input = scanner.nextLine();
        System.out.println("El valor introduït es troba al treeSet: " + ts.contains(input));
        // 3
        System.out.println("Inserta un valor: ");
        input = scanner.nextLine();
        System.out.println("Valor immediatament més gran o igual al valor introduït: " + ts.ceiling(input));
        // 4
        System.out.println("valor immediatament i estrictament més petit al valor introduït: " + ts.lower(input));
        // 5
        System.out.println("Tots els valors..");
        String finalInputLessOrEqual = input;
        ts.stream()
                .filter(s -> s.length() < finalInputLessOrEqual.length())
                .forEach(element -> System.out.println("estrictament més petit al valor introduït: " + element));

        // 6
        String finalInputEqualOrGreater = input;
        ts.stream()
                .filter(s -> s.length() >= finalInputEqualOrGreater.length())
                .forEach(element -> System.out.println("estrictament més petit o igual al valor introduït: " + element));
        // 7
        System.out.println("TreeSet en ordre descendent: ");
        TreeSet<String> reversedTs = (TreeSet<String>) ts.reversed();
        reversedTs.forEach(element -> System.out.println(element));
    }
    // Exercici 4
    public static void printHashSet(HashSet<String> hs) {
        hs.stream().forEach(stream -> System.out.println(stream));
    }

    // Exercici 4
    public static void printLinkedHashSet(LinkedHashSet<String> ls) {
        ls.stream().forEach(stream -> System.out.println(stream));
    }

    // Exercici 4
    public static void printTreeSet(TreeSet<String> ts) {
        ts.stream().forEach(stream -> System.out.println(stream));
    }
}
