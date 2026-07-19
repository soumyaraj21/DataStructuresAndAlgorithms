class Solution {
     static class DisjointSet {
        int[] parent;
        int[] size;
        DisjointSet(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }
        int findUltimateParent(int node) {
            if (node == parent[node]) {
                return node;
            }
            return parent[node] =
                    findUltimateParent(parent[node]);
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
    public int removeStones(int[][] stones) {
        int maxRow = 0;
        int maxCol = 0;
        for (int[] stone : stones) {
            maxRow = Math.max(maxRow, stone[0]);
            maxCol = Math.max(maxCol, stone[1]);
        }
        DisjointSet disjointSet = new DisjointSet(maxRow + maxCol + 2);
        HashMap<Integer, Integer> stoneNodes = new HashMap<>();
        for (int[] stone : stones) {
            int row = stone[0];
            int col = stone[1] + maxRow + 1;
            disjointSet.unionBySize(row, col);
            stoneNodes.put(row, 1);
            stoneNodes.put(col, 1);
        }
        int components = 0;
        for (int node : stoneNodes.keySet()) {
            if (disjointSet.findUltimateParent(node) == node) {
                components++;
            }
        }
        return stones.length - components;
    }
}