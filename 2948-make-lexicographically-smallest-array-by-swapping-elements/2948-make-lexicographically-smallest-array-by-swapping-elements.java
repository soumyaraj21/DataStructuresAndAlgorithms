class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n=nums.length;
        int elements[][]=new int[n][2];
            for(int i=0;i<n;i++){
            elements[i][0]=nums[i];
            elements[i][1]=i;
            }
            Arrays.sort(elements,(a,b)->Integer.compare(a[0],b[0]));
            int answer[]=new int[n];
            int start=0;
            while(start<n){
                int end=start;
            while(end+1<n && elements[end+1][0]-elements[end][0]<=limit){
                end++;
            }
            ArrayList<Integer> values=new ArrayList<>();
            ArrayList<Integer> indices=new ArrayList<>();
            for(int i=start;i<=end;i++){
                values.add(elements[i][0]);
                indices.add(elements[i][1]);
            }
            Collections.sort(indices);
            for(int i=0;i<values.size();i++){
                answer[indices.get(i)]=values.get(i);
            }
            start=end+1;
        }    
        return answer;
    }
}