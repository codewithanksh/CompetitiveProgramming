package arrays.medium;

/**
 * Maximum Difference Problem in Order
 */
public class MaximumDifferenceProblemInOrder {

    static int findMaxDifference(int[] arr){
        int max_diff = Integer.MIN_VALUE;
        int min_val = arr[0];

        for(int i=1; i < arr.length; i++) {
            max_diff = Math.max(max_diff,arr[i] - min_val);
            min_val = Math.min(min_val,arr[i]);
        }
        return max_diff;
    }
    public static void main(String[] args) {
        int[] arr = {2,3,10,6,4,8,1};
        System.out.println(findMaxDifference(arr));

        arr = new int[]{7, 9, 5, 6, 3, 2};
        System.out.println(findMaxDifference(arr));

        arr = new int[]{10, 20, 30};
        System.out.println(findMaxDifference(arr));

        arr = new int[]{30, 20, 10};
        System.out.println(findMaxDifference(arr));
    }

}
