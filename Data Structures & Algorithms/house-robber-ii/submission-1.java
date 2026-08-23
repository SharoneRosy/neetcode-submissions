class Solution {
    public int f(int i, int[] nums, int[] dp) {
        if (i < 0) return 0;
        if (dp[i] != -1) return dp[i];
        int pick = nums[i] + f(i - 2, nums, dp);
        int nonPick = 0 + f(i - 1, nums, dp);
        return dp[i] = Math.max(pick, nonPick);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0]; // Edge case: only one house

        // Manually create a1 and a2
        int[] a1 = new int[n - 1]; // Exclude the last house
        int[] a2 = new int[n - 1]; // Exclude the first house

        for (int i = 0; i < n; i++) {
            if (i < n - 1) a1[i] = nums[i]; // Fill a1 excluding the last element
            if (i > 0) a2[i - 1] = nums[i]; // Fill a2 excluding the first element
        }

        int[] dp1 = new int[a1.length];
        int[] dp2 = new int[a2.length];

        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);

        int robA1 = f(a1.length - 1, a1, dp1);
        int robA2 = f(a2.length - 1, a2, dp2);

        return Math.max(robA1, robA2);
    }
}
