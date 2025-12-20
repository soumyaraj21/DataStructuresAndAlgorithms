class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        int candidate=0;
        int count=0;
        for(int i=0;i<n;i++){
            if(count==0){
                candidate=nums[i];
                count=1;
            }
            else if(nums[i]==candidate){
                count=count+1;
            }
            else{
                count=count-1;
            }
        }
       return candidate; 
    }
}
       
       