class Solution {
    public boolean predictTheWinner(int[] nums) {
        return maxdiff(nums, 0, nums.length - 1) >= 0;
    }
    public int maxdiff(int[] nums,int left,int right){
        if(left==right){
            return nums[left];
        }
        int pickLeft=nums[left]- maxdiff(nums,left+1,right);
        int pickRight=nums[right]- maxdiff(nums,left,right-1);
    return Math.max(pickLeft, pickRight);
    }
}