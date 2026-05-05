class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int sign=1;
        if((dividend<0 && divisor>0) || (dividend>0 && divisor<0)){
            sign=-1;
        }
        long dvd=Math.abs((long)dividend);
        long dvs=Math.abs((long)divisor);
        int quotient=0;
        while(dvd>=dvs){
            long temp=dvs;
            int multiple=1;
            while(dvd>=(temp<<1)){
                temp=temp<<1;
                multiple=multiple<<1;
            }
            dvd=dvd-temp;
            quotient=quotient+multiple;
        }
        if(sign==-1){
            quotient=-quotient;
        }
        return quotient;
    }
}