import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>();
        colors.add("VERD");
        colors.add("BLAU");
        colors.add("NEGRE");
        colors.add("ROSA");
        colors.add("VERMELL");
        colors.add("TARONJA");
        colors.add("MARRÓ");
        colors.add("CYAN");

        colors.add(0, "GRIS");

        for (int i = 0; i < colors.size(); i++) {
            if (colors.get(i).equals("VERD")) {
                System.out.println(i);
            }
        }

        Collections.sort(colors);
        System.out.println(colors);

        //Collections.sort(colors, Collections.reverseOrder());
        Collections.reverse(colors);
        System.out.println(colors);

        Collections.shuffle(colors);
        System.out.println(colors);

        ArrayList<String> colors2 = new ArrayList<>();
        colors2 = colors;
        Collections.reverse(colors2);
        System.out.println(colors2);

        int index1 = 3;
        int index2 = 5;
        String elementToModify = colors.get(3);
        colors.remove(3);
        colors.add(index1, colors.get(5));
        colors.remove(5);
        colors.add(index2, elementToModify);
        System.out.println(colors);
        Collections.swap(colors, 3, 5);
        System.out.println(colors);

        colors.clear();

        ArrayList<String> colors3 = Collections.
    }
}