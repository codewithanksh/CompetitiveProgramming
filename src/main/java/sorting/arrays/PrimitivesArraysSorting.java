package sorting.arrays;

import java.util.Arrays;
import java.util.Collections;

public class PrimitivesArraysSorting {

    public static void main(String[] args) {

        int[] arr = {3, 12, 67, 1, 87};
        sortCompleteArray(arr);

        arr = new int[]{23, 12, 67, 1, 87};
        sortSubArray(arr, 0, 3);
    }

    static void sortCompleteArray(int[] arr) {
        Arrays.sort(arr);
        System.out.println("Completely Sorted Array " + Arrays.toString(arr));
        reverseArray(arr);
        System.out.println("Reverse Order: " + Arrays.toString(arr));
    }

    static void sortSubArray(int[] arr, int start, int end) {
        Arrays.sort(arr, start, end);
        System.out.println("Subaaray sorted b/w " +start + " && end " + end +" is "+Arrays.toString(arr));
    }

    static void reverseArray(int[] arr) {
        int low = 0, high = arr.length - 1;

        while (low < high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }
}
