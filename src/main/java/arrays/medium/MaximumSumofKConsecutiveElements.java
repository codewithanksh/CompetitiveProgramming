package arrays.medium;

import java.util.Arrays;

/**
 * Maximum Sum of K Consecutive elements(Efficient)
 */
public class MaximumSumofKConsecutiveElements {

    // We can solve this problem using the sliding window technique and then compute the maximum sum from the array
    static int findMaxSumOfConsectiveElements(int[] arr, int k) {
        int max_sum = Integer.MIN_VALUE;

        if (arr.length < k)
            return max_sum;

        int curr_sum = 0;
        for (int i = 0; i < k; i++) {
            curr_sum += arr[i];
        }

        max_sum = curr_sum;

        for (int i = k; i + k - 1 < arr.length; i++) {
            curr_sum += arr[i] - arr[i - k];
            max_sum = Math.max(curr_sum, max_sum);
        }

        return max_sum;
    }

    // Given a sum, find if there exists a subarray of size k with a given sum
    static boolean evaluateArrayToFindSubArrayWithGivenSum(int[] arr, int k, int sum) {

        if (arr.length < k)
            return false;

        int curr_sum = 0;
        for (int i = 0; i < k; i++) {
            curr_sum += arr[i];
        }

        if(curr_sum == sum)
            return true;

        for (int i = k; i + k - 1 < arr.length; i++) {
            curr_sum += arr[i] - arr[i - k];

            if(curr_sum == sum)
                return true;

        }

        return false;
    }
//    static int findMaxSumOfConsectiveElements_(int[] arr) {
//        int max_sum = Integer.MIN_VALUE;
//
//        if (arr.length < k)
//            return max_sum;
//
//        int curr_sum = 0;
//        for (int i = 0; i < k; i++) {
//            curr_sum += arr[i];
//        }
//
//        for (int i = k; i + k - 1 < arr.length; i++) {
//            curr_sum += arr[i] - arr[i - k];
//            max_sum = Math.max(curr_sum, max_sum);
//        }
//
//        return max_sum;
//    }

    static void printResult(int[] arr, int k) {
        int sum = findMaxSumOfConsectiveElements(arr, k);

        if (sum == Integer.MIN_VALUE)
            System.out.println("No of elements in array are lesser than " + k);
        else
            System.out.printf("%s%s%s%d%s%d\n", "Maximum sum for array ", Arrays.toString(arr), " for consec. elements ", k, " is ", sum);

        boolean res = evaluateArrayToFindSubArrayWithGivenSum(arr,k,sum);

        if (res)
            System.out.printf("%s%d%s%d%s","Subarray of size ",k," with given sum ",sum," is found\n");
        else
            System.out.printf("%s%d%s%d%s","Subarray of size ",k," with given sum ",sum," is not found\n");

    }

    public static void main(String[] args) {
        int[] arr = {2, 3, -1, 4, 8, -15, 1};
        printResult(arr, 2);

        arr = new int[]{2, 3, -1, 4, 8, -15, 1};
        printResult(arr, 7);
    }
}
