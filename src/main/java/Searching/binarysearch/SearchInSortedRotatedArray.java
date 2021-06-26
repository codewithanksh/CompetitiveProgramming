package Searching.binarysearch;

public class SearchInSortedRotatedArray {

    static int findElement(int[] arr, int x, int low, int high) {

        while (low <= high) {

            int mid = (low + high) / 2;

            if (arr[mid] == x)
                return mid;

            if (arr[low] <= arr[mid]) { // left half sorted
                if (x >= arr[low] && x < arr[mid]) {
                    // Search in the left half as element is present in left half
                    high = mid - 1;
                } else {
                    // Search in the right unsorted half as element is not present in left sorted half
                    low = mid + 1;
                }
            } else {
                // right half is sorted
                if (x > arr[mid] && x <= arr[high]) { // element is present in right sorted half
                    low = mid + 1;
                } else {
                    // element is present in left unsorted half as element is not present in right sorted half
                    high = mid - 1;
                }
            }
        }

        return -1;

    }

    static void printResult(int[] arr, int x) {


        int res = findElement(arr, x, 0, arr.length - 1);
        if (res == -1)
            System.out.printf("%s\t%d\n", "Element not Available", x);
        else
            System.out.printf("%s %d %s %d\n", "Element", x, "available at index", res);

        System.out.println(" ########################################");
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 1, 2, 3};
        printResult(arr, 2);

        arr = new int[]{10, 20, 30, 5, 4, 3};
        printResult(arr, 10);

        arr = new int[]{5, 10, 15, 20};
        printResult(arr, 25);

        arr = new int[]{5};
        printResult(arr, 5);

        arr = new int[]{5,5};
        printResult(arr, 5);

        arr = new int[]{10, 5};
        printResult(arr, 5);
    }
}
