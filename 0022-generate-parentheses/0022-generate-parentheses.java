class Solution {
    public List<String> generateParenthesis(int n) {
       List<String> result = new ArrayList<>();
       helper("",0,0,n,result);
       return result; 
    }
    public void helper(String curr,int open,int close,int n,List<String> result){
        if(curr.length()==2*n){
            result.add(curr);
            return;
        }
        if(open<n){
            helper(curr+"(",open+1,close,n,result);
        }
        if(close<open){
            helper(curr+")",open,close+1,n,result);
        }
    }
}