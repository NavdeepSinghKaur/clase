import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int n = 1;
        funA(n);
    }

    private static void funA(int n) {
        if (n<5) {
            funA(n + 1);
            System.out.println(n);
        }
    }
}
