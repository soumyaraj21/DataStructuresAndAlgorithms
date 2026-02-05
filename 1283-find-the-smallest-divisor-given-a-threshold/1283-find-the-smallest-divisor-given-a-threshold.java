class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
         int n = nums.length;
        int low = 1;
        int high = nums[0];
        for (int i = 0; i < n; i++) {
            high = Math.max(high, nums[i]);
        }
        int answer = high;
        while (low <= high) {
            int mid = (low + high) / 2;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                int value = (int)Math.ceil((double)nums[i] / mid);
                sum += value;
            }
            if (sum <= threshold) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return answer;
    }
}

    