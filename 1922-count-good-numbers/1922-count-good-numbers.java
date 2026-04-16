class Solution {
    public int countGoodNumbers(long n) {
        long mod = 1_000_000_007;
        long evenNum = (n+1)/2;
        long oddNum = n/2;
        long ans = (pow(5L, evenNum, mod) * pow(4L, oddNum, mod)) % mod;
        return (int)ans;
    }
    public long pow(long base, long exp, long mod) {
        if (exp == 0) {
            return 1;
        }
        long call = pow(base, exp/2, mod);
        if (exp % 2 == 0) {
            return (call * call) % mod;
        }
        else {
            return (base * call % mod * call % mod) % mod;
        }
    }
}