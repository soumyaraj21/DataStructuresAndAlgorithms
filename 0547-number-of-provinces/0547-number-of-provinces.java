class Solution {
    public void dfs(int node,int[][] isConnected,boolean[] visited){
        visited[node]=true;
        for(int n=0;n<isConnected.length;n++){
            if(isConnected[node][n]==1  && !visited[n]) {
            dfs(n,isConnected,visited);
        }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int v=isConnected.length;
        boolean [] visited=new boolean[v];
        int provinces=0;
        for(int i=0;i<v;i++){
            if(visited[i]==false){
                dfs(i,isConnected,visited);
                provinces++;
            }
        }
        return provinces;
    }
}