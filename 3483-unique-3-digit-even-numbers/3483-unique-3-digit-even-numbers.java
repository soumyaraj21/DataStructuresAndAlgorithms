class Solution {
    public int totalNumbers(int[] digits) {
       int freq[]=new int[10];
       for(int x:digits){
        freq[x]++;
       }
       int ans=0;
       for(int num=100;num<999;num++){
        if(num%2!=0){
            continue;
        }
        int x=num;
        int need[]=new int[10];
        while(x>0){
            need[x%10]++;
            x=x/10;
        }
        boolean possible=true;
        for(int i=0;i<10;i++){
            if(need[i]>freq[i]){
                possible=false;
                break;
            }
        }
        if(possible)
        ans++;
       } 
       return ans;
    }
}