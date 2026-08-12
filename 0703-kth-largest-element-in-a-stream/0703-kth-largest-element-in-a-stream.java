class KthLargest {
    PriorityQueue<Integer> minheap;
    int size;
    public KthLargest(int k, int[] nums) {
       minheap=new PriorityQueue<>();
       size=k;
       for(int i=0;i<nums.length;i++){
        minheap.offer(nums[i]);
        if(minheap.size()>k){
            minheap.poll();
        }
       } 
    }
    public int add(int val) {
        minheap.offer(val);
        if(minheap.size()>size){
            minheap.poll();
        }
    return minheap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */