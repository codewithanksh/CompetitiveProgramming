package arrays.medium;

import java.util.Arrays;

public class MedianOfTwoArrays {

    static double findMedian(int[] arr1, int[] arr2) {
        double med = 0d;

        int totLen = arr1.length + arr2.length;
        int[] arr3 = new int[totLen];

        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length) {

            if (arr1[i] < arr2[j]) {
                arr3[k] = arr1[i];
                k++;
                i++;
            } else if (arr1[i] > arr2[j]) {
                arr3[k] = arr2[j];
                k++;
                j++;
            } else {
                arr3[k] = arr1[i];
                k++;
                arr3[k] = arr2[j];
                k++;
                i++;
                j++;
            }

        }

        if (i == arr1.length && j != arr2.length) { // elements in arr1 got exhausted

            while (k < arr3.length) {
                arr3[k] = arr2[j];
                k++;
                j++;
            }
        } else if (i != arr1.length && j == arr2.length) { // elements in arr2 got exhausted
            while (k < arr3.length) {
                arr3[k] = arr1[i];
                k++;
                i++;
            }
        }
        System.out.println("Input Array 1 : "+Arrays.toString(arr1));
        System.out.println("Input Array 2 : "+Arrays.toString(arr2));
        System.out.println("Final Combined Sorted Array : "+ Arrays.toString(arr3));

        if(arr3.length ==2)
            return arr3[1];

        return arr3.length % 2 == 0 ? (arr3[arr3.length / 2] + arr3[(arr3.length / 2) + 1]) / 2 : arr3[arr3.length / 2];
    }

    public static void main(String[] args) {
        int arr1[] = {1};
        int arr2[] = {0};
        System.out.println("Median : " + findMedian(arr1, arr2));

    }
}
