class Solution {
    static class DisjointSet{
        int[] parent;
        int[] size;
        DisjointSet(int n){
            parent=new int[n];
            size=new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
                size[i]=1;
            }
        }
        int findUltimateParent(int node){
            if (node == parent[node]) {
                return node;
            }
            return parent[node] = findUltimateParent(parent[node]);
        }
        void unionBySize(int u, int v) {
            int ultimateParentU = findUltimateParent(u);
            int ultimateParentV = findUltimateParent(v);
            if (ultimateParentU == ultimateParentV) {
                return;
            }
            if (size[ultimateParentU] < size[ultimateParentV]) {
                parent[ultimateParentU] = ultimateParentV;
                size[ultimateParentV] += size[ultimateParentU];
            }
            else {
                parent[ultimateParentV] = ultimateParentU;
                size[ultimateParentU] += size[ultimateParentV];
            }
        }
    }
    public int makeConnected(int n, int[][] connections) {
    DisjointSet disjointSet = new DisjointSet(n);
        int extraEdges = 0;
        for (int[] edge : connections) {
            int u = edge[0];
            int v = edge[1];
            if (disjointSet.findUltimateParent(u) ==disjointSet.findUltimateParent(v))
             {
                extraEdges++;
            }
            else {
                disjointSet.unionBySize(u, v);
            }
        }
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (disjointSet.findUltimateParent(i) == i) {
                components++;
            }
        }
        int requiredEdges = components - 1;
        if (extraEdges >= requiredEdges) {
            return requiredEdges;
        }
        return -1;
    }
}  