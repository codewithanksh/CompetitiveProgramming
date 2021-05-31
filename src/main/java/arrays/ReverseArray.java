package arrays;

import java.util.Arrays;

/*
Date : 18/05/2021
Program to reverse an array
 */
public class ReverseArray {


    public static int[] reverseArray(int[] arr) {
     int start = 0, end = arr.length - 1, temp = 0;

        while(start < end) {
            temp  = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

        return arr;
    }

    public static void reverseArrayUsingRecursion(int[] arr,int start, int end) {
        int temp;

        if(start >= end) {
            return;
        }

        temp  = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;

        reverseArrayUsingRecursion(arr,start+1,end - 1);


    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4};
        reverseArray(arr);
        System.out.println(Arrays.toString(arr));
        //reverseArrayUsingRecursion(arr,0,arr.length-1);
        //System.out.println(Arrays.toString(arr));

    }


  // 1 2 3 4 5 6
    //len : 2,
  // 5 4 3 2 1
}
