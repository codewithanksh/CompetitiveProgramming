import java.util.HashSet;
import java.util.Set;

public class ArrayCode {

    public static void main(String[] args) {
        int[] arr1 = {3, 1, 8, 6};
        int[] arr2 = {1, -1, 4, 5, 9, 0};
        int[] arr3 = {2, 5, 1};

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for(int i=0; i < arr1.length; i++)
            set1.add(arr1[i]);

        for(int i=0; i < arr2.length; i++) {
            if (set1.contains(arr2[i]))
                 set2.add(arr2[i]);
        }

        for(int i=0; i < arr3.length; i++) {
            if (set2.contains(arr3[i])) {
                System.out.println("Common ELement : " + arr3[i]);
                break;
            }
        }
    }
}
