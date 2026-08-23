class Solution {
    public int solve(int amount, int[] coins,int i,int dp[][]){
        if (amount==0) return 1;
        if(i==0){
            if(amount%coins[0]==0) return 1;
            else return 0;
        }
        if(dp[i][amount]!=-1) return dp[i][amount];
        int notpick=solve(amount,coins,i-1,dp);
        int pick=0;
        if(amount>=coins[i]){
            pick=solve(amount-coins[i],coins,i,dp);
        }
        dp[i][amount]=pick+notpick;
        return dp[i][amount];
    }


    public int change(int amount, int[] coins) {
        int n=coins.length;
        int dp[][]=new int [coins.length][amount+1];
        for(int[]  row:dp){
            Arrays.fill(row,-1);
        }
        return solve(amount,coins,n-1,dp);
    }
}
