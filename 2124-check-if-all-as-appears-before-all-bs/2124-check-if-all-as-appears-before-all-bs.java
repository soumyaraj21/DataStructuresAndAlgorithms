class Solution {
    public boolean checkString(String s) {
        boolean flag = false;
        for(char ch : s.toCharArray())
        {
            if(flag && ch == 'a')
                return false;
            if(ch == 'b')
                flag = true;
        }
        return true;
    }
}