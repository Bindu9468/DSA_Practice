package DSA.buyandsell;

public class 122Solution {

    public int maxProfit(int[] prices) {
        int n=prices.length;
        int maxprofit= 0 ;

        for (int i=1;i<n;i++){
            if(prices[i] > prices[i-1]){
                maxprofit+= prices[i] - prices[i-1];
            }
        }
        return maxprofit;
    }
}
// Time Complexity: O(n)
// Space Complexity: O(1)   
// This solution allows for multiple transactions, buying and selling on every upward trend in the prices array.
// It calculates the profit by summing up all the positive differences between consecutive days' prices.
