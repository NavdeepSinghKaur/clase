/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises.maps;

import java.util.Random;

/**
 *
 * @author milana
 */
public class RandomTuple implements Comparable<RandomTuple>{
    
    private int number;
    private String str;
    private static final String ALPHANUMERIC="abvdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRTSUVWXYZ0123456789";
    
    public RandomTuple() {
        Random rand1 = new Random();
        Random rand2 = new Random();

        this.number = rand1.nextInt();
        
        int pos = 0;
        int strSize = rand1.nextInt(16) + 6;
        this.str = new String();
        for(int i=0; i<strSize; i++) {
            pos = rand2.nextInt(RandomTuple.ALPHANUMERIC.length());
            this.str += RandomTuple.ALPHANUMERIC.charAt(pos);
        }
    }
    
    public String toString() {
        return "<" + this.number + ", " + this.str + ">";
    }

    public int compareTo(RandomTuple o) {
        int returnValue = 0;
        if (this.str != o.str) {
            returnValue = this.str.compareTo(o.str);
        }
        if (returnValue == 0) {
            returnValue = this.number - o.number;
        }

        return returnValue;
    }
}
