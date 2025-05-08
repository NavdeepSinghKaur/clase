import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Exercici7Main {
    public static void main(String[] args) {
        HashSet<Tuple> hs = new HashSet<>();
        LinkedHashSet<Tuple> ls = new LinkedHashSet<>();
        TreeSet<Tuple> ts = new TreeSet<>();

        for (int i = 0; i < 100; i++) {
            Tuple tuple = new Tuple();
            hs.add(tuple);
            ls.add(tuple);
            ts.add(tuple);
        }

        System.out.println("Valors HashMap: ");
        hs.forEach(element -> System.out.println(element));
        System.out.println("Valors LinkedHashMap: ");
        ls.forEach(element -> System.out.println(element));
        System.out.println("Valors TreeMap: ");
        ts.forEach(element -> System.out.println(element));
    }
}
