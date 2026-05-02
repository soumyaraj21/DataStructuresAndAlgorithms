class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
       Arrays.sort(nums);
       List<List<Integer>> result= new ArrayList<>();
       List<Integer> current = new ArrayList<>();
       generateSubsets(nums,0,current,result);
       return result;
    }
    public void generateSubsets(int nums[],int index,List<Integer> current,
    List<List<Integer>> result){
         result.add(new ArrayList<>(current));
         for(int i=index;i<=nums.length-1;i++){
            if(i>index && nums[i]==nums[i-1]){
                continue;
            }
             current.add(nums[i]);
            generateSubsets(nums, i + 1, current, result);
            current.remove(current.size() - 1);
         }
        }
}