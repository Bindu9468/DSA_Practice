package DSA.buyandsell;

public class 121Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int minprice = prices[0]; //day 0  is min price initially 
        int maxprofit= 0;

        for (int i=1; i<n;i++){
            if (prices[i] < minprice){
                minprice = prices[i];
            }
            else {
                int profit = prices[i] - minprice;
                maxprofit = Math.max(profit, maxprofit);
            }
        }
        return maxprofit;
    }
}
// Time Complexity: O(n)
// Space Complexity: O(1)   
