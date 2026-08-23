class Solution {
    public int solve(int[] prices,int i,int buy){
        if(i>=prices.length) return 0;
        int profit;
        if(buy==1){
            profit=Math.max(-prices[i]+solve(prices,i+1,0),solve(prices,i+1,1));
        }else{
            profit=Math.max(prices[i]+solve(prices,i+2,1),solve(prices,i+1,0));
        }
        return profit;
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        return solve(prices,0,1);
    }
}
