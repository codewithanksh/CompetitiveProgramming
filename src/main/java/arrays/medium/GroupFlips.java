package arrays.medium;

/**
 * Given a binary array,
 * we need to find the minimum of number of group flips to make all array elements same.
 * In a group flip, we can flip any set of consecutive 1s or 0s.
 */
public class GroupFlips {

    static int minimumGroupFlips(int[] arr) {

        if(arr.length < 2)
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

                while (i < arr.length && arr[i] == 0 )
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


    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 1, 0};
        minimumGroupFlips(arr);

        arr = new int[]{1, 1, 0, 0, 0, 1};
        minimumGroupFlips(arr);

        arr = new int[]{1, 1, 1};
        minimumGroupFlips(arr);

        arr = new int[]{1, 0};
        minimumGroupFlips(arr);
    }
}
