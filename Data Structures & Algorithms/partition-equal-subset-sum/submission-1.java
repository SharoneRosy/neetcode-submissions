public class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // If sum is odd, it cannot be divided into two equal subsets
        if (sum % 2 != 0) {
            return false;
        }
        
        int target = sum / 2;
        boolean[][] dp = new boolean[n + 1][target + 1];
        
        // Base case: It is always possible to make a sum of 0 (by taking no elements)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int t = 1; t <= target; t++) {
                // Exclude the current number
                dp[i][t] = dp[i - 1][t];
                
                // Include the current number if possible
                if (t >= nums[i - 1]) {
                    dp[i][t] = dp[i][t] || dp[i - 1][t - nums[i - 1]];
                }
            }
        }
        
        return dp[n][target];
    }
}
