package hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestCommonSpanWithSameSumInBinaryArray {

    // Naive Solution
    static int findLongestSubArrayLength(int[] arr1, int[] arr2) {

        int max_len = 0;

        if (arr1.length != arr2.length)
            return 0;


        for (int i = 0; i < arr1.length; i++) {

            int curr_sum1 = 0, curr_sum2 = 0;
            for (int j = i; j < arr1.length; j++) {

                curr_sum1 += arr1[j];
                curr_sum2 += arr2[j];
                if (curr_sum1 == curr_sum2) {
                    max_len = Math.max(j - i + 1, max_len);
                }

            }

        }

        return max_len;
    }

    //Optimised Solution
    static int findLongestSubArrayLength_(int[] arr1, int[] arr2) {

        int max_len = 0, prefix_sum = 0;

        if (arr1.length != arr2.length)
            return 0;

        int[] temp = new int[arr1.length];

        for(int i=0; i < arr1.length; i++)
            temp[i] = arr1[i] - arr2[i];

        // Map to store prefix sum as Key and the index as value
        // Don't update the value if same prefix_sum occurs again as it would help us in getting the longest subaaray
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;

        for (int i = 0; i < temp.length; i++) {

            prefix_sum += temp[i];

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

    static void printResult(int[] arr1, int[] arr2) {

        System.out.println(" Results Via Naive Approach");

        int op = findLongestSubArrayLength(arr1, arr2);

        if (op > 0)
            System.out.println(" Result for Longest subarray inside Array :" + Arrays.toString(arr1) + " with Another Array " + Arrays.toString(arr2) + " is " + op);
        else
            System.out.println(" Result for Longest subarray Array :" + Arrays.toString(arr1) + "with Another Array " + Arrays.toString(arr2) + " is " + op);

        System.out.println(" Results Via Effcient Approach");

        op = findLongestSubArrayLength_(arr1, arr2);

        if (op > 0)
            System.out.println(" Result for Longest subarray inside Array :" + Arrays.toString(arr1) + " with Another Array " + Arrays.toString(arr2) + " is " + op);
        else
            System.out.println(" Result for Longest subarray Array :" + Arrays.toString(arr1) + "with Another Array " + Arrays.toString(arr2) + " is " + op);

        System.out.println(" *************************** ");
    }

    public static void main(String[] args) {

        int[] arr1 = new int[]{0, 1, 0, 0, 0, 0};
        int[] arr2 = new int[]{1, 0, 1, 0, 0, 1};
        printResult(arr1, arr2);

        arr1 = new int[]{1, 0, 1, 0};
        arr2 = new int[]{1, 0, 1, 0};
        printResult(arr1, arr2);

        arr1 = new int[]{1, 1, 1, 1};
        arr2 = new int[]{0, 0, 0, 0};
        printResult(arr1, arr2);

        arr1 = new int[]{0, 0, 0, 0};
        arr2 = new int[]{1, 0, 1, 1};
        printResult(arr1, arr2);

    }
}
