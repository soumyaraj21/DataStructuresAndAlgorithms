class Solution {
    int dp[][];
    public boolean isMatch(String s, String p) { 
        dp = new int[p.length()][s.length()];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(p.length() - 1, s.length() - 1, p, s);
    }
    private boolean solve(int i, int j, String p, String s) {
 if (i < 0 && j < 0)
            return true;
        if (i < 0 && j >= 0)
           return false;
        if (j < 0) {
            for (int k = 0; k <= i; k++) {
                if (p.charAt(k) != '*')
                    return false;
            }
            return true;
        }
        if (dp[i][j] != -1)
            return dp[i][j] == 1;
        boolean ans;
        if (p.charAt(i) == s.charAt(j) || p.charAt(i) == '?') {
         ans = solve(i - 1, j - 1, p, s);
        } else if (p.charAt(i) == '*') {
            ans = solve(i - 1, j, p, s) || solve(i, j - 1, p, s);
        } else {
            ans = false;
        }
        dp[i][j] = ans ? 1 : 0;
        return ans;
    }
}
    