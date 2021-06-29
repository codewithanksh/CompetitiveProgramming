package hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Subarray with zero sum
 */
public class SubArrayWithZeroSum {

    // Naive Solution
    static boolean findSubarray(int[] arr, int sum) {

        if (arr.length < 1)
            return false;


        for (int i = 0; i < arr.length; i++) {

            int currsum = 0;
            for (int j = i; j < arr.length; j++) {
                currsum = currsum + arr[j];

                if (currsum == 0)
                    return true;
            }

        }
        return false;
    }

    // Prefix Sum Technique
    // Idea is to compute prefix sum at every index and store it in a HashSet
    // If at any index the prefix sum repeats itself, then we have a subarray that has provided zero result
    static boolean findSubarray_(int[] arr, int sum) {

        if (arr.length < 1)
            return false;


        int prefix_sum = 0;
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {

            prefix_sum = prefix_sum + arr[i];

            if (set.contains(prefix_sum))
                return true;

            set.add(prefix_sum);

        }
        return false;
    }

    static void printResult(int[] arr1, int sum) {
        boolean op = findSubarray(arr1, sum);

        System.out.println("Results via Naive Approach O(n*n)");

        if (op)
            System.out.println(" Result for Subarray inside Array :" + Arrays.toString(arr1) + " with required sum " + sum + " is " + op);
        else
            System.out.println(" Result for Subarray inside Array :" + Arrays.toString(arr1) + " with required sum " + sum + " is " + op);

        op = findSubarray_(arr1, sum);

        System.out.println("Results via Efficient Approach O(n)");

        if (op)
            System.out.println(" Result for Subarray inside Array :" + Arrays.toString(arr1) + " with required sum " + sum + " is " + op);
        else
            System.out.println(" Result for Subarray inside Array :" + Arrays.toString(arr1) + " with required sum " + sum + " is " + op);
    }

    public static void main(String[] args) {


        int[] arr1 = new int[]{1, 4, 13, -3, -10, 5};
        int sum = 0;

        printResult(arr1, sum);

        arr1 = new int[]{-1, 1, 0};
        sum = 0;

        printResult(arr1, sum);

        arr1 = new int[]{1, -2, 3, 5, 6};
        sum = 0;

        printResult(arr1, sum);

        arr1 = new int[]{1, 0, 3, 5, 6};
        sum = 0;

        printResult(arr1, sum);
    }
}