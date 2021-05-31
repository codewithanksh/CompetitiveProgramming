package arrays;

public class MaxSubArraySum {

    static int computeMaxSum(int arr[]) {

        int max_so_far = 0, max_ending_here = 0;

        for (int i=0; i < arr.length ; i++) {

            max_ending_here = max_ending_here + arr[i]; //4

            if(max_ending_here < 0)
                max_ending_here = 0;

            max_so_far = Math.max(max_so_far,max_ending_here); //7
        }

        return max_so_far;
    }

    static int solveViaDynamicProgramming(int arr[]) {

        int max_so_far = arr[0], curr_max = arr[0];

        for (int i=0; i < arr.length ; i++) {

            curr_max = Math.max(arr[i],curr_max+arr[i]);
            max_so_far = Math.max(curr_max,max_so_far);
        }

        return max_so_far;
    }


    public static void main(String[] args) {

        int [] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(computeMaxSum(arr));
        System.out.println(solveViaDynamicProgramming(arr));
    }
}
