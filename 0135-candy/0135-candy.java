class Solution {
    public int candy(int[] ratings) {
        int total=ratings.length;
        int curr=1;
        while(curr<ratings.length){
            if(ratings[curr]==ratings[curr-1]){
                curr++;
                continue;
            }
            int increasingSlope=0;
            while(curr<ratings.length && ratings[curr]>ratings[curr-1]){
                increasingSlope++;
                total=total+increasingSlope;
                curr++;
            }
            int decreasingSlope=0;
            while(curr<ratings.length && ratings[curr]<ratings[curr-1]){
                decreasingSlope++;
                total=total+decreasingSlope;
                curr++;
            }
            total=total-Math.min(increasingSlope,decreasingSlope);
        }
        return total;
    }
}