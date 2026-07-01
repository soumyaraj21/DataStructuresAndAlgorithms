class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int dp[][][]=new int[n][2][3];
                for (int i = 0; i < n; i++) {
            for (int buy = 0; buy < 2; buy++) {
                for (int cap = 0; cap < 3; cap++) {
                    dp[i][buy][cap] = -1;
                }
            }
        }
    return solve(0, 1, 2, prices, dp);
    }
    private int solve(int index, int buy, int cap, int[] prices, int[][][] dp) {
    if (index == prices.length || cap == 0) {
            return 0;
        }
        if (dp[index][buy][cap] != -1) {
            return dp[index][buy][cap];
        }
        if (buy == 1) {
        int buyStock = -prices[index] + solve(index + 1, 0, cap, prices, dp);
            int skip = solve(index + 1, 1, cap, prices, dp);
            dp[index][buy][cap] = Math.max(buyStock, skip);
        } 
        else {
        int sellStock = prices[index] + solve(index + 1, 1, cap - 1, prices, dp);
            int skip = solve(index + 1, 0, cap, prices, dp);
            dp[index][buy][cap] = Math.max(sellStock, skip);
        }
        return dp[index][buy][cap];
    }
}



