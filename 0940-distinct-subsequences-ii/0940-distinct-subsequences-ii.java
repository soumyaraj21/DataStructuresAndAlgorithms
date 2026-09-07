class Solution{
    public int distinctSubseqII(String s){
        int MOD=1000000007;
        int[] dp=new int[26];
        for(char c:s.toCharArray()){
            int i=c-'a';
            int sum=0;
            for(int j=0;j<26;j++){
                sum=(sum+dp[j])%MOD;
            }
            dp[i]=(sum+1)%MOD;
        }
        int ans=0;
        for(int x:dp){
            ans=(ans+x)%MOD;
        }
        return ans;
    }
}