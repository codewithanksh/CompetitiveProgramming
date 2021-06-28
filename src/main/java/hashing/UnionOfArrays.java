package hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * To find Union of two unsorted arrays
 */
public class UnionOfArrays {

    static int findUnion(int[] arr1, int[] arr2) {
        
        Set<Integer> set = new HashSet<Integer>();

        for (int i : arr1)
            set.add(i);


        for (int i : arr2)
            set.add(i);

        return set.size();
    }

    static void printResult(int[] arr1, int[] arr2) {
        int op = findUnion(arr1, arr2);
        System.out.println(" Result for Union of Arrays :" + Arrays.toString(arr1) + " && " + Arrays.toString(arr2) + " is " + op);
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 2, 3};
        int[] arr2 = new int[]{1, 2, 5};

        printResult(arr1, arr2);

        arr1 = new int[]{1, 1, 1};
        arr2 = new int[]{1, 1};

        printResult(arr1, arr2);

        arr1 = new int[]{1, 2, 3};
        arr2 = new int[]{4, 5};

        printResult(arr1, arr2);
    }

}
