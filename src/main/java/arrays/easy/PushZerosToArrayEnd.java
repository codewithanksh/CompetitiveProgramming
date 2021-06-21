package arrays.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class PushZerosToArrayEnd {

    public int[] pushZeros(int[] arr, int n) {

        if (arr.length <= 1)
            return arr;

        int count = -1;

        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                arr[++count] = arr[i];
            }
        }

        for (int i = count+1; i < n; i++) {
            arr[i] = 0;
        }

        return arr;
    }

    @Test
    public void tc1() {
        int[] arr = {1, 0, 4, 0, 0, 3};
        Assert.assertEquals(Arrays.toString(pushZeros(arr, arr.length)), Arrays.toString(new int[]{1, 4, 3, 0, 0, 0}));
    }

    @Test
    public void tc2() {
        int[] arr = {0, 0, 0, 0, 3};
        Assert.assertEquals(Arrays.toString(pushZeros(arr, arr.length)), Arrays.toString(new int[]{3, 0, 0, 0, 0}));
    }

    @Test
    public void tc3() {
        int[] arr = {1, 3};
        Assert.assertEquals(Arrays.toString(pushZeros(arr, arr.length)), Arrays.toString(new int[]{1, 3}));
    }


    @Test
    public void tc4() {
        int[] arr = {0, 0, 0};
        Assert.assertEquals(Arrays.toString(pushZeros(arr, arr.length)), Arrays.toString(new int[]{0, 0, 0}));
    }

    @Test
    public void tc5() {
        int[] arr = {1, 0, 0};
        Assert.assertEquals(Arrays.toString(pushZeros(arr, arr.length)), Arrays.toString(new int[]{1, 0, 0}));
    }
}
