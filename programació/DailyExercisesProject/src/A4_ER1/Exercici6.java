package A4_ER1;

public class Exercici6 {
    public static void main(String[] args) {
        System.out.println(positionOfSix(new int[]{1, 2, 6, 3, 4, 5, 7, 8, 9}, 0));
    }

    private static int positionOfSix(int[] numbers, int i) {
        if (i < numbers.length) {
            if (numbers[i] == 6) {
                return i;
            } else {
                return positionOfSix(numbers, i + 1);
            }
        } else {
            return -1;
        }
    }
}
