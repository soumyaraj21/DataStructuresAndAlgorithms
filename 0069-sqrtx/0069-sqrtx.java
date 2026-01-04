class Solution {
    public int mySqrt(int x) {
        if (x <= 1) return x;

        int low = 1, high = x, ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Use long to avoid overflow when squaring
            long sq = (long) mid * mid;

            if (sq == x) return mid;

            if (sq < x) {
                ans = mid;          // mid is a candidate
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
