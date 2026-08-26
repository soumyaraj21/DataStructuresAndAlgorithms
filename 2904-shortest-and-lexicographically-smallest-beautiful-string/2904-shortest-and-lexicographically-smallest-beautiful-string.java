class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
      int n=s.length();
      int left=0,ones=0;
      String best="";
      for(int right=0;right<s.length();right++){
      if(s.charAt(right)=='1'){
        ones++;
      }
        while(ones>k){
            if(s.charAt(left)=='1'){
                ones--;
            }
                left++;
        }
                if(ones==k){
                    while(s.charAt(left) == '0'){
                        left++;
                    }
                String current=s.substring(left,right + 1);
                if(best.equals("") || current.length()<best.length() || (current.length()==best.length() && current.compareTo(best)<0)){
                    best = current;
            }
        }
    }
      return best;
    }
}