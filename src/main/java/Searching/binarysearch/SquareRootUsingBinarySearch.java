package Searching.binarysearch;

import java.util.Calendar;

public class SquareRootUsingBinarySearch {

    // Solution Using Binary Search
    static int squareRoot(int no) {


        int sqrt = 0;

        if (no < 0)
            return -1;

        int low = 0, high = no, mid ;

        while (low <= high) {

            mid = (low + high) / 2;

            int square = mid * mid;

            if(square == no) {
                sqrt = mid;
                return sqrt;
            }
            else if (square > no)
                high = mid - 1;
            else {
                low = mid + 1;
                sqrt = mid;
            }

        }
        return sqrt;
    }

    //Naive Solution
    static int squareRoot_(int no) {

        if (no < 0)
            return -1;
        else if (no == 0)
            return 0;
        else if (no == 1)
            return 1;

        int sqrt = no / 2;

        while (sqrt > 0) {

            if (sqrt * sqrt <= no)
                break;
            else
                sqrt--;
        }

        return sqrt;

    }

    public static void main(String[] args) {
        int no = 143;

        //Naive Solution
        System.out.println(squareRoot_(no));
        // Binary Search
        System.out.println(squareRoot(no));
    }
}
