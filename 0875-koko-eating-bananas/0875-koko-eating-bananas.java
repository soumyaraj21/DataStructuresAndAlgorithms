class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int n = piles.length;
        int high = 0;

        for (int i = 0; i < n; i++) {
            high = Math.max(high, piles[i]);
        }

        int answer = high;

        while (low <= high) {
            int mid = (low + high) / 2;
            long time = 0;

            for (int i = 0; i < n; i++) {
                time += (piles[i] + mid - 1) / mid;
            }

            if (time <= h) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return answer;
    }
}
