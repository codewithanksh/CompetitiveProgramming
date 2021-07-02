package arrays.medium;

/**
 * Given a binary array,
 * we need to find the minimum of number of group flips to make all array elements same.
 * In a group flip, we can flip any set of consecutive 1s or 0s.
 */
public class GroupFlips {

    static int minimumGroupFlips(int[] arr) {
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

        String flip = count == c0 ? "zero" : "one";

        for (int i = 0; i < arr.length; i++) {

            if (flip.equals("zero")) {

                int start = i;

                while (arr[i] == 0 && i < arr.length) {
                    i++;
                }

                System.out.println("Flip from index " + start + " to " + (i - 1));
            } else {

                int start = i;
                while (arr[i] == 1 && i < arr.length) {
                    i++;
                }

                System.out.println("Flip from index " + start + " to " + (i - 1));
            }
        }


        return count;
    }


    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 1, 0};
        System.out.println(minimumGroupFlips(arr));
    }
}
