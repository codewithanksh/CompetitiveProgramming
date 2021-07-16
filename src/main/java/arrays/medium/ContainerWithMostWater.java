package arrays.medium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class ContainerWithMostWater {

    //Brute force solution
    public int maxArea(int[] height) {

        int maxArea = 0, currentArea = 0;
        for (int i = 0; i < height.length - 1; i++) {

            currentArea = 0;

            for (int j = i + 1; j < height.length; j++) {

                currentArea = Math.min(height[i], height[j]) * (j - i);
                maxArea = Math.max(maxArea, currentArea);
            }
        }

        return maxArea;
    }

    //Brute force solution
    public int maxArea_(int[] height) {

        int maxArea = 0, currentArea = 0, start = 0, end = height.length - 1;
        //1, 8, 6, 2, 5, 4, 8, 3, 7
        while (start < end) {
            currentArea = Math.min(height[start],height[end])* (end-start);
            maxArea = Math.max(currentArea,maxArea);

            if(height[start] < height[end]){
                start++;
            }else {
                end--;
            }
        }

        return maxArea;
    }


    @Test
    public void tc1() {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int output = 49;
        Assert.assertEquals(output, maxArea(height));
        Assert.assertEquals(output, maxArea_(height));
    }

    @Test
    public void tc2() {
        int[] height = {1, 2, 1};
        int output = 2;
        Assert.assertEquals(output, maxArea(height));
        Assert.assertEquals(output, maxArea_(height));
    }

    @Test
    public void tc3() {
        int[] height = {1, 1, 1};
        int output = 2;
        Assert.assertEquals(output, maxArea(height));
        Assert.assertEquals(output, maxArea_(height));
    }

    @Test
    public void tc4() {
        int[] height = {1, 4, 10, 1};
        int output = 4;
        Assert.assertEquals(output, maxArea(height));
        Assert.assertEquals(output, maxArea_(height));
    }

}
