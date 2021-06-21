package Searching.binarysearch;

/**
 * Searching an element in a sorted array
 */
public class BinarySearch {

    /***
     *
     * @param arr - Input Array
     * @param x - element to be searched
     * @return
     */
    static int binarySearch(int[] arr, int x) {

        int low = 0, high = arr.length - 1, mid;

        while (low <= high) {

            mid = (low + high) / 2;

            if (arr[mid] == x)
                return mid;
            else if (arr[mid] > x)
                high = mid - 1;
            else
                low = mid + 1;
        }

        return -1;
    }

    static int binarySearch_(int[] arr, int x, int low, int high) {

        if (low > high)
            return -1;

        int mid = (low + high) / 2;

        if (arr[mid] > x)
            return binarySearch_(arr, x, low, mid - 1);
        else if (arr[mid] < x)
            return binarySearch_(arr, x, mid + 1, high);
        else
            return mid;

    }


    static void printResult(int[] arr, int x) {

        System.out.println(" *** Results Via Non Recursive Approach ****");

        if (binarySearch(arr, x) == -1)
            System.out.printf("%s\t%d\n", "Element not Available", x);
        else
            System.out.printf("%s\t%d\n", "Element Available", x);

        System.out.println(" *** Results Via Recursive Approach ****");

        if (binarySearch_(arr, x, 0, arr.length - 1) == -1)
            System.out.printf("%s\t%d\n", "Element not Available", x);
        else
            System.out.printf("%s\t%d\n", "Element Available", x);

        System.out.println(" ########################################");
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        printResult(arr, 2);

        arr = new int[]{5, 15, 25};
        printResult(arr, 25);

        arr = new int[]{5, 10, 15, 20};
        printResult(arr, 25);

        arr = new int[]{5};
        printResult(arr, 25);

        arr = new int[]{5};
        printResult(arr, 5);

        arr = new int[]{5, 10};
        printResult(arr, 10);
    }
}
