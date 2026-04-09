class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return power(x, N);
    }
    private double power(double x, long n) {
        if (n == 0) {
            return 1;
        }
        double call = power(x, n / 2);
        if (n % 2 == 0) {
            return call * call;
        } else {
            return x * call * call;
        }
    }
}