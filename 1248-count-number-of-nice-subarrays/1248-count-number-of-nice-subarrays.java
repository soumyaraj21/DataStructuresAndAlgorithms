class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return countsubarrays(nums,k)- countsubarrays(nums,k-1);
    }
    public int countsubarrays(int[] nums,int k){
        if(k<0){
            return 0;
        }
        int left=0;
        int oddcount=0;
        int count=0;
        for(int right=0;right<nums.length;right++){
            if(nums[right]%2==1){
                oddcount++;
            }
            while(oddcount>k){
                if(nums[left]%2==1){
                    oddcount--;
                }
                left++;
            }
            count+=right-left+1;
        }
        return count;
    }
}