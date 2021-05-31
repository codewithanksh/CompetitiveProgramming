package arrays.easy;

import java.util.Arrays;
import java.util.HashSet;

/***
 * Rearrange an array such that arr[i] = i
 */
public class RearrangementQues {

    static int[] sol1(int[] arr,int n) {

        for(int i=0; i < n-1 ; i++) {

            if(arr[i] != i) {

                boolean found = false;
                int minusOneEleIndex=0;

                for(int j=i+1; j < n; j++) {

                    if(i == arr[j]){
                        arr[j] = arr[i];
                        arr[i] = i;
                        found = true;
                        break;
                    }else if (arr[j] == -1) {
                        minusOneEleIndex = j;
                    }
                }

                if(!found) {
                    arr[minusOneEleIndex]=arr[i];
                    arr[i]=-1;
                }


            }
        }

        System.out.println(Arrays.toString(arr));
        return arr;
    }

    static void sol2(int[] arr) {

        for (int i = 0; i < arr.length;i++)
        {
            if (arr[i] >= 0 && arr[i] != i)
            {
                int ele = arr[arr[i]];
                arr[arr[i]] = arr[i];
                arr[i] = ele;
            }
//            else
//            {
//                i++;
//            }
        }
        System.out.println(Arrays.toString(arr));
    }

    static void sol3(int[] arr) {

        HashSet<Integer> set = new HashSet<>();

        for(int e : arr) {
            if(e != -1)
                set.add(e);
        }

        for(int i=0; i < arr.length; i++) {

            if(set.contains(i))
                arr[i]=i;
            else
                arr[i]=-1;

        }

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1};

        System.out.println("Input Array :"+ Arrays.toString(arr));
        System.out.println("Output :");
        sol1(arr, arr.length);
        sol2(arr);
        sol3(arr);
    }

}
