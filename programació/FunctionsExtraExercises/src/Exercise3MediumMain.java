import java.util.Scanner;

public class Exercise3MediumMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introdueix el punt x1");
        int x1 = sc.nextInt();

        System.out.println("Introdueix el punt y1");
        int y2 = sc.nextInt();

        System.out.println("Introdueix el punt x2");
        int x2 = sc.nextInt();

        System.out.println("Introdueix el punt y2");
        int y1 = sc.nextInt();

        System.out.print("Distància és (x, y): ");
        int[] distanceOutput = distanceBetweenPoints(x1, y1, x2, y2);
        for (int i:distanceOutput) {
            System.out.print(i + " ");
        }
    }

    public static int[] distanceBetweenPoints(int x1, int y1, int x2, int y2) {
        return new int[]{Math.abs(x2 - x1), Math.abs(y2 - y1)};
    }
}
