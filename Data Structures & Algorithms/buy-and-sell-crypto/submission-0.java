class Solution {
    public int maxProfit(int[] prices) {
        int minBuy=prices[0];
        int maxprofit=0;
        for(int sell:prices){
            minBuy=Math.min(minBuy,sell);
            maxprofit=Math.max(maxprofit,sell-minBuy);
        }
        return maxprofit;
    }
}
