package arrays.hard;

public class SubArraysWithZero {

    static int countSubArrays(int[] arr) {
        int count = 0;
        int sum = 0;

        if(arr.length == 0)
            return 0;

        for(int i=0; i <= arr.length - 1; i++) {

            sum = arr[i];

            if(arr[i] == 0) {
                count++;
            }

            for(int j=i+1; j < arr.length; j++) {

                sum = sum+arr[j]; // -2

                if(sum == 0) {

                    count++; //3
                }

            }
        }

        return count;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1,-1};
        System.out.println(countSubArrays(arr));
    }
}
