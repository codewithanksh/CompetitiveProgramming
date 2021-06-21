package arrays.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class LeftRotateArrayByDPositions {

    private static int[] rotateArrayByDBruteForce(int arr[], int d) {

        if(arr.length <=1 || d <= 0 || d == arr.length)
            return arr;

        while(d > 0){
            rotateArrayByOne(arr);
            d--;
        }

        return arr;
    }

    private static int[] rotateArrayByDOptimisation1(int arr[], int d) {

        if(arr.length <=1 || d <= 0 || d == arr.length)
            return arr;

        int[] temp = new int[d];
        int index = arr.length - d;

        for(int i = 0; i < d; i++) {
            temp[i] = arr[i];
        }

        for(int i = d; i < arr.length ; i++){
            arr[i-d] = arr[i];
        }

        for(int i=0 ; i < d; i++) {
            arr[arr.length - d + i] = temp[i];
        }

        return arr;
    }

    private static int[] rotateArrayByDOptimisation2(int arr[], int d) {

        reverseArray(arr,0,d-1);
        reverseArray(arr,d, arr.length - 1);
        reverseArray(arr,0, arr.length - 1 );
        return arr;
    }

    private static void reverseArray(int[] arr, int low, int high) {

        while(low < high){
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }
    private static void rotateArrayByOne(int[] arr) {

        int temp = arr[0];

        for(int i= 1; i < arr.length ; i++) {
            arr[i-1] = arr[i];
        }
        arr[arr.length - 1] = temp;

       // System.out.println(Arrays.toString(arr));
    }

   @Test
    public void tc1(){
       int arr[] = {1,2,3,4,5};
       System.out.println(Arrays.toString(rotateArrayByDBruteForce(arr,1)));
   }

   @Test
   public void tc2(){
       int arr[] = {1,2,3,4,5};
       System.out.println(Arrays.toString(rotateArrayByDOptimisation1(arr,1)));
   }

    @Test
    public void tc3(){
        int arr[] = {1,2,3,4,5};
        System.out.println(Arrays.toString(rotateArrayByDOptimisation2(arr,1)));
    }

}
