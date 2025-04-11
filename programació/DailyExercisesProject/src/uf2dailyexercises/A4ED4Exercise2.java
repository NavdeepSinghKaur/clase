package uf2dailyexercises;

public class A4ED4Exercise2 {
    public static void main(String[] args) {
        int[] array1 = {1, 3, 5, 7, 9, 13, 15, 20};
        int[] array2 = {1, 3, 5, 50, 9, 13, 15};

        System.out.println("Cálcul iteratiu (1r, no és múltiple, 2n sí): ");
        System.out.println(is10xIterative(array1));
        System.out.println(is10xIterative(array2));

        System.out.println("\n" + "Cálcul recursiu  (1r, no és múltiple, 2n sí): ");
        System.out.println(is10xRecursive(array1, 0));
        System.out.println(is10xRecursive(array2, 0));
    }

    public static boolean is10xIterative(int[] array) {
        int j = 1;
        boolean returnValue = false;
        while (j < array.length) {
            if (array[j - 1] * 10 == array[j]) {
                returnValue = true;
            }
            j++;
        }
        return returnValue;
    }

    public static boolean is10xRecursive(int[] array, int j) {
        if (j < array.length -1) {
            if (array[j] * 10 == array[j + 1]) {
                return true;
            } else {
                return is10xRecursive(array, j + 1);
            }
        }
        else {
            return false;
        }
    }
}

