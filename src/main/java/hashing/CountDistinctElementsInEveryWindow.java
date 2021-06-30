package hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Count distinct elements in every window
 */
public class CountDistinctElementsInEveryWindow {

    // No of windows would be n-k+1 where k <= n
    static int countDistinctElementsInWindow(int[] arr, int k) {

        int count = 0;

        if (arr.length < 1) {
            System.out.println("Invalid array length");
            return 0;
        }

        if (k > arr.length || k < 1) {
            System.out.println("Invalid window size");
            return 0;
        }

        // Time Complexity O(n-k*k)
        for (int i = 0; i <= arr.length - k; i++) {

            Set<Integer> set = new HashSet<>();

            for (int j = i; j - i < k; j++) {

                set.add(arr[j]);

            }

            System.out.println("Distinct Elements in Window " + i + " is " + set.size());
        }
        return count;
    }

    // No of windows would be n-k+1 where k <= n
    static int countDistinctElementsInWindow_(int[] arr, int k) {

        int count = 0;

        if (arr.length < 1) {
            System.out.println("Invalid array length");
            return 0;
        }

        if (k > arr.length || k < 1) {
            System.out.println("Invalid window size");
            return 0;
        }

        // Time Complexity O(n)

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < k; i++) {

            if (map.containsKey(arr[i]))
                map.put(arr[i], map.get(arr[i]) + 1);
            else
                map.put(arr[i], 1);
        }

        System.out.println("Distinct Elements in Window " + 0 + " is " + map.size());

        for (int i = 1; i <= arr.length - k; i++) {

            // Compensate for i-1th element
            if (map.containsKey(arr[i - 1])) {

                if (map.get(arr[i - 1]) == 1)
                    map.remove(arr[i - 1]);
                else
                    map.put(arr[i - 1], map.get(arr[i - 1]) - 1);

            }

            // Compensate for i+k-1 th element
            if (map.containsKey(arr[i + k - 1]))
                map.put(arr[i + k - 1], map.get(arr[i + k - 1]) + 1);
            else
                map.put(arr[i + k - 1], 1);

            System.out.println("Distinct Elements in Window " + i + " is " + map.size());
        }


        return count;
    }

    static void printResult(int[] arr, int k) {

        System.out.println("**************** NAIVE APPROACH ****************");

        countDistinctElementsInWindow(arr, k);

        System.out.println("***************** EFFICIENT APPROACH **************");

        countDistinctElementsInWindow_(arr, k);

        System.out.println("*********************************************");
    }

    public static void main(String[] args) {

        int arr[] = new int[]{10, 20, 20, 10, 30, 40, 10};
        int k = 4;
        printResult(arr, k);

        arr = new int[]{10, 10, 10};
        k = 3;
        printResult(arr, k);

        arr = new int[]{10, 20, 30, 40};
        k = 3;
        printResult(arr, k);
    }
}
