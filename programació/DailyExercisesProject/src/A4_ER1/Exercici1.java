package A4_ER1;

public class Exercici1 {
    public static void main(String[] args) {
//        String[] combinations = letterComb("A", "B", "C");
//        int conuter = 1;
//        for (int i = 0; i < combinations.length; i++) {
//            System.out.println(combinations[i]);
//        }
        String[] letters = {"A", "B", "C"};
        String combination = "";
        combination = letterCombRecursive(letters, 0, 0, 0, combination);
        System.out.println(combination);
    }

    public static String[] letterComb(String letter1, String letter2, String letter3) {
        String[] combinations = new String[27];

        int i = 0;
        int j = 0;
        int k = 0;
        int l = 0;
        String[] letters = new String[]{letter1, letter2, letter3};
        while (i < 3) {
            String combination = "";
            combination += letters[i];
            combination += letters[j];
            combination += letters[k];
            combinations[l] = combination;

            l++;
            if (j == 2 && k == 2) {
                j = 0;
                k = 0;
                i++;
            } else if (k == 2) {
                k = 0;
                j++;
            } else {
                k++;
            }

        }

        return combinations;
    }

    public static String letterCombRecursive(String[] letters, int i, int j, int k, String combination) {
        if (i== 2 && j == 2 && k == 2) {
            return combination = "CCC";
        } else if (j == 2 && k == 2) {
            return combination = letters[i] + letters[j] + letters[k] + "\n" + letterCombRecursive(letters, i+1, j-2, k-2, combination);
        } else if (k == 2) {
            return combination = letters[i] + letters[j] + letters[k] + "\n" + letterCombRecursive(letters, i, j+1, k-2, combination);
        } else {
            return combination = letters[i] + letters[j] + letters[k] + "\n" + letterCombRecursive(letters, i, j, k+1, combination);
        }
    }

}
