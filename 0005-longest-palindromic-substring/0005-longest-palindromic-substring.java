class Solution {
    public String longestPalindrome(String s) {
    int start = 0;
    int maxLen = 1;
    for (int i = 0; i < s.length(); i++) {
    int left = i;
    int right = i;
     while (left >= 0 && right < s.length() &&  s.charAt(left) == s.charAt(right)) {
    int currentLen = right - left + 1;
    if (currentLen > maxLen) {
     start = left;
    maxLen = currentLen;
                }
    left--;
  right++;
            }
      left = i;
     right = i + 1;
     while (left >= 0 && right < s.length() && 
      s.charAt(left) == s.charAt(right)) {
        int currentLen = right - left + 1;
             if (currentLen > maxLen) {
                    start = left;
                    maxLen = currentLen;
                }

                left--;
                right++;
            }
        }
    return s.substring(start, start + maxLen);
    }
}