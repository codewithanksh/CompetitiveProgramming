package arrays.easy;

/**
 * Search an element in a sorted and rotated array
 * So for instance, 1 2 3 4 5 might become 3 4 5 1 2. Devise a way to find an element in the rotated array in O(log n) time.
 */
public class SearchElementInSortedRotatedArray {

    public static void main(String[] args) {

        int arr[] = {3,4,5,1,2};
        System.out.println(sol1(arr,4));
        System.out.println(sol2(arr,2));
    }

    /***
     * Idea is to find a inflection point where i+1 element is smaller than ith element
     * Time Complexity O(n)
     */
    static int sol1(int arr[], int key) {

        int start = 0;
        int end = arr.length - 1, index=0;

        while (start < end) {

            if (key == arr[start])
                return start;
            else if (key == arr[end])
                return end;

            start++;
            end--;
        }



        return index;

    }

    static int sol2(int arr[], int key) {


        return 0;

    }
}
