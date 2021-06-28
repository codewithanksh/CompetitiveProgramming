package searching.binarysearch;

/**
 * Given a sorted binary array, we need to count 1s in this array
 */
public class FindNoOfOnesInBinaryArray {


    static int countTarget(int[] arr, int x) {

        int first_occ = firstOccurance(arr,1);

        return first_occ == -1 ? 0 : arr.length - first_occ;
    }

    static int firstOccurance(int[] arr, int x) {

        int count = 0, low = 0, high = arr.length - 1, mid, least_occurance = Integer.MAX_VALUE;

        while (low <= high) {

            mid = (low + high) / 2;

            if (arr[mid] == 0) {
                low = mid + 1;
            } else {
                if (mid == 0 || arr[mid] != arr[mid - 1]) {
                    least_occurance = Math.min(mid, least_occurance);
                    break;
                } else {
                    least_occurance = Math.min(mid, least_occurance);
                    high = mid - 1;
                }
            }

        }

        return least_occurance == Integer.MAX_VALUE ? -1 : least_occurance;
    }

    static void printResult(int[] arr, int x) {
        System.out.println(" *** Results Via Non Recursive Approach ****");

        int res = countTarget(arr, x);
        if (res == -1)
            System.out.printf("%s %d\n", "Element not Available", x);
        else
            System.out.printf("%s %d %s %d\n", "Element", x, " count is", res);

    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 1, 1, 1};
        printResult(arr, 1);

        arr = new int[]{1, 1, 1};
        printResult(arr, 1);

        arr = new int[]{0, 0, 0, 0};
        printResult(arr, 1);

        arr = new int[]{0};
        printResult(arr, 1);

        arr = new int[]{1};
        printResult(arr, 1);

    }
}
