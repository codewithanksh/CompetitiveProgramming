package arrays.hard;

import java.util.Arrays;

public class SlidingWindowTechnique {

    static class WindowSlidingFixedSize {

        /**
         * Given an array of integers and number k, find the maximum sum of k consective elements
         * Time complexity : O(n)
         *
         * @param arr
         * @param k
         * @return
         */
        static int findMaxSum(int[] arr, int k) {

            int curr_sum = 0;

            if (k > arr.length)
                return -1;

            for (int i = 0; i < k; i++) {
                curr_sum += arr[i];
            }

            int max_sum = curr_sum;

            for (int i = k; i < arr.length; i++) {
                curr_sum += (arr[i] - arr[i - k]);
                max_sum = Math.max(curr_sum, max_sum);
            }

            return max_sum;
        }

        /***
         * Given an array of integers and number k, find a subarray of size k with the given target sum
         * @param arr
         * @param k
         * @return
         */
        static boolean findSubarray(int[] arr, int k, int sum) {

            int curr_sum = 0;

            if (k > arr.length)
                return false;

            for (int i = 0; i < k; i++) {
                curr_sum += arr[i];
            }

            if (curr_sum == sum)
                return true;

            for (int i = k; i < arr.length; i++) {
                curr_sum += arr[i] - arr[i - k];
                if (curr_sum == sum)
                    return true;
            }

            return false;
        }

        static void printOutput(int[] arr, int k) {

            int op = findMaxSum(arr, k);

            if (op != -1)
                System.out.println("Maximum sum of " + k + " consective elements for array: " + Arrays.toString(arr) + " is " + op);
            else
                System.err.println("Invalid input passed for array: " + Arrays.toString(arr) + " or K " + k);
        }

        static void printOutput(int[] arr, int k, int sum) {

            boolean op = findSubarray(arr, k, sum);

            if (op)
                System.out.println("Subarray of " + k + " consective elements for array: " + Arrays.toString(arr) + " with sum, " + sum + " is " + op);
            else
                System.out.println("Subarray of " + k + " consective elements for array: " + Arrays.toString(arr) + " with sum, " + sum + " is " + op);
        }


    }

    static class WindowSlidingWithoutSize {

        /***
         * This problem can be solved using window sliding technique.
         * @param arr
         * @param sum
         * @return
         */
        static boolean findSum(int[] arr, int sum) {

            // Appproach : We'll maintain two pointers, start which would be poingting to the start index of window
            // end, which would be pointing to (current element - 1), where current element is the one ready to included
            // into the window
            int curr_sum = arr[0], start = 0, i;

            for (i = 1; i <= arr.length; i++) { //

                // Next Step : Clean previous window if current sum is greater than required sum
                // Remove elements if current sum is greater than the required sum
                while (curr_sum > sum && start < i - 1) {
                    curr_sum -= arr[start];
                    start++;
                }

                // exit if current sum become equal to the required sum
                if (curr_sum == sum) {
                    System.out.println("Found elements from index " + (start - 1) + " to index " + i);
                    return true;
                }

                // Add current element to the window
                if (i < arr.length)
                    curr_sum += arr[i];


            }

            return curr_sum == sum;


        }

        static void printOutput(int[] arr, int sum) {

            boolean op = findSum(arr, sum);

            if (op)
                System.out.println("consective elements for array: " + Arrays.toString(arr) + " with sum, " + sum + " is " + op);
            else
                System.out.println("consective elements for array: " + Arrays.toString(arr) + " with sum, " + sum + " is " + op);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 8, 30, -5, 20, 7};
        int k = 3;

        WindowSlidingFixedSize.printOutput(arr, k);
        WindowSlidingFixedSize.printOutput(arr, k, WindowSlidingFixedSize.findMaxSum(arr, k));
        WindowSlidingFixedSize.printOutput(arr, k, 1000);

        arr = new int[]{1};
        k = 3;

        WindowSlidingFixedSize.printOutput(arr, k);
        WindowSlidingFixedSize.printOutput(arr, k, 1000);

        arr = new int[]{1, 8, 30, -5, 20, 7};
        WindowSlidingWithoutSize.printOutput(arr, 45);


    }


}
