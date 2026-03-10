class Solution {
    public int removeElement(int[] nums, int val) {
        int n=nums.length;
        int k=0,temp=0;
        for(int i=0;i<n;i++){
            if(nums[i]!=val){
                nums[temp]=nums[i];
                temp++;
            }
            else{
                k=k+1;
            }
        }
        return temp;
    }
}