class Solution {
    public String minWindow(String s, String t) {
        int freq[]=new int[256];
        for(int i=0;i<t.length();i++){
            freq[t.charAt(i)]++;
        }
        int left=0;;
        int count=t.length();
        int minlen=Integer.MAX_VALUE;
        int starti=0;
        for(int right=0;right<s.length();right++){
            if(freq[s.charAt(right)]>0){
                count--;
            }
            freq[s.charAt(right)]--;
            while(count==0){
                if(right-left+1<minlen){
                    minlen=right-left+1;
                    starti=left;
                }
                freq[s.charAt(left)]++;
                if(freq[s.charAt(left)]>0){
                    count++;
                }
                left++;
            }
        }
            if(minlen==Integer.MAX_VALUE){
                return "";
            }
            return s.substring(starti,starti+minlen);
        }
    }