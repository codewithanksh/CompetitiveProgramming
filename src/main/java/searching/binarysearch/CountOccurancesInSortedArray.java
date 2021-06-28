package searching.binarysearch;

/**
 * Given a sorted array and an element x, we need to count occurrences of x in the array.
 */
public class CountOccurancesInSortedArray {

    static int lastOccurance_(int[] arr, int x, int low, int high) {

        if (low > high)
            return -1;

        int mid = (low + high) / 2;

        if (arr[mid] > x)
            return lastOccurance_(arr, x, low, mid - 1);
        else if (arr[mid] < x)
            return lastOccurance_(arr, x, mid + 1, high);
        else {
            int res = lastOccurance_(arr, x, low, mid - 1);
            return res == -1 ? mid : Math.max(mid, res);
        }

    }

    static int firstOccurance(int[] arr, int x) {

        int count = 0, low = 0, high = arr.length - 1, mid, least_occurance = Integer.MAX_VALUE;

        while (low <= high) {

            mid = (low + high) / 2;

            if (arr[mid] == x) {
                if (mid == 0 || arr[mid] != arr[mid - 1]) {
                    least_occurance = Math.min(mid, least_occurance);
                    break;
                } else {
                    least_occurance = Math.min(mid, least_occurance);
                    high = mid - 1;
                }
            } else if (arr[mid] > x)
                high = mid - 1;
            else
                low = mid + 1;

        }

        return least_occurance == Integer.MAX_VALUE ? -1 : least_occurance;
    }

    static int lastOccurance(int[] arr, int x) {

        int count = 0, low = 0, high = arr.length - 1, mid, highest_occurance = Integer.MIN_VALUE;

        while (low <= high) {

            mid = (low + high) / 2;
            if (arr[mid] == x) {
                if (mid == arr.length - 1 || arr[mid] != arr[mid + 1]) {
                    highest_occurance = Math.max(mid, highest_occurance);
                    break;
                } else {
                    highest_occurance = Math.max(mid, highest_occurance);
                    low = mid + 1;
                }

            } else if (arr[mid] > x)
                high = mid - 1;
            else
                low = mid + 1;

        }

        return highest_occurance == Integer.MIN_VALUE ? -1 : highest_occurance;
    }

    static int countOccurance(int[] arr, int x) {
        int first_occ = firstOccurance(arr, x);

        if (first_occ == -1)
            return -1;

        int last_occ = lastOccurance(arr, x);

        return last_occ - first_occ + 1;
    }

    static void printResult(int[] arr, int x) {
        System.out.println(" *** Results Via Non Recursive Approach ****");

        int res = countOccurance(arr, x);
        if (res == -1)
            System.out.printf("%s\t%d\n", "Element not Available", x);
        else
            System.out.printf("%s %d %s %d\n", "Element", x, "count", res);

    }

    public static void main(String[] args) {
        int[] arr = {1, 10, 10, 10, 10, 20, 40};
        printResult(arr, 10);

        arr = new int[]{5, 5, 5};
        printResult(arr, 5);

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
