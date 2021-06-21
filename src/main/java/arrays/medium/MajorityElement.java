package arrays.medium;

import java.util.Arrays;

/**
 * Program for finding out
 * majority element in an array
 *
 * Boyer - Moore Voting Algorithm
 **/
public class MajorityElement {

    /* Function to find the Candidate Element */
    static int findCandidate(int[] arr) {
        int maj_index = 0, count = 1;

        for(int i=1; i < arr.length; i++) {

            if(arr[i] == arr[maj_index])
                count++;
            else
                count--;

            if(count == 0) {
                maj_index = i;
                count = 1;
            }

        }

        return arr[maj_index];
    }

    /* Function to find if Candidate is Majority Element i.e occurance > n /2 */
    static int isMajority(int[] arr, int cand){
        int majority = cand, count  = 0;

        for(int i=0; i < arr.length; i++)
            if(arr[i] == majority)
                count++;

        if(count > arr.length / 2)
            return 1;
        else
            return 0;
    }

    /* Function to print the Majority ELement */
    static void printMajority(int[] arr) {

        /* Function to find the Majority Element */
        int candidate  = findCandidate(arr);

        /* Function to check if candidate is Majority */
        boolean isMajority = isMajority(arr, candidate) != 0;

        if(isMajority)
            System.out.println("Majority Element : "+candidate+ " for array "+Arrays.toString(arr));
        else
            System.out.println("No Majority Element present in array "+ Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {2,2,2,4,1};
        printMajority(arr);
    }

}
