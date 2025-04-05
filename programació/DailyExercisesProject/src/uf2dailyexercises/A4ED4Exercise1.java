package uf2dailyexercises;

public class A4ED4Exercise1 {
    public static void main(String[] args) {
        System.out.println(pyramidIterative(4));
    }

    public static int pyramidIterative(int blocks) {
        int total = 0;
        int counter = 3;
        for (int i = 1; i <= blocks; i++) {
            total += i + counter;
            counter += 2;
            System.out.println(total);
        }

        return total;
    }

    public static int pyramidRecursive(int blocks, int total) {
        if (blocks > 0) {
            return pyramidRecursive(blocks-1, total+3);
        } else {
            return 0;
        }
    }
}
