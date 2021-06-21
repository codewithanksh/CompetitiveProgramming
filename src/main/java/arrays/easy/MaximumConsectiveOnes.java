package arrays.easy;

/**
 * Given an Binary Array, find the maximum consective ones in it
 */
public class MaximumConsectiveOnes {

    static int findMaxConsectiveOnes(int[] binArr) {
        int ones_count, max_ones_count;
        ones_count = max_ones_count = binArr[0] == 1 ? 1 : 0;

        for (int i = 1; i < binArr.length; i++) {

            if (binArr[i] == 0)
                ones_count = 0;
            else {
                ones_count++;
                max_ones_count = Math.max(ones_count, max_ones_count);
            }
        }

        return max_ones_count;
    }

    public static void main(String[] args) {
        int[] binArr = {1, 0, 1, 1, 1, 1, 0, 1, 1};
        System.out.println(findMaxConsectiveOnes(binArr));
    }
}
