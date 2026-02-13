class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int n = weights.length;
        int low = weights[0];
        int high = 0;

        for (int i = 0; i < n; i++) {
            if (weights[i] > low) {
                low = weights[i];
            }
            high = high + weights[i];
        }

        int answer = high;

        while (low <= high) {
            int mid = (low + high) / 2;
            int dayscount = 1;
            int currentLoad = 0;

            for (int i = 0; i < n; i++) {
                if (currentLoad + weights[i] > mid) {
                    dayscount = dayscount + 1;
                    currentLoad = 0;
                }
                currentLoad = currentLoad + weights[i];
            }
            if (dayscount <= days) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return answer;
    }
}

        