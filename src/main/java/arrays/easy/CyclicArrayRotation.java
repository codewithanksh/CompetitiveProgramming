package arrays.easy;

import java.util.Arrays;

/**
 * Date : 18/05/2021
 * Program to cyclically rotate an array by one
 * Input:  arr[] = {1, 2, 3, 4, 5}
 * Output: arr[] = {5, 1, 2, 3, 4}
 *
 * O(n)
 */
public class CyclicArrayRotation {

    static void rotateArrayByOne(int[]arr) {

        if(arr.length == 1 || arr.length == 0)
            return;

        int lastEle = arr[arr.length - 1];

        for(int i= arr.length - 1; i >0; i-- ) {
            arr[i] = arr[i-1];
        }

        arr[0] = lastEle;

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 4, 5};
        rotateArrayByOne(arr);
    }
}
