package hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Pair with given sum in unsorted array
 */
public class PairWithGivenSum {

    static boolean findPair(int[] arr1, int sum) {

        Set<Integer> set = new HashSet<Integer>();

        if (arr1.length < 2)
            return false;


        for (int i = 0; i < arr1.length; i++) {

            if (i > 0 && set.contains(sum - arr1[i]))
                return true;

            set.add(arr1[i]);
        }


        return false;
    }

    static void printResult(int[] arr1, int sum) {
        boolean op = findPair(arr1, sum);

        if (op)
            System.out.println(" Result for Pair inside Array :" + Arrays.toString(arr1) + " with required sum " + sum + " is " + op);
        else
            System.out.println(" Result for Pair inside Array :" + Arrays.toString(arr1) + " with required sum " + sum + " is " + op);
    }

    public static void main(String[] args) {

        int[] arr1 = new int[]{1, 2, 2, 3};
        int sum = 3;

        printResult(arr1, sum);

        arr1 = new int[]{-1, 1, 1};
        sum = 0;

        printResult(arr1, sum);

        arr1 = new int[]{1, 2, -3};
        sum = -1;

        printResult(arr1, sum);
    }
}
