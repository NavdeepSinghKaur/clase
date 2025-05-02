import java.util.Comparator;
import java.util.Objects;
import java.util.Random;

public class Tuple implements Comparable {
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
    public int compareTo(Object o) {
        if (o instanceof Tuple) {
            Tuple obj = (Tuple) o;
            int returnValue = (this.element1 + this.element2) - (obj.element1 + obj.element2);
            if (returnValue == 0) {
                if ()
            }
        }
    }
}
