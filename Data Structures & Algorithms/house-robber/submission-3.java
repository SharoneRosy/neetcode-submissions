class Solution {
    public int solve(int[] nums,int i,int[] dp){
        if(i==0 ) return nums[0];
        if(i==1) return Math.max(nums[0],nums[1]);
        if(dp[i]!=-1) return dp[i];
        return dp[i]= Math.max(nums[i]+solve(nums,i-2,dp),solve(nums,i-1,dp));
    }
    public int rob(int[] nums) {
        int n=nums.length;
        int []dp=new int[n];
        Arrays.fill(dp,-1);
        return solve(nums,n-1,dp);
    }
}
