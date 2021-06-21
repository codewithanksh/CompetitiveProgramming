package arrays.medium;

public class MaximumStockPrice {

    private static int findMaxProfit(int[] price){
        int max_p = 0;

        for(int i=1; i < price.length; i++) {

            if(price[i] > price[i-1])
                max_p+= price[i] - price[i-1];
        }

        return Math.max(max_p, 0);
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int max_profit = findMaxProfit(arr);

        System.out.println(max_profit);

        arr = new int[]{5,4,3,2,1};
        max_profit = findMaxProfit(arr);

        System.out.println(max_profit);

        arr = new int[]{1,2,5,3,1,2,8};
        max_profit = findMaxProfit(arr);

        System.out.println(max_profit);

        arr = new int[]{1,5,3,8,12};
        max_profit = findMaxProfit(arr);

        System.out.println(max_profit);

        arr = new int[]{1};
        max_profit = findMaxProfit(arr);

        System.out.println(max_profit);

    }
}
