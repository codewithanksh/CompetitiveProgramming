package arrays.easy;

import java.util.Arrays;

/**
 * Program to reverse an array
 */
public class ReverseArray {

    static int[] reverseArray(int[] arr) {

        int end = arr.length - 1,start = 0;

        if(start == end)
            return arr;

        while (start < end) {
           swap(arr,start,end);
            start++;
            end--;
        }

        return arr;
    }

    static void reverseArrayUsingRecursion(int[] arr, int start, int end) {
        if(start >= end)
            return ;
        swap(arr,start,end);
        reverseArrayUsingRecursion(arr,start+1,end-1);
    }

    static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,1,1,1};
        reverseArray(arr);
        reverseArrayUsingRecursion(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
