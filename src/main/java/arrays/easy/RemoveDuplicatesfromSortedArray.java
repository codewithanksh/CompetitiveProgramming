package arrays.easy;

import java.util.Arrays;

public class RemoveDuplicatesfromSortedArray {

    static int removeDuplicates(int[] arr, int size) {
         int count = 0;

            if(arr.length == 0)
                return 0;
            else if (arr.length == 1)
                return 1;

            for(int i=1; i < arr.length; i++) {

                if(arr[i] != arr[count]){
                    arr[++count] = arr[i];
                }

                arr[i] = 0;
            }
        return count+1;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1,1,10,11};
        int noOfDistinctElements = removeDuplicates(arr,arr.length);
        System.out.println("No of Distinct Elements is "+noOfDistinctElements+"\nArray is : "+Arrays.toString(arr));

    }
}
