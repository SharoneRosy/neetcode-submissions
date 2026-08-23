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

    public int longestCommonSubsequence(String t1, String t2) {
        int m = t1.length();
        int n = t2.length();
        int[][] dp = new int[m+1][n+1];
        for (int[] row : dp) {
            Arrays.fill(row, -1); // Initialize dp array with -1
        }
        for(int i=0;i<=m;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<=n;j++){
            dp[0][j]=0;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if (t1.charAt(i-1) == t2.charAt(j-1)) {
                     dp[i][j] = 1 + dp[i - 1][j-1]; 
               } else {
                     dp[i][j] = Math.max(dp[i - 1][j], dp[i][j-1]); 
               }
            }
        }
        return  dp[m][n];
    }
}
