class Solution {
    class DisjointSet {
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
        int findParent(int node) {
            if (parent[node] == node)
                return node;
            return parent[node] = findParent(parent[node]);
        }
        void unionBySize(int u, int v) {
            int pu = findParent(u);
            int pv = findParent(v);
            if (pu == pv)
                return;
            if (size[pu] < size[pv]) {
                parent[pu] = pv;
                size[pv] += size[pu];
            } else {
                parent[pv] = pu;
                size[pu] += size[pv];
            }
        }
    }
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] position = new int[n * n][2];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                position[grid[row][col]][0] = row;
                position[grid[row][col]][1] = col;
            }
        }
        DisjointSet ds = new DisjointSet(n * n);
        boolean[][] active = new boolean[n][n];
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        for (int time = 0; time < n * n; time++) {
            int row = position[time][0];
            int col = position[time][1];
            active[row][col] = true;
            int node = row * n + col;
            for (int k = 0; k < 4; k++) {
                int nr = row + dr[k];
                int nc = col + dc[k];
                if (nr >= 0 && nr < n &&
                    nc >= 0 && nc < n &&
                    active[nr][nc]) {
                    int adjNode = nr * n + nc;
                    ds.unionBySize(node, adjNode);
                }
            }
            if (active[0][0] &&active[n - 1][n - 1] &&
                ds.findParent(0) == ds.findParent(n * n - 1)) {
                return time;
            }
        }
        return -1;
    }
}