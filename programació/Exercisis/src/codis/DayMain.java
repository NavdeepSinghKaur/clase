package codis;


import java.util.Scanner;

public class DayMain {
    public static void main(String[] args) {
    	String[] days = {"Primer dia de la setmana", "Segon dia de la setmana", "Tercer dia de la setmana", "Quart dia de la setmana", "Cinquè dia de la setmana"};
        Scanner keyboard = new Scanner(System.in);
        byte nday;

        nday = keyboard.nextByte();
        keyboard.close();
        try { 
        	System.out.println(days[nday-1]);
        }
        catch (Exception e) {
        	System.out.println("Aquest dia no existeix");
        }
    }
}

