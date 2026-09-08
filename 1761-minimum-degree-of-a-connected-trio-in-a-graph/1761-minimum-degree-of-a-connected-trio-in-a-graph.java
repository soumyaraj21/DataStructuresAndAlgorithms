class Solution {
    public int minTrioDegree(int n, int[][] edges) {
        boolean connected[][]=new boolean[n+1][n+1];
        int degree[]=new int[n+1];
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            connected[u][v]=true;
            connected[v][u]=true;
            degree[u]++;
            degree[v]++;
        }
        int ans=-1;
        for(int i=1;i<=n;i++){
            for(int j=i+1;j<=n;j++){
                 if(!connected[i][j]){
                    continue;
                 }
                 for(int k=j+1;k<=n;k++){
                    if(connected[i][k] && connected[j][k]){
                        int tridegree=degree[i]+degree[j]+degree[k]-6;
                        if(ans==-1){
                            ans=tridegree;
                        }
                        else{
                            ans=Math.min(ans,tridegree);
                        }
                    }
                 }
            }
        }
        return ans;
    }
}