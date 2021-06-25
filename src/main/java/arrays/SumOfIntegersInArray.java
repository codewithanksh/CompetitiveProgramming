package arrays;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * int[] array = {1,2,3,4,5}
 * int sum = 6
 * Find all the possible pairs of 2 numbers and return an array of them
 */
public class SumOfIntegersInArray {

    static int[] array = {1,3,3,4,2};
    static int expSum = 4;

    public static void main(String[] args) {
        solveByTwoForLoops();
        String s = "";
        byte[] ba = s.getBytes();

        for(int i=0; i < ba.length; i++) {

        }

    }

    // Complexity of O(n*n)
    public static void solveByTwoForLoops() {
        int currentSum = -100000;

        for (int i = 0; i < (array.length - 1); i++) {

            for (int j = (i + 1); j < array.length; j++) {

                currentSum = array[i] + array[j];
                if (currentSum == expSum) {
                    System.out.print("{" + array[i] + "," + array[j] + "}");
                    System.out.print(" ");
                }
            }
        }

    }


    public static void solveUsingHashMap() {

        HashMap<Character,Integer> hmap = new LinkedHashMap<>();

        for(int i=0; i< array.length; i++){

        }
    }
}
