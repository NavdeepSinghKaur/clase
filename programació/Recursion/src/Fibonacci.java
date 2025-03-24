import java.util.Random;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 177;
        //int result = fibonacci(n);
        //System.out.println(result);

        long i = 1;
        long j = 1;
        for (int k = 0; k < 177; k++) {
            i = i + j;
            j = i;
        }
        System.out.println(i);
    }

    private static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }
}
