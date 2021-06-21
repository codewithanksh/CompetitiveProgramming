package arrays.medium;

/***
 * Find the maximum length of an Even/Odd Subarray such that
 * even and odd elements occurs at alternative postions or vice versa
 */
public class MaximumLengthEvenOddSubarray {

    static int findMaxLen(int[] arr) {
        String prev_type, curr_type;
        int curr_max, max_len;
        prev_type = arr[0] % 2 == 0 ? "even" : "odd";
        curr_max = max_len = 1;

        for (int i = 1; i < arr.length; i++) {

            curr_type = arr[i] % 2 == 0 ? "even" : "odd";

            if (!curr_type.equals(prev_type))
                curr_max++;
            else
                curr_max = 1;

            max_len = Math.max(max_len, curr_max);
            prev_type = curr_type;

        }

        return max_len;
    }

    public static void main(String[] args) {
        int[] arr = {5, 10, 20, 6, 3, 8};
        System.out.println(findMaxLen(arr));

        arr = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println(findMaxLen(arr));

        arr = new int[]{5, 7, 9, 11};
        System.out.println(findMaxLen(arr));

    }
}
