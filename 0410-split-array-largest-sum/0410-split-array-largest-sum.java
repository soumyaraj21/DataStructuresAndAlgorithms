class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int low = nums[0];
        int high = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > low) {
                low = nums[i];
            }
            high = high + nums[i];
        }
        int answer = high;
        while (low <= high) {
            int mid = (low + high) / 2;
            int sum = 0;
            int count = 1;
            for (int i = 0; i < n; i++) {
                if (sum + nums[i] > mid) {
                    count = count + 1;
                    sum = 0;
                }
                sum = sum + nums[i];
            }
            if (count <= k) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return answer;
    }
}
