class Solution{
    public String lexPalindromicPermutation(String s,String target){
        int n=s.length();
        int[] count=new int[26];
        for(char c:s.toCharArray())
            count[c-'a']++;
        char mid=0;
        for(int i=0;i<26;i++){
            if(count[i]%2==1){
                if(mid!=0)
                    return "";
                mid=(char)('a'+i);
            }
        }
        int[] half=new int[26];
        for(int i=0;i<26;i++)
            half[i]=count[i]/2;
        int m=n/2;
        StringBuilder prefix=new StringBuilder();
        for(int i=0;i<m;i++){
            int wanted=target.charAt(i)-'a';
            boolean found=false;
            for(int c=0;c<26;c++){
                if(half[c]==0)
                    continue;
                half[c]--;
                prefix.append((char)('a'+c));
                if(c>wanted){
                    StringBuilder left=new StringBuilder(prefix);
                    for(int x=0;x<26;x++){
                        while(half[x]>0){
                            left.append((char)('a'+x));
                            half[x]--;
                        }
                    }
                    String leftPart=left.toString();
                    StringBuilder ans=new StringBuilder(leftPart);
                    if(mid!=0)
                        ans.append(mid);
                    ans.append(new StringBuilder(leftPart).reverse());
                    return ans.toString();
                }
                if(c==wanted){
                    found=true;
                    break;
                }
                prefix.deleteCharAt(prefix.length()-1);
                half[c]++;
            }
            if(!found)
                break;
        }
        if(prefix.length()==m){
            String left=prefix.toString();
            StringBuilder ans=new StringBuilder(left);
            if(mid!=0)
                ans.append(mid);
            ans.append(new StringBuilder(left).reverse());
            if(ans.toString().compareTo(target)>0)
                return ans.toString();
        }
        while(prefix.length()>0){
            int pos=prefix.length()-1;
            int old=prefix.charAt(pos)-'a';
            half[old]++;
            prefix.deleteCharAt(pos);
            for(int c=old+1;c<26;c++){
                if(half[c]==0)
                    continue;
                half[c]--;
                StringBuilder left=new StringBuilder(prefix);
                left.append((char)('a'+c));
                for(int x=0;x<26;x++){
                    while(half[x]>0){
                        left.append((char)('a'+x));
                        half[x]--;
                    }
                }
                String leftPart=left.toString();
                StringBuilder ans=new StringBuilder(leftPart);
                if(mid!=0)
                 ans.append(mid);
                ans.append(new StringBuilder(leftPart).reverse());
                return ans.toString();
            }
        }
        return "";
    }
}
