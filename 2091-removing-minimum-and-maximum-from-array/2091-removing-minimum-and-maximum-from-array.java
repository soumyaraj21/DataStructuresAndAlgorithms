class Solution {
    public int minimumDeletions(int[] nums) {
        int n=nums.length;
        int mini=0;
        int maxi=0;
        for(int i=0;i<n;i++){
            if(nums[i]<nums[mini]){
                mini=i;
            }
            if(nums[i]>nums[maxi]){
                maxi=i;
            }
        }
        int left=Math.min(mini,maxi);
        int right=Math.max(mini,maxi);
        int fromfront=right+1;
        int fromback=n-left;
        int fromboth=left+1+n-right;
        return Math.min(fromfront,Math.min(fromback,fromboth));
    }
}