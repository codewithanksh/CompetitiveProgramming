package arrays.easy;

/**
 * Check whether an array is sorted in an increasing order or not
 * <p>
 * arr[] = {1,4,5,8,12} // O/P : Yes
 * arr[] = {3,2,4,1} // O/P : No
 * arr[] = {3} // O/P : Yes
 * arr[] = {200,100} // O/P : No (Decreasing order)
 */
public class CheckIfArrayIsSorted {

    static String isSorted(int[] arr) {
        boolean res = true;

        for (int i = 0; i < arr.length - 1; i++) {

            if (arr[i] > arr[i + 1]) {
                res = false;
                break;
            }
        }

        return res ? "Sorted" : "Un Sorted";
    }

    public static void main(String[] args) {

        int arr1[] = {1, 4, 5, 8, 12}; // O/P : Yes
        int arr2[] = {3, 2, 4, 1}; // O/P : No
        int arr3[] = {3, 3, 3}; // O/P : Yes

        System.out.println(isSorted(arr1));
        System.out.println(isSorted(arr2));
        System.out.println(isSorted(arr3));
    }
}
