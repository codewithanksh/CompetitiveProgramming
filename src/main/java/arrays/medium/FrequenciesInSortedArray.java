package arrays.medium;

/**
 * Frequencies in a sorted array
 */
public class FrequenciesInSortedArray {

    private static void printFrequencies(int[] arr){
        int freq = 1 , prev_ele = arr[0];

        for (int i = 1; i < arr.length; i++) {

            if(arr[i] == prev_ele) {
                freq++;

            }else {
                System.out.println("Element: " + prev_ele + " Frequency: " + freq);
                freq = 1;
                prev_ele = arr[i];
            }

            if( i == arr.length - 1)
                System.out.println("Element: " + prev_ele + " Frequency: " + freq);
        }

        if(arr.length == 1)
            System.out.println("Element: " + prev_ele + " Frequency: " + freq);

    }

    public static void main(String[] args) {
        int[] arr = {10};
        printFrequencies(arr);

        System.out.println("*********************");

        arr = new int[]{10,10,10,20,20,30,40};
        printFrequencies(arr);

        System.out.println("*********************");

        arr = new int[]{10,10,10,10,10,10,10};
        printFrequencies(arr);
    }
}
