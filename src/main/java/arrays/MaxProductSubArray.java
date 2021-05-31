package arrays;

public class MaxProductSubArray {

    static void naiveSolution(int[] arr) {

        int product = 1;
        int max = 1;

        for(int i=0; i < arr.length; i++) {

            for(int j=i; j < arr.length; j++) {
                product = product * arr[j];
                max = Math.max(max,product);
            }
            product = 1;
        }

        System.out.println("Maximum Product :"+max);
    }

    static void solutionUsingDynamicProgramming(int[] arr) {

        int max_product = arr[0];
        int curr_product = arr[0];

        for(int i=1; i < arr.length; i++) {


        }

        System.out.println("Maximum Product :"+max_product);
    }

    public static void main(String[] args) {

        int arr[] = {6, -3, -10, 0, 2};
        naiveSolution(arr);
        solutionUsingDynamicProgramming(arr);
    }
}
