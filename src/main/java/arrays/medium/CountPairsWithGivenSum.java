package arrays.medium;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Count pairs with given sum
 * Given an array of integers, and a number ‘sum’, find the number of pairs of integers in the array whose sum is equal to ‘sum’
 * <p>
 * Input  :  arr[] = {1, 5, 7, -1},
 * sum = 6
 * Output :  2
 * Pairs with sum 6 are (1, 5) and (7, -1)
 * <p>
 * Input  :  arr[] = {1, 5, 7, -1, 5},
 * sum = 6
 * Output :  3
 * Pairs with sum 6 are (1, 5), (7, -1) &
 * (1, 5)
 * <p>
 * Input  :  arr[] = {1, 1, 1, 1},
 * sum = 2
 * Output :  6
 * There are 3! pairs with sum 2.
 * <p>
 * Input  :  arr[] = {10, 12, 10, 15, -1, 7, 6,
 * 5, 4, 2, 1, 1, 1},
 * sum = 11
 * Output :  9
 */
public class CountPairsWithGivenSum {


    static int pairs(int[] arr, int sum) {

        int pairs = 0;

        // Store counts of all elements in map m
        HashMap<Integer,Integer> mp = new HashMap<Integer,Integer>();

        // Traverse through all elements
        for(int i = 0; i < arr.length; i++) {

            // Search if a pair can be formed with arr[i]
            int rem = sum - arr[i];
            if (mp.containsKey(rem)) {
                int count = mp.get(rem);

                for(int j = 0; j < count; j++) {
                    System.out.print("(" + rem + ", " + arr[i] + ")" + "\n");
                    pairs++;
                }
            }

            if (mp.containsKey(arr[i])) {
                mp.put(arr[i], mp.get(arr[i]) + 1);
            }
            else {
                mp.put(arr[i], 1);
            }

            System.out.println(mp);
        }
        return pairs;
    }



    public static void main(String[] args) {
        int arr[] = {1, 5, 7, 1};
        int sum = 6;

        System.out.println("\nCount of Pairs :" + pairs(arr, sum));
    }
}
