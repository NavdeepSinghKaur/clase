import java.util.Comparator;
import java.util.Objects;
import java.util.Random;

public class Tuple implements Comparable<Tuple> {
    Random random;
    int element1;
    int element2;

    public Tuple() {
        random = new Random();

        element1 = random.nextInt();
        element2 = random.nextInt();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Tuple tuple)) return false;
        return element1 == tuple.element1 && element2 == tuple.element2;
    }

    @Override
    public int compareTo(Tuple o) {
        int returnValue = Integer.compare((o.element1 + o.element2), (this.element1 + this.element2));
        if (returnValue == 0) {
            if (this.minValue() < o.minValue()) {
                returnValue = -1;
            } else if (this.minValue() > o.minValue()) {
                returnValue = 1;
            }
        }

        return returnValue;
    }

    @Override
    public int hashCode() {
        int result = element1;
        result = 31 * result + element2;
        return result;
    }

    @Override
    public String toString() {
        return "Tuple{" +
                ", element1=" + element1 +
                ", element2=" + element2 +
                '}';
    }

    private int minValue() {
        int returnValue = element2;
        if (this.element1 < this.element2) {
            returnValue = element1;
        }

        return returnValue;
    }
}
