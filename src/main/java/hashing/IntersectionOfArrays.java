package hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Intersection of two arrays i.e in other words find the distinct common elements
 * between both the arrays
 */

public class IntersectionOfArrays {

    static int findIntersection(int[] arr1, int[] arr2) {

        int res = 0;
        Set<Integer> set = new HashSet<Integer>();

        for (int i : arr1)
            set.add(i);


        for (int i : arr2) {
            if (set.contains(i)) {
                res++;
                set.remove(i);
            }
        }

        return res;
    }

    static void printResult(int[] arr1, int[] arr2) {
        int op = findIntersection(arr1, arr2);
        System.out.println(" Result for Intersection of Arrays :" + Arrays.toString(arr1) + " && " + Arrays.toString(arr2) + " is " + op);
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 2, 3};
        int[] arr2 = new int[]{1, 2, 2, 5};

        printResult(arr1, arr2);

        arr1 = new int[]{1, 1, 1};
        arr2 = new int[]{1, 1};

        printResult(arr1, arr2);

        arr1 = new int[]{1, 2, 3};
        arr2 = new int[]{4, 5};

        printResult(arr1, arr2);
    }
}
