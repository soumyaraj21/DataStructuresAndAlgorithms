class Solution {
    long[] s, q, lz;
    void app(int o, int len, long k) {
        q[o] += 2 * k * s[o] + k * k * len;
        s[o] += k * len;
        lz[o] += k;
    }
    void upd(int o, int l, int r, int L, int R) {
        if (L <= l && r <= R) { app(o, r - l + 1, 1); return; }
        int m = (l + r) >> 1;
        if (lz[o] != 0) {
            app(2*o, m - l + 1, lz[o]);
            app(2*o+1, r - m, lz[o]);
            lz[o] = 0;
        }
        if (L <= m) upd(2*o, l, m, L, R);
        if (R > m) upd(2*o+1, m+1, r, L, R);
        s[o] = s[2*o] + s[2*o+1];
        q[o] = q[2*o] + q[2*o+1];
    }
    public int sumCounts(int[] nums) {
        final long MOD = 1_000_000_007L;
        int n = nums.length;
        s = new long[4*n]; q = new long[4*n]; lz = new long[4*n];
        int[] last = new int[100001];
        java.util.Arrays.fill(last, -1);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            upd(1, 0, n-1, last[nums[i]] + 1, i);
            last[nums[i]] = i;
            ans = (ans + q[1]) % MOD;
        }
        return (int) ans;
    }
}