package hashing;

import java.util.*;

/**
 * Longest subarray with given sum
 */
public class LongestSubarrayWithGivenSum {

    // Naive Solution
    static int findLongestSubArrayLength(int[] arr1, int sum) {

        int max_len = 0;

        if (arr1.length < 1)
            return 0;


        for (int i = 0; i < arr1.length; i++) {

            int curr_sum = 0;
            for (int j = i; j < arr1.length; j++) {

                curr_sum += arr1[j];
                if (curr_sum == sum) {
                    max_len = Math.max(j - i + 1, max_len);
                }

            }

        }

        return max_len;
    }

    //Optimised Solution
    static int findLongestSubArrayLength_(int[] arr1, int sum) {

        int max_len = 0, prefix_sum = 0;

        if (arr1.length < 1)
            return 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr1.length; i++) {

            prefix_sum += arr1[i];

            if (prefix_sum == sum) {
                max_len = i + 1;
            } else if (map.containsKey(prefix_sum - sum)) {
                max_len = Math.max(max_len, i - map.get(prefix_sum - sum));
            }

            if (!map.containsKey(prefix_sum))
                map.put(prefix_sum, i);
        }

        return max_len;
    }


    static void printResult(int[] arr1, int sum) {

        System.out.println(" Results Via Naive Approach");

        int op = findLongestSubArrayLength(arr1, sum);

        if (op > 0)
            System.out.println(" Result for Longest subarray inside Array :" + Arrays.toString(arr1) + " with required sum " + sum + " is " + op);
        else
            System.out.println(" Result for Longest subarray Array :" + Arrays.toString(arr1) + " with required sum " + sum + " is " + op);

        System.out.println(" Results Via Effcient Approach");

        op = findLongestSubArrayLength_(arr1, sum);

        if (op > 0)
            System.out.println(" Result for Longest subarray inside Array :" + Arrays.toString(arr1) + " with required sum " + sum + " is " + op);
        else
            System.out.println(" Result for Longest subarray Array :" + Arrays.toString(arr1) + " with required sum " + sum + " is " + op);

        System.out.println(" *************************** ");
    }

    public static void main(String[] args) {

        int[] arr1 = new int[]{1, 2, 2, 3, 1, 1, 1};
        int sum = 3;

        printResult(arr1, sum);

        arr1 = new int[]{-1, 1, 1, -3, 3};
        sum = 2;

        printResult(arr1, sum);

        arr1 = new int[]{1, 2, -3, -1, 1};
        sum = -1;

        printResult(arr1, sum);

        arr1 = new int[]{1, 1, 1, 1};
        sum = 3;

        printResult(arr1, sum);

        arr1 = new int[]{-1, 1};
        sum = 3;

        printResult(arr1, sum);
    }
}
