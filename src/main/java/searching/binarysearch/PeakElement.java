package searching.binarysearch;

/**
 * Program to find peak element in an array
 * <p>
 * Peak Element: An element which is greater or equal than it's neighbouring i-1 & i+1 elements
 * <p>
 * if i=0 i.e first element, it needs to be compared the immediately next element
 * if i=length i.e last element, it needs to be compared the immediately previous element
 */
public class PeakElement {

    // Binary Search
    static int peakElement_(int[] arr) {

        if (arr.length == 1) {
            System.out.println("Peak Element : " + arr[0]);
            return arr[0];
        }

        int low = 0, high = arr.length - 1, mid;


        while (low < high) {
            mid = low + (high - low) / 2;

            if (arr[mid] > arr[mid + 1])
                high = mid;
            else
                low = mid + 1;
        }

        return low;
    }

    // Linear Search
    static void peakElement(int[] arr) {

        if (arr.length == 1) {
            System.out.println("Peak Element : " + arr[0]);
            return;
        }

        int i = 0;
        if (arr[i] >= arr[i + 1])
            System.out.println("Peak Element : " + arr[i]);


        for (i = 1; i < arr.length - 1; i++) {

            if (arr[i] >= arr[i - 1] && arr[i] >= arr[i + 1])
                System.out.println("Peak Element : " + arr[i]);
        }

        if (i == arr.length - 1 && arr[i] >= arr[i - 1])
            System.out.println("Peak Element : " + arr[i]);

    }

    public static void main(String[] args) {
        int[] arr = {5, 10, 20, 17, 19};
        peakElement(arr);

        System.out.println("Next Input :");
        arr = new int[]{5, 10, 20};
        System.out.println(arr[peakElement_(arr)]);
    }
}
