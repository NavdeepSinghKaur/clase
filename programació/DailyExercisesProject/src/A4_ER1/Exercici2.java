package A4_ER1;

public class Exercici2 {
    public static void main(String[] args) {

        System.out.println(squareRoot(3, 0, 0f));
    }


    private static float squareRoot(int x, int i, float n) {
        if (i < 10) {
            if (x == 0) {

            }
            return n + squareRoot(x/2, i+1, n);
        } else {
            return 0.0f;
        }
    }
}
