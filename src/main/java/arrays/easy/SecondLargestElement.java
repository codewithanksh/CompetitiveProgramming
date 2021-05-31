package arrays.easy;

/**
 * find index of second largest element in an array
 * <p>
 * for eg : arr[] = [20,8,20,8,12] // result = 4
 * arr[] = [20,20,20] // result = -1
 */
public class SecondLargestElement {

    static int findSecondLargestIndex(int arr[]) {
        int result_index = 0, len = arr.length;

        if (len == 0 || len == 1)
            return -1;

        int lar = Integer.MIN_VALUE, sec_lar = Integer.MIN_VALUE, larg_index = 0;

        for (int i = 0; i < len; i++) {

            if (arr[i] > lar) {
                sec_lar = lar;
                lar = arr[i];
                result_index = larg_index;
                larg_index = i;
            } else if (arr[i] > sec_lar && arr[i] != lar) {
                sec_lar = arr[i];
                result_index = i;
            }
        }

        if (sec_lar == Integer.MIN_VALUE)
            result_index = -1;

        System.out.printf("%d%s%d",sec_lar," is the second largest element at index :",result_index);
        System.out.println();

        return result_index;

    }


    public static void main(String[] args) {

        int[] arr1 = {20,8,20,8,12};
        int[] arr2 = {10,5,8,20};
        int[] arr3 = {10,10,10};

        findSecondLargestIndex(arr1);
        findSecondLargestIndex(arr2);
        findSecondLargestIndex(arr3);

    }
}
