class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for(int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }
        if(totalSum - target < 0 || (totalSum - target) % 2 != 0) {
            return 0;
        }
        int reqSum = (totalSum - target) / 2;
        int[][] dp = new int[nums.length][reqSum + 1];
        for(int i = 0; i < nums.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(nums.length - 1, reqSum, nums, dp);
    }
    public int solve(int ind, int target, int[] nums, int[][] dp) {
        if(ind == 0) {
            if(target == 0 && nums[0] == 0) {
                return 2;
            }
            if(target == 0 || target == nums[0]) {
                return 1;
            }
            return 0;
        }
        if(dp[ind][target] != -1) {
            return dp[ind][target];
        }
        int notTake = solve(ind - 1, target, nums, dp);
        int take = 0;
        if(nums[ind] <= target) {
            take = solve(ind - 1, target - nums[ind], nums, dp);
        }
        return dp[ind][target] = take + notTake;
    }
}