package hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/***
 ** Longest Subarray with equal number of 0s and 1s
 ***/
public class LongestSubarrayWithEqualZerosAndOnes {

    // Naive Solution
    static int findLongestSubArrayWithEqualZerosAndOnes(int[] arr1) {

        int max_len = 0;

        if (arr1.length < 1)
            return 0;


        for (int i = 0; i < arr1.length; i++) {

            int co = 0, c1 = 0, maxLen;
            for (int j = i; j < arr1.length; j++) {

                if (arr1[j] == 0)
                    co++;
                else
                    c1++;

                if (co == c1) {
                    max_len = Math.max(c1 + co, max_len);
                }

            }

        }

        return max_len;
    }

    //Optimised Solution
    static int findLongestSubArrayWithEqualZerosAndOnes_(int[] nums) {

        int max_len = 0, prefix_sum = 0, sum = 0;

        if (nums.length < 1)
            return 0;

        Map<Integer, Integer> map = new HashMap<>();

        //Replace every zero with -1, then this problem would become similar to Longest Subaaray with given sum
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                nums[i] = -1;
        }

        for (int i = 0; i < nums.length; i++) {

            prefix_sum += nums[i];

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


    static void printResult(int[] arr1) {

        System.out.println(" Results Via Naive Approach");

        int[] temp = Arrays.copyOf(arr1,arr1.length);
        int op = findLongestSubArrayWithEqualZerosAndOnes(arr1);

        if (op > 0)
            System.out.println(" Result for Longest subarray inside Array  with e/q zeros and ones :" + Arrays.toString(arr1) + " is " + op);
        else
            System.out.println(" Result for Longest subarray inside Array  with e/q zeros and ones :" + Arrays.toString(arr1) + " is " + op);

        System.out.println(" Results Via Effcient Approach");

        op = findLongestSubArrayWithEqualZerosAndOnes_(temp);

        if (op > 0)
            System.out.println(" Result for Longest subarray inside Array  with e/q zeros and ones :" + Arrays.toString(arr1) + " is " + op);
        else
            System.out.println(" Result for Longest subarray inside Array  with e/q zeros and ones :" + Arrays.toString(arr1) + " is " + op);

        System.out.println(" *************************** ");
    }

    public static void main(String[] args) {

        int[] arr1 = new int[]{1, 0, 0, 0, 1, 1, 1};
        printResult(arr1);

        arr1 = new int[]{0, 1};
        printResult(arr1);

        arr1 = new int[]{1, 0, 1, 0, 1, 0};
        printResult(arr1);

        arr1 = new int[]{1, 1, 1, 1};
        printResult(arr1);

        arr1 = new int[]{1, 0, 1};
        printResult(arr1);
    }
}
