package searching.binarysearch;

/***
 * Given a sorted array with repetition and an element x, we need to last index of first occurrence of x
 */
public class FindLastElementOccuranceInSortedArray {

    /***
     *
     * @param arr - Input Array
     * @param x - element to be searched
     * @return
     */
    static int lastOccurance(int[] arr, int x) {

        int low = 0, high = arr.length - 1, mid, last_occr = Integer.MIN_VALUE;

        while (low <= high) {

            mid = (low + high) / 2;

            if (arr[mid] == x) {

                if (mid == arr.length - 1 || arr[mid] != arr[mid + 1])
                    return mid;
                else {
                    last_occr = Math.max(last_occr, mid);
                    low = mid + 1;
                }
            } else if (arr[mid] > x)
                high = mid - 1;
            else {
                low = mid + 1;
            }
        }

        return last_occr != Integer.MIN_VALUE ? last_occr : -1;
    }

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

    static void printResult(int[] arr, int x) {
        System.out.println(" *** Results Via Non Recursive Approach ****");

        int res = lastOccurance(arr, x);
        if (res == -1)
            System.out.printf("%s\t%d\n", "Element not Available", x);
        else
            System.out.printf("%s %d %s %d\n", "Element", x, "available at maximum index", res);

        System.out.println(" *** Results Via Recursive Approach ****");

        res = lastOccurance_(arr, x, 0, arr.length - 1);
        if (res == -1)
            System.out.printf("%s\t%d\n", "Element not Available", x);
        else
            System.out.printf("%s %d %s %d\n", "Element", x, "available at maximum index", res);

        System.out.println(" ########################################");
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
