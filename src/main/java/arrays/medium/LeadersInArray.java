package arrays.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/***
 * An element is called the leader of an array if there is no element greater than it on the right side
 */
public class LeadersInArray {

    public List<Integer> findLeadersByBruteForce( int[] arr, int n){

        List<Integer> res = new ArrayList<Integer>();

        for(int i=0; i < arr.length - 1; i++) {

            boolean flag = true;

            for(int j=i+1; j < arr.length; j++ ) {

                if(arr[i] <= arr[j]){
                    flag = false;
                    break;
                }
            }

            if(flag)
                res.add(arr[i]);
        }

        res.add(arr[n-1]);

        return res;
    }

    public List<Integer> findLeadersOptimized( int[] arr, int n){

        List<Integer> res = new ArrayList<Integer>();

        // The idea is to find the current leader from right side and then iterate
        // the array from right to left and compare the current element with the leader
        // if it is greater than leader, current element becomes the leader, if it is smaller we move on to left

        if(n <= 1) {
            res.add(arr[n]);
            return res;
        }

        int curr_leader = arr[n-1];
        res.add(curr_leader);

        for(int i= n-2; i >=0; i--) {

            if(arr[i] > curr_leader){
                curr_leader = arr[i];
                res.add(curr_leader);
            }
        }

        Collections.reverse(res);

        return res ;
    }

    @Test
    public void tc1() {
        int[] arr = {1,7,6,10,8,2,5};
        System.out.println(findLeadersByBruteForce(arr,arr.length).toString());
    }

    @Test
    public void tc2() {
        int[] arr = {1,7,6,10,8,2,5};
        System.out.println(findLeadersOptimized(arr,arr.length).toString());
    }

    @Test
    public void tc3() {
        int[] arr = {1,2,5};
        System.out.println(findLeadersOptimized(arr,arr.length).toString());
    }

    @Test
    public void tc4() {
        int[] arr = {5,2,1};
        System.out.println(findLeadersOptimized(arr,arr.length).toString());
    }

    @Test
    public void tc5() {
        int[] arr = {1,1,1};
        System.out.println(findLeadersOptimized(arr,arr.length).toString());
    }
}
