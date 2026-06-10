class Solution {
    public int rob(int[] nums) {
       int n=nums.length;
       if(n==1){
        return nums[0];
       } 
       int arr1[]=new int[n-1];
       int arr2[]=new int[n-1];
       for(int i = 0; i < n-1; i++){
        arr1[i] = nums[i+1]; 
        arr2[i] = nums[i];   
}
       int ans1=solve(arr1);
       int ans2=solve(arr2);
       return Math.max(ans1,ans2);
    }
    public int solve(int[] arr) {
        int prev = arr[0];
        int prev2 = 0;
        for (int i = 1; i < arr.length; i++) {
            int pick = arr[i];
            if (i > 1) {
                pick += prev2;
            }
            int notPick = prev;
            int curr = Math.max(pick, notPick);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}