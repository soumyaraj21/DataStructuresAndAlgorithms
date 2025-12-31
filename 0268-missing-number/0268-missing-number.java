class Solution {
    public int missingNumber(int[] nums) {
       int xor=0;
       int finalxor=0;
       int n=nums.length;
       for(int i=0;i<=n;i++){
        xor=xor^i;
       } 
       for(int i=0;i<n;i++){
        finalxor=finalxor^nums[i];
       }
return xor^finalxor;
    }
}