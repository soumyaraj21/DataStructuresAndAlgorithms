class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(char task:tasks){
            map.put(task,map.getOrDefault(task,0)+1);
        }
        PriorityQueue<Integer> maxheap=new PriorityQueue<>(Collections.reverseOrder());
        for(int freq:map.values()){
        maxheap.offer(freq);
        }
        int time=0;
        while(!maxheap.isEmpty()){
            List<Integer> temp= new ArrayList<>();
            int cycle=n+1;
            while(cycle>0 && !maxheap.isEmpty()){
                int freq=maxheap.poll();
                freq--;
                if(freq>0){
                    temp.add(freq);
                }
                time++;
                cycle--;
            }
            for(int freq:temp){
                maxheap.offer(freq);
            }
            if(maxheap.isEmpty()){
                break;
            }
            time+=cycle;
        }
        return time;
    }
}