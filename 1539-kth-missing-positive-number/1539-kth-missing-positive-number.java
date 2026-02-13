class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        int mid, missing, result;
        while (low <= high) {
            mid = (low + high) / 2;
            missing = arr[mid] - (mid + 1);
            if (missing < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        result = low + k;
        return result;
    }
}