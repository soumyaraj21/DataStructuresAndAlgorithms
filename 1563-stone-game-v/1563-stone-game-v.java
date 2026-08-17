class Solution{
    int[][] dp;
    int[] prefix;
    public int stoneGameV(int[] stoneValue){
        int n=stoneValue.length;
        dp=new int[n][n];
        for(int[] row:dp) Arrays.fill(row,-1);
        prefix=new int[n+1];
        for(int i=0;i<n;i++) prefix[i+1]=prefix[i]+stoneValue[i];
        return solve(0,n-1);
    }
    int solve(int l,int r){
        if(l==r) return 0;
        if(dp[l][r]!=-1) return dp[l][r];
        int ans=0;
        for(int k=l;k<r;k++){
            int left=prefix[k+1]-prefix[l];
            int right=prefix[r+1]-prefix[k+1];
            if(left<right){
                ans=Math.max(ans,left+solve(l,k));
            }else if(left>right){
                ans=Math.max(ans,right+solve(k+1,r));
            }else{
                ans=Math.max(ans,Math.max(left+solve(l,k),right+solve(k+1,r)));
            }
        }
        return dp[l][r]=ans;
    }
}