package hashing;

import java.util.Arrays;
import java.util.HashSet;

public class SubArrayWithGivenSum {

    // Naive Solution
    static boolean findSubarray(int[] arr, int sum) {

        if (arr.length < 1)
            return false;


        for (int i = 0; i < arr.length; i++) {

            int currsum = 0;
            for (int j = i; j < arr.length; j++) {
                currsum = currsum + arr[j];

                if (currsum == sum)
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

            if (set.contains(prefix_sum - sum) || prefix_sum == sum)
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


        int[] arr1 = new int[]{5, 8, 6, 13, 3, -1};
        int sum = 22;

        printResult(arr1, sum);

        arr1 = new int[]{15, 2, 8, 10, -5, -8, 6};
        sum = 3;

        printResult(arr1, sum);

        arr1 = new int[]{3, 2, 5, 6};
        sum = 10;

        printResult(arr1, sum);

        arr1 = new int[]{1, 0, 3, 5, 6};
        sum = 0;

        printResult(arr1, sum);

        arr1 = new int[]{0, 1, 3, 5, 6};
        sum = 0;

        printResult(arr1, sum);

        arr1 = new int[]{0, 1, 2, 5, 6};
        sum = 20;

        printResult(arr1, sum);
    }
}
