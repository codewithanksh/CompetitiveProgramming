package arrays.medium;

import java.util.Arrays;

/**
 * Given a binary array,
 * we need to find the minimum of number of group flips to make all array elements same.
 * In a group flip, we can flip any set of consecutive 1s or 0s.
 */
public class GroupFlips {

    static int minimumGroupFlips(int[] arr) {

        if (arr.length < 2)
            return -1;

        int count = 0;

        int c0 = 0, c1 = 0;


        for (int i = 1; i < arr.length; i++) {

            if (arr[i] != arr[i - 1]) {

                if (arr[i - 1] == 0) {
                    c0++;
                } else {
                    c1++;
                }
            }
        }

        if (arr[arr.length - 1] == arr[arr.length - 2] && arr[arr.length - 1] == 0)
            c0++;
        else if (arr[arr.length - 1] == arr[arr.length - 2] && arr[arr.length - 1] == 1)
            c1++;
        else if (arr[arr.length - 1] == 1)
            c1++;
        else
            c0++;

        count = Math.min(c1, c0);

        int toFlip = count == c0 ? 0 : 1;
        int i = 0;


        while (count > 0) {

            if (toFlip == 0) {
                while (i < arr.length && arr[i] != 0)
                    i++;

                int start = i;

                while (i < arr.length && arr[i] == 0)
                    i++;

                int end = i - 1;

                if (end < 0 || start == end)
                    System.out.println("Index for zero is " + start + " && " + start);
                else
                    System.out.println("Index for zero is " + start + " && " + end);
            } else {
                while (i < arr.length && arr[i] != 1)
                    i++;

                int start = i;

                while (i < arr.length && arr[i] == 1)
                    i++;

                int end = i - 1;

                if (end < 0 || start == end)
                    System.out.println("Index for one is " + start + " && " + start);
                else
                    System.out.println("Index for one is " + start + " && " + end);
            }

            count--;


        }

        return count;

    }

    static int minimumGroupFlips_(int[] arr) {

        if (arr.length < 2)
            return -1;

        int firstGroup = arr[0] == 0 ? 0 : 1;
        int secondGroup = firstGroup == 0 ? 1 : 0;

        int counter = 0, flips = 0;

//        while (counter < arr.length) {
//
//            boolean flag = false;
//            int start = counter;
//
//            while (counter < arr.length && arr[counter] == secondGroup) {
//                flag = true;
//                counter++;
//            }
//
//            if (flag) {
//                flips++;
//                System.out.println("Input Array is " + Arrays.toString(arr) + " ,Start Index for second group is " + start + " && ending index is " + (counter - 1));
//            }
//
//            counter++;
//        }
//
//        if (flips == 0)
//            System.out.println("Input Array is " + Arrays.toString(arr) + " No Second group found in the array");

        for (int i = 1; i < arr.length; i++) {

            // Condition indicates starting of a new second group or ending of an existing second group
            if (arr[i] != arr[i - 1]) {

                //Begining of a second group when current element is not equal to the first element
                if (arr[i] != arr[0])
                    System.out.println("starting from "+i);
                else {
                    System.out.println("ending at " + (i - 1));
                    flips++;
                }

            }

            if(arr[arr.length-1] != arr[0]) {
                System.out.println("ending at " + (arr.length - 1));
                flips++;
            }
        }
        return flips;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 1, 0};
        minimumGroupFlips(arr);

        arr = new int[]{1, 1, 0, 0, 0, 1};
        minimumGroupFlips(arr);

        arr = new int[]{1, 1, 1};
        minimumGroupFlips(arr);

        arr = new int[]{1, 0};
        minimumGroupFlips(arr);

        arr = new int[]{0, 1, 1, 1, 0};
        minimumGroupFlips_(arr);

        arr = new int[]{1, 1, 0, 0, 0, 1};
        minimumGroupFlips_(arr);

        arr = new int[]{1, 1, 1};
        minimumGroupFlips_(arr);

        arr = new int[]{1, 0};
        minimumGroupFlips_(arr);
    }
}
