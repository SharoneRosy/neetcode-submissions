class Solution {
    public int solve(String s, String t, int i, int j, int[][] dp) {
        if (i < 0 || j < 0) return 0; // Base case

        if (dp[i][j] != -1) return dp[i][j]; // Return already computed value

        if (s.charAt(i) == t.charAt(j)) {
            dp[i][j] = 1 + solve(s, t, i - 1, j - 1, dp); // Match case
        } else {
            dp[i][j] = Math.max(solve(s, t, i - 1, j, dp), solve(s, t, i, j - 1, dp)); // No match case
        }
        return dp[i][j];
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1); // Initialize dp array with -1
        }
        return solve(text1, text2, m - 1, n - 1, dp);
    }
}
