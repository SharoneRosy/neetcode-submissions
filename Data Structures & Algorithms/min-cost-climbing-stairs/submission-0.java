class Solution {
    public int solve(int[] cost, int i) {
        if (i == 0) return cost[0];
        if (i == 1) return cost[1];
        return cost[i] + Math.min(solve(cost, i - 1), solve(cost, i - 2));
    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        // You can either end at the last step or the second last step
        return Math.min(solve(cost, n - 1), solve(cost, n - 2));
    }
}
