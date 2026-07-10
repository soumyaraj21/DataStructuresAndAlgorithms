class Solution {
    public boolean dfs(int node, int col, int[] color, int[][] graph) {
        color[node] = col;
        for (int neighbour : graph[node]) {
            if (color[neighbour] == -1) {
                if (!dfs(neighbour, 1 - col, color, graph)) {
                    return false;
                }
            } 
            else if (color[neighbour] == col) {
                return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] color = new int[V];
        for (int i = 0; i < V; i++) {
            color[i] = -1;
        }
        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!dfs(i, 0, color, graph)) {
                    return false;
                }
            }
        }
        return true;
    }
}