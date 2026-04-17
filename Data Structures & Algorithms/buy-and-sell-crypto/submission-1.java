class Solution {
    public int maxProfit(int[] prices) {
        int currentMin = prices[0];
        int currentMaxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (currentMin > prices[i]) {
                currentMin = prices[i];
            } else {
                currentMaxProfit = Math.max(prices[i] - currentMin, currentMaxProfit);
            }
        }
        return currentMaxProfit;
    }
}
