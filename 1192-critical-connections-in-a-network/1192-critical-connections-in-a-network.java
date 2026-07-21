class Solution {
    int timer=1;
    List<List<Integer>> answer = new ArrayList<>();
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    boolean[] visited;
    int[] tin;
    int[] low;
    private void dfs(int node,int parent){
        visited[node]=true;
        tin[node]=timer;
        low[node]=timer;
        timer++;
        for(int neighbour:adj.get(node)){
            if(neighbour==parent){
                continue;
            }
            if(!visited[neighbour]){
                dfs(neighbour,node);
                low[node]=Math.min(low[node],low[neighbour]);
                 if (low[neighbour] > tin[node]) {
                    answer.add(Arrays.asList(node, neighbour));
            }
        }
        else {
             low[node] = Math.min(low[node], tin[neighbour]);
        }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
       for(List<Integer>edge : connections) {
            int u = edge.get(0);
            int v = edge.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        visited = new boolean[n];
        tin = new int[n];
        low = new int[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, -1);
            }
        }
    return answer;
    }
}