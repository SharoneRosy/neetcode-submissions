
class Solution{
    public int f(int i,int [] nums,int []dp){
        if(i<0) return 0;
        if(dp[i]!=-1) return dp[i];
        int pick=nums[i]+f(i-2,nums,dp);
        int nonpick=0+f(i-1,nums,dp);
        return dp[i]=Math.max(pick,nonpick);
    }
    public int rob(int [] nums){
        int n=nums.length;
        int [] dp=new int[n];
        for(int i:dp) Arrays.fill(dp,-1);
        return f(n-1,nums,dp);
    }
}