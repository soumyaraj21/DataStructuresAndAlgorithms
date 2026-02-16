class Solution {
    public int maxDepth(String s) {
        int p=0;
        int ans=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch == '('){
                p++;
            }
            else if(ch == ')'){
                p--;
            }
            ans=Math.max(ans,p);
        }
        return ans;
    }
}