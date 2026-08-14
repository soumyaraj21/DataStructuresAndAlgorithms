import java.util.*;
class Solution {
    public int[] topKFrequent(int[] nums,int k) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<int[]> minheap=new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(Map.Entry<Integer,Integer>entry:map.entrySet()){
            minheap.offer(new int[]{entry.getValue(),entry.getKey()});
            if(minheap.size()>k){
                minheap.poll();
            }
        }
        int[] result=new int[k];
        for (int i=0;i<k;i++){
            result[i]=minheap.poll()[1];
        }
        return result;
    }
}