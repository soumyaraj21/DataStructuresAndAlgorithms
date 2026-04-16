class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        helper(0, candidates, target, new ArrayList<>(), result);
        return result;
    }
    public void helper(int index, int[] arr, int target, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1]) {
                continue;
            }
            if (arr[i] > target) {
                break;
            }
             current.add(arr[i]);
            helper(i + 1, arr, target - arr[i], current, result);
            current.remove(current.size() - 1);
        }
    }
}