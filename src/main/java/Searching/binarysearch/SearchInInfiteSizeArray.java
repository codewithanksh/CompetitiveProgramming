package Searching.binarysearch;

/**
 * Given an infinite sized array, we need to write an efficient solution to search an element.
 */

// This algorithm is popularly knowm as unbounded binary search
public class SearchInInfiteSizeArray {

    static int findElement(int[] arr, int x) {

        if (arr[0] == x)
            return 0;

        int pos = 1;
        while (arr[pos] < x)
            pos = pos * 2;

        if(arr[pos] == x)
            return pos;
        else
            return BinarySearch.binarySearch_(arr,x,pos/2 + 1, pos - 1);

    }

    static void printResult(int[] arr, int x) {


        int res = findElement(arr, x);
        if (res == -1)
            System.out.printf("%s\t%d\n", "Element not Available", x);
        else
            System.out.printf("%s %d %s %d\n", "Element", x, "available at minimum index", res);

        System.out.println(" ########################################");
    }

    public static void main(String[] args) {
        int[] arr = {1, 10, 10, 10, 10, 20, 40};
        printResult(arr, 20);

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
