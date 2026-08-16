class Solution{
    public boolean stoneGameIX(int[] stones){
        int count0=0,count1=0,count2=0;
        for(int stone:stones){
            if(stone%3==0) count0++;
            else if(stone%3==1) count1++;
            else count2++;
        }
        if(count0%2==0){
            return count1>0&&count2>0;
        }
        return Math.abs(count1-count2)>2;
    }
}