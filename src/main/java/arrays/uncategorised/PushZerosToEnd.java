package arrays.uncategorised;

import java.util.Arrays;

/**
 * Date : 22/05/2021
 *
 * Given an array of Integers, Push all the zeros to end in O(n) time and constant space
 * Input : {1,9,2,0,0,6,0,3,0,1}
 * Output : {1,9,2,1,3,6,0,0,0,0}
 */
public class PushZerosToEnd {


    public static void main(String[] args) {
        int[] arr = {1,9,2,0,0,6,0,3,0,1};
        sol1(arr);
        sol2(arr);
    }

    static void sol1(int[] arr) {


        int left = 0, right = arr.length - 1;

        while (left < right) {

            /**
             * Keep Iterating until you've found a zero value on the left index
             */
            while(arr[left] !=0){
                left++;
            }

            /**
             * Keep Iterating until you've found a zero value on the right side
             */
            while (arr[right] ==0) {
                right--;
            }

           /**
            * If the pointers have not crossed one another, till then swap the elements
            */
           if(left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

            }
        }

        System.out.println(Arrays.toString(arr));
    }

    /**
     * Approach : Maintain a count variable set to zero initially
     * Iterate through array from left to right, and then every time a non-zero element is encountered,
     * put it at location of count and increment it.
     * When all non-zero elements are pushed to the left,then start from count value to array length, put all zeros
     */
    static void sol2(int arr[]) {

        int count = 0;

        for(int i=0; i < arr.length; i++ ) {

            if(arr[i] !=0 ){
                arr[count++] = arr[i];
            }

        }

        while (count < arr.length){
            arr[count] = 0;
            count++;
        }

        System.out.println(Arrays.toString(arr));

    }
}
