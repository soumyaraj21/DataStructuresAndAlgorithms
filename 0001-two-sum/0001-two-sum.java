import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        int n = nums.length;
        HashMap<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < n; i++) {

            int complement = target - nums[i];

            if (indexMap.containsKey(complement)) {

                int firstIndex = indexMap.get(complement);
                int secondIndex = i;

                if (firstIndex < secondIndex) {
                    return new int[]{ firstIndex, secondIndex };
                } else {
                    return new int[]{ secondIndex, firstIndex };
                }
            }

            indexMap.put(nums[i], i);
        }

        return new int[]{ -1, -1 };
    }
}

 