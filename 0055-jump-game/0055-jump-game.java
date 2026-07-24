class Solution {
    public boolean canJump(int[] nums) {
        int maxReach=0;
        for(int currIndex=0;currIndex<nums.length;currIndex++){
            if(currIndex>maxReach){
                return false;
            }
            maxReach=Math.max(maxReach,currIndex+nums[currIndex]);
        }
            return true;
    }
}