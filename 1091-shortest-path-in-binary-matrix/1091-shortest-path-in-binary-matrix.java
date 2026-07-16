class Solution {
    static class Pair {
        int distance;
        int row;
        int col;
        Pair(int distance, int row, int col) {
            this.distance = distance;
            this.row = row;
            this.col = col;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        if (grid[0][0] == 1 || grid[rows - 1][cols - 1] == 1) {
            return -1;
        }
        int[][] distance = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        Queue<Pair> queue = new LinkedList<>();
        distance[0][0] = 1;
        queue.offer(new Pair(1, 0, 0));
        int[] rowDirection = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] colDirection = {-1, 0, 1, -1, 1, -1, 0, 1};
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int dist = current.distance;
            int row = current.row;
            int col = current.col;
            if (row == rows - 1 && col == cols - 1) {
                return dist;
            }
            for (int d = 0; d < 8; d++) {
                int newRow = row + rowDirection[d];
                int newCol = col + colDirection[d];
                if (newRow >= 0 &&
                    newRow < rows &&
                    newCol >= 0 &&
                    newCol < cols &&
                    grid[newRow][newCol] == 0 &&
                    dist + 1 < distance[newRow][newCol]) {
                    distance[newRow][newCol] = dist + 1;
                    queue.offer(new Pair(dist + 1, newRow, newCol));
                }
            }
        }
        return -1;
    }
}