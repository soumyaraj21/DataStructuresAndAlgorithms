class Solution {
    public int jump(int[] nums) {
        int jumps=0;
        int currentEnd=0;
        int maxReach=0;
        for(int currIndex=0;currIndex<nums.length-1;currIndex++){
            maxReach=Math.max(maxReach,currIndex+nums[currIndex]);
            if(currIndex==currentEnd){
                jumps++;
                currentEnd=maxReach;
            }
        }
        return jumps;
    }
}