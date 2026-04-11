class Solution {
    public int myAtoi(String s) {
        return atoi(s, 0, 1, 0, false);
    }
    public int atoi(String str, int idx, int sign, int result, boolean started) {
        if(idx < str.length() && str.charAt(idx) == ' ' && !started) {
            return atoi(str, idx + 1, sign, result, false);
        }
        if(idx == str.length()) {
            return sign * result;
        }
        if(!started) {
            if(str.charAt(idx) == '-') {
                return atoi(str, idx + 1, -1, result, true);
            }
            else if(str.charAt(idx) == '+') {
                return atoi(str, idx + 1, 1, result, true);
            }
        }
        if(str.charAt(idx) < '0' || str.charAt(idx) > '9') {
            return sign * result;
        }
        int digit = str.charAt(idx) - '0';
        if(result > Integer.MAX_VALUE / 10 || 
          (result == Integer.MAX_VALUE / 10 && digit > 7)) {
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        result = result * 10 + digit;
        return atoi(str, idx + 1, sign, result, true);
    }
}