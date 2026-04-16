class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        helper(0,candidates,target,new ArrayList<>(), result);
        return result;
    }
    public void helper(int index, int[] arr, int target, List<Integer> current, List<List<Integer>> result) {
        if(target==0){
            result.add(new ArrayList<>(current));
            return;
        }
        if(index==arr.length){
            return;
        }
        if (arr[index] <= target) {
            current.add(arr[index]);
            helper(index, arr, target - arr[index], current, result);
            current.remove(current.size() - 1);
        }
        helper(index + 1, arr, target, current, result);
    }
}