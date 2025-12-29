class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int n=x;
        int r,rev=0;
        while(x>0)
        {
            r=x%10;
            rev=rev*10+r;
            x=x/10;
        }
        if(n==rev){
            return true;
        }
        else{
            return false;
        }
    }
}
