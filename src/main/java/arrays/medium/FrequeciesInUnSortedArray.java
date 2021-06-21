package arrays.medium;

import java.util.*;

/**
 * Count frequencies of elements in an unsorted array
 * 1 . In Sorted Order
 * 2. In Order of occurance of elements
 */
public class FrequeciesInUnSortedArray {

    // We can achieve the solution using Hashing and use TreeMap for sorting
    static void printFrequencies(int[] arr) {

        // Map to store elements and their frequencies
        Map<Integer, Integer> hmap = new HashMap<>();

        for (int i = 0; i < arr.length; i++)
            hmap.put(arr[i], hmap.get(arr[i]) == null ? 1 : hmap.get(arr[i]) + 1);

        SortedMap<Integer, Integer> smap = new TreeMap<>();

        // Use a TreeMap to store elements in Sorted Order
        for (Map.Entry<Integer, Integer> entry : hmap.entrySet())
            smap.put(entry.getKey(), entry.getValue());

//        System.out.println(smap.toString());

        // Prepare a HashMap
        for (Map.Entry<Integer, Integer> entry : smap.entrySet())
            System.out.println("Element: " + entry.getKey() + " Frequency: " + entry.getValue());
    }

    /**
     * We will use hashing to do this. we will compute Hash of the frequency of an occuring element
     * Traverse the array and print the cumulative frequency
     * if an element and its cumulative frequency is printed, we'll hash the frequency as zero so that
     * if same element reapperars in latter half of array, it is not printed twice
     *
     * @param arr
     */

    // Function to print the cumulative frequency
    // according to the order given
    static void printFrequenciesInOrderOfOccurance(int[] arr) {

        // Map to store elements and their frequencies
        Map<Integer, Integer> hmap = new HashMap<>();

        for (int i = 0; i < arr.length; i++)
            hmap.put(arr[i], hmap.get(arr[i]) == null ? 1 : hmap.get(arr[i]) + 1);

        for(int i=0; i < arr.length; i++) {

            if(hmap.get(arr[i]) != null) {
                System.out.println("Element: " + arr[i] + " Frequency: " + hmap.get(arr[i]));
                hmap.remove(arr[i]);
            }
        }

    }


    public static void main(String[] args) {
        int[] arr = {10};

       // printFrequencies(arr);

        System.out.println("*********************");

        printFrequenciesInOrderOfOccurance(arr);

        System.out.println("*********************");

        arr = new int[]{40, 20, 10, 20, 20, 30, 40};

      //  printFrequencies(arr);

        System.out.println("*********************");

        printFrequenciesInOrderOfOccurance(arr);

        System.out.println("*********************");

        arr = new int[]{10, 10, 10, 10, 10, 10, 10};

       // printFrequencies(arr);

        System.out.println("*********************");

        printFrequenciesInOrderOfOccurance(arr);
    }
}
