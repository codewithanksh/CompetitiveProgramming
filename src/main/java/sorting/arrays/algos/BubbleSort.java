package sorting.arrays.algos;

import java.util.Arrays;

public class BubbleSort {

    public static void bubbleSort(int[] arr) {

        //Sorting in ascending order or natural sorting order
        // Time complexity is O(n*n)
        //In every pass we try to push largest number to its place and we do this iteratively
        //No of passed = n -1

        for (int i = 0; i < arr.length - 1; i++) {

            // if array is already sorted, one pass is enough to determine that. flag variable is introduced to figure that out
            boolean flag = false;
            for (int j = 0; j < arr.length - i - 1; j++) {

                // swap larger no with smaller number
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }

            }

            //exit if array become sorted in intermediatory stage
            if (!flag)
                break;


        }

        System.out.println("Sorted Array is " + Arrays.toString(arr));
    }

    /**
     * States of Array
     * Pass 1: i=0 {-1,4,12,14,12,15}
     * Pass 2: i=1 {-1,4,12,12,14,15}
     * Pass 3: i=2 {-1,4,12,12,14,15}
     * Pass 4: i=3 {-1,4,12,12,14,15}
     * Pass 5: i=4 {-1,4,12,12,14,15}
     **/
    public static void main(String[] args) {

        int[] arr = {12, -1, 4, 15, 14, 2};
        bubbleSort(arr);

        arr = new int[]{1, 2, 3, 4, 5};
        bubbleSort(arr);

    }
}
