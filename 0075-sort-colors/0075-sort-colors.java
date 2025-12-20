class Solution {
    public void sortColors(int[] nums){
        int n = nums.length;
        int low = 0, mid = 0, high = n - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low = low + 1;
                mid = mid + 1;
            }
            else if (nums[mid] == 1) {
                mid = mid + 1;
            }
            else {
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high = high - 1;
            }
        }
    }
}

