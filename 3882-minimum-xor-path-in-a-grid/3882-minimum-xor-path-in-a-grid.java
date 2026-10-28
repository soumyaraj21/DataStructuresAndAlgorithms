class Solution {
    static final int LIM = 1 << 10;
    static final int BUCK = LIM >> 5;
    static final int MASK = (1 << 5) - 1;
    public int minCost(int[][] A) {
        int m = A.length, n = A[0].length;
        int[][] dp = new int[n][BUCK]; 
        dp[0][A[0][0] >> 5] |= 1 << (A[0][0] & MASK);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                int[] prev = new int[BUCK]; 
                if (i > 0) for (int k = 0; k < BUCK; k++) prev[k] |= dp[j][k];
                if (j > 0) for (int k = 0; k < BUCK; k++) prev[k] |= dp[j - 1][k];
                int val = A[i][j];
                int[] curr = new int[BUCK];
                for (int k = 0; k < LIM; k++)
                    if ((prev[k >> 5] & (1 << (k & MASK))) != 0)
                        curr[(k ^ val) >> 5] |= 1 << ((k ^ val) & MASK);
                dp[j] = curr;
            }
        }
        for (int k = 0; k < LIM; k++)
            if ((dp[n - 1][k >> 5] & (1 << (k & MASK))) != 0) return k;
        return 0;
    }
}