package Leetcode.Arrays;

/**
 * To count maximum no of consecutive ones in a binary Array
 */
public class CountConsecutiveOnesInBinaryArray {

    public static void main(String[] args) {

        int array[] = {1,1,0,1,0,1,0,0,0,0,1,1,1,1,1,1};
        System.out.println("Max Consecutive Ones: "+returnMaxNoOnConsectiveOnes(array));
    }


    private static int returnMaxNoOnConsectiveOnes(int nums[]) {

        int counter = 0;
        int result = 0;

        for (int i = 0; i < nums.length; i++) {


            if (nums[i] == 1) {
                counter++;
                if (counter > result) {
                    result = counter;
                }
            } else{
                counter = 0;
            }
        }

        return result;
    }
}
