package sorting.arrays.algos;

import java.util.Arrays;

public class  SelectionSort {

    public static void selectionSort(int[] arr) {

        //Sorting in ascending order or natural sorting order
        // Time complexity is O(n*n)
        // In-place algorithms, Unstable algorithm
        // Lesser no of memory rides, ideal for Memories where writing is a costly operation like EEPROM / Hard disk
        //In every pass we try to push smallest number to its place and we do this iteratively
        //As a result subarray from starting postion to k where K>=0 become sorted,
        // No of passed = n -1

        for (int i = 0; i < arr.length - 1; i++) {

            // Let's assume current element is the smallest element in the array
            int min_indx = i;

            //Selecting the smallest element from the unsorted sub-array
            for (int j = i + 1; j < arr.length; j++) {

                // find the smallest element in the unsorted array
                if (arr[j] < arr[min_indx])
                    min_indx = j;
            }

            //Swap ith element with the mimimum element
            int temp = arr[i];
            arr[i] = arr[min_indx];
            arr[min_indx] = temp;

            System.out.println("Array after pass " + i + " is " + Arrays.toString(arr));
        }

        System.out.println("Sorted Array is " + Arrays.toString(arr));
    }

    /**
     * States of Array
     Array after pass 0 is [-1, 12, 4, 15, 14, 2]
     Array after pass 1 is [-1, 2, 4, 15, 14, 12]
     Array after pass 2 is [-1, 2, 4, 15, 14, 12]
     Array after pass 3 is [-1, 2, 4, 12, 14, 15]
     Array after pass 4 is [-1, 2, 4, 12, 14, 15]
     **/
    public static void main(String[] args) {

        int[] arr = {12, -1, 4, 15, 14, 2};
        selectionSort(arr);

        arr = new int[]{1, 2, 3, 4, 5};
        selectionSort(arr);

    }
}
