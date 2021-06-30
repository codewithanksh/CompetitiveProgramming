package hashing;

import java.util.*;

/**
 * Longest Consecutive Subsequence (x,x+1,x+2,x+3 .. }
 * Input : arr[] = {1,9,3,4,2,20}
 * Output : 4 , Longest Consecutive Subsequence would be {1,3,4,2}
 * <p>
 * Input : arr[] = {8,20,7,30}
 * Output : 2 , Longest Consecutive Subsequence would be {8,7}
 * <p>
 * Input : arr[] = {20,30,40}
 * Output : 1 , Longest Consecutive Subsequence {20} or {30} or {40}
 */
public class LongestConsecutiveSubsequence {

    // Naive Solution (O(nlogn))
    static int findLongestSubsequence(int[] arr) {

        if (arr.length == 1)
            return 1;

        int max_len = 1, curr_length = 1;

        Arrays.sort(arr);

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] == arr[i - 1] + 1) {
                curr_length++;
            } else if (arr[i] != arr[i - 1]) { // if arr[i] = arr[i-1], we would simply ignore the current element, i.e we will not process those elements
                curr_length = 1;
            }

            max_len = Math.max(curr_length, max_len);
        }

        return max_len;
    }

    //Optimised Solution (Time complexity is linear, since we're doing 2n looksups in hastable where n is size of hastable)
    static int findLongestSubArrayLength_(int[] arr) {


        if (arr.length == 1)
            return 1;

        int max_len = 1, curr_length = 1;

        Set<Integer> set = new HashSet<>();

        for (int i : arr)
            set.add(i);

        for (int i : set) {

            if (!set.contains(i - 1)) {
                int curr = 1;
                while (set.contains(i + curr))
                    curr++;

                max_len = Math.max(curr, max_len);

            }
        }


        return max_len;
    }

    static void printResult(int[] arr) {

        System.out.println(" Results Via Naive Approach");

        int op = findLongestSubsequence(arr);

        if (op > 0)
            System.out.println(" Result for Longest Subsequence inside Array :" + Arrays.toString(arr) + " is " + op);
        else
            System.out.println(" Result for Longest Subsequence inside Array :" + Arrays.toString(arr) + " is " + op);

        System.out.println(" Results Via Effcient Approach");

        op = findLongestSubArrayLength_(arr);

        if (op > 0)
            System.out.println(" Result for Longest Subsequence inside Array :" + Arrays.toString(arr) + " is " + op);
        else
            System.out.println(" Result for Longest Subsequence inside Array :" + Arrays.toString(arr) + " is " + op);

        System.out.println(" *************************** ");
    }

    public static void main(String[] args) {

        int[] arr = new int[]{1, 9, 3, 4, 2, 20};
        printResult(arr);

        arr = new int[]{8, 20, 7, 30};
        printResult(arr);

        arr = new int[]{1, 10, 100, 100};
        printResult(arr);

        arr = new int[]{1, 2, 4, 3, 2};
        printResult(arr);

        arr = new int[]{1, 2, 3, 3, 4};
        printResult(arr);

    }

}
