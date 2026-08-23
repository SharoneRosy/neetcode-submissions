class Solution {
    public int solve(int i, int[] coins, int t) {
        if (i == 0) {
            return (t % coins[i] == 0) ? t / coins[i] : Integer.MAX_VALUE;
        }

        int notTake = solve(i - 1, coins, t); // Skip current coin
        int take = Integer.MAX_VALUE;
        if (coins[i] <= t) { // Use current coin if possible
            int result = solve(i, coins, t - coins[i]);
            if (result != Integer.MAX_VALUE) {
                take = 1 + result;
            }
        }
        return Math.min(take, notTake);
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int result = solve(n - 1, coins, amount);
        return (result == Integer.MAX_VALUE) ? -1 : result;
    }
}
