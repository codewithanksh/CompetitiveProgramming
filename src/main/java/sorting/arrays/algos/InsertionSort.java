package sorting.arrays.algos;

import java.util.Arrays;

public class InsertionSort {

    public static void insertionSort(int[] arr) {

        //Sorting in ascending order or natural sorting order
        // Time complexity is O(n*n)
        // In-place algorithms, stable algorithm
        // Algorithm maintains a sorted array in left half and considers a target element which needs to be inserted into the sorted array
        // In every pass, we try to fit the target element into the sorted array
        //
        // No of passed = n -1

        for (int i = 1; i < arr.length; i++) {

            // Let's assume current element is the smallest element in the array
            int j = i;

            //Inserting target element at Ith index into the already sorted half
            while (j >= 1 && arr[j] < arr[j - 1]) {

                //Swap smaller element with larget element
                int temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
                j--;
            }

            System.out.println("Array after pass " + i + " is " + Arrays.toString(arr));
        }

        System.out.println("Sorted Array is " + Arrays.toString(arr));
    }

    /**
     * States of Array
     * Array after pass 1 is [-1, 12, 4, 15, 14, 2]
     * Array after pass 2 is [-1, 4, 12, 15, 14, 2]
     * Array after pass 3 is [-1, 4, 12, 15, 14, 2]
     * Array after pass 4 is [-1, 4, 12, 14, 15, 2]
     * Array after pass 5 is [-1, 2, 4, 12, 14, 15]
     **/
    public static void main(String[] args) {

        int[] arr = {12, -1, 4, 15, 14, 2};
        insertionSort(arr);

        arr = new int[]{1, 2, 3, 4, 5};
        insertionSort(arr);

    }
}
