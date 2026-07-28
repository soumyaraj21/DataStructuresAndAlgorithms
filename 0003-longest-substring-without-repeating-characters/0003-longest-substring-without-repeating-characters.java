class Solution {
    public int lengthOfLongestSubstring(String s) {
        int hash[]=new int[256];
        Arrays.fill(hash,-1);
        int left=0;
        int maxLen=0;
        for (int right=0; right<s.length();right++){
            if(hash[s.charAt(right)]!=-1 && hash[s.charAt(right)]>=left){
                left=hash[s.charAt(right)]+1;
            }
            int currLen=right-left+1;
            maxLen = Math.max(maxLen, currLen);
            hash[s.charAt(right)] = right;
        }
        return maxLen;
    }
}