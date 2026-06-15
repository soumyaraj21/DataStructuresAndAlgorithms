class Solution {
    public boolean solve(int index, int target,
                         int[] nums, int[][] dp) {
        if(target == 0) {
            return true;
        }
        if(index == nums.length) {
            return false;
        }
        if(dp[index][target] != -1) {
            return dp[index][target] == 1;
        }
        boolean notTake = solve(index + 1, target, nums, dp);
        boolean take = false;
        if(nums[index] <= target) {
            take = solve(index + 1,
                         target - nums[index],
                         nums, dp);
        }
        dp[index][target] = (take || notTake) ? 1 : 0;
        return take || notTake;
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        if(sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        int[][] dp = new int[nums.length][target + 1];
        for(int i = 0; i < nums.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(0, target, nums, dp);
    }
}