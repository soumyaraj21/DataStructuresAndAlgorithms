class Solution {
    public int longestCycle(int[] edges) {
        int n=edges.length;
        int visited[]=new int[n];
        int time=1;
        int ans=-1;
        for(int i=0;i<n;i++){
            if(visited[i]!=0){
                continue;
            }
            int node=i;
            int starttime=time;
            while(node!=-1 && visited[node]==0){
                visited[node]=time;
                time++;
                node=edges[node];
            }
            if(node!=-1 && visited[node]>=starttime){
                int length=time-visited[node];
                ans=Math.max(ans,length);
            }
        }
        return ans;
    }
}