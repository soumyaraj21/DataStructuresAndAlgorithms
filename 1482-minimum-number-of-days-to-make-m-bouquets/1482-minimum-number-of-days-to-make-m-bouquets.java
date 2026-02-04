class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;
        if ( m * k > n) {
            return -1;
        }
        int low = bloomDay[0];
        int high = bloomDay[0];
        for (int i = 0; i < n; i++) {
            low = Math.min(low, bloomDay[i]);
            high = Math.max(high, bloomDay[i]);
        }
        int answer = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int bouquets = 0;
            int flowers = 0;
            for (int i = 0; i < n; i++) {
                if (bloomDay[i] <= mid) {
                    flowers++;
                    if (flowers == k) {
                        bouquets++;
                        flowers = 0;
                    }
                } else {
                    flowers = 0;
                }
            }
            if (bouquets >= m) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return answer;
    }
}