class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
       int n=edges.length;
       int dis1[]=new int[n];
       int dis2[]=new int[n];
       for(int i=0;i<n;i++){
        dis1[i]=-1;
        dis2[i]=-1;
       } 
       finddis(edges,node1,dis1);
       finddis(edges,node2,dis2);
       int ans=-1;
       int dis=Integer.MAX_VALUE;
       for(int i=0;i<n;i++){
        if(dis1[i]!=-1 && dis2[i]!=-1){
            int maxdis=Math.max(dis1[i],dis2[i]);
            if(maxdis<dis){
                dis=maxdis;
                ans=i;
            }
        }
       }
       return ans;
    }
    private void finddis(int edges[],int start,int dis[]){
        int node=start;
        int distance=0;
        while(node!=-1 && dis[node]==-1){
            dis[node]=distance;
            distance++;
            node=edges[node];
        }
    }
}