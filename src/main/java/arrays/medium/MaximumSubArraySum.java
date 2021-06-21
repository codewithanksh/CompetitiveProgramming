package arrays.medium;

/**
 * All the approaches to find Maximum Subarray Sum
 * 1. Naive Solution
 * 2. Kadane's Algorithm
 */
public class MaximumSubArraySum {

    static int findMaxSubbary(int[] arr) {
        int max_sum = arr[0], curr_max = 0;

        for (int i = 0; i < arr.length; i++) {
            curr_max = 0;
            for (int j = i; j < arr.length; j++) {

                curr_max = curr_max + arr[j];
                max_sum = Math.max(curr_max, max_sum);

            }
        }
        return max_sum;
    }

    static int findMaxSubbaryKadanesAlgo(int[] arr) {
        int max_sum = arr[0], max_ending = arr[0];

        for (int i = 1; i < arr.length; i++) {
            max_ending = Math.max(max_ending+arr[i],arr[i]);
            max_sum = Math.max(max_ending,max_sum);
        }
        return max_sum;
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5};
        System.out.println(findMaxSubbary(input));

        input = new int[]{1, 2, -3, 8, 9};
        System.out.println(findMaxSubbary(input));

        input = new int[]{-6, -8, -1};
        System.out.println(findMaxSubbary(input));

        input = new int[]{1, 2, 3, 4, 5};
        System.out.println(findMaxSubbaryKadanesAlgo(input));

        input = new int[]{1, 2, -3, 8, 9};
        System.out.println(findMaxSubbaryKadanesAlgo(input));

        input = new int[]{-6, -8, -1};
        System.out.println(findMaxSubbaryKadanesAlgo(input));
    }


}
