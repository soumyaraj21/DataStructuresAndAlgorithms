class Solution {
    public int compress(char[] chars) {
        int write=0;
        int i=0;
        while(i<chars.length){
         char current=chars[i];
          int j=i;
          while(j<chars.length && chars[j]==current){
            j++;
          }
          int count=j-i;
          chars[write++]=current;
          if(count>1){
            String s=String.valueOf(count);
            for(char c:s.toCharArray()){
                chars[write++]=c;
            }
          }
          i=j;
        }
        return write;
    }
}