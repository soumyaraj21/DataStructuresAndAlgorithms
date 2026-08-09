class Solution {
    int dp[][];
        int suffix[];
        int n;
    public int stoneGameII(int[] piles) {
        n=piles.length;
        suffix=new int[n+1];
        for(int i=n-1;i>=0;i--){
            suffix[i]=piles[i]+suffix[i+1];
        }
        dp=new int[n][n+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(0,1);
    }
    public int solve(int index,int m){
        if(index==n){
            return 0;
        }
        if(dp[index][m]!=-1){
            return dp[index][m];
        }
        int total=suffix[index];
        int best=0;
        for(int x=1;x<=2*m;x++){
            if(index+x>n){
                break;
            }
            int newm=Math.max(m,x);
            int opponent=solve(index+x,newm);
            int currentplayer=total-opponent;
            best=Math.max(best,currentplayer);
        }
        dp[index][m]=best;
        return best;
    }
}