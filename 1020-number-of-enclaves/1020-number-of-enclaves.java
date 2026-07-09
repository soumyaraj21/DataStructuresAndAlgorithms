class Solution {
    public int numEnclaves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            if (grid[i][0] == 1 && !visited[i][0]) {
                visited[i][0] = true;
                queue.offer(new int[]{i, 0});
            }
            if (grid[i][cols - 1] == 1 && !visited[i][cols - 1]) {
                visited[i][cols - 1] = true;
                queue.offer(new int[]{i, cols - 1});
            }
        }
        for (int j = 0; j < cols; j++) {
            if (grid[0][j] == 1 && !visited[0][j]) {
                visited[0][j] = true;
                queue.offer(new int[]{0, j});
            }
            if (grid[rows - 1][j] == 1 && !visited[rows - 1][j]) {
                visited[rows - 1][j] = true;
                queue.offer(new int[]{rows - 1, j});
            }
        }
        int[] rowDirection = {-1, 0, 1, 0};
        int[] colDirection = {0, 1, 0, -1};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];
            for (int d = 0; d < 4; d++) {
                int newRow = row + rowDirection[d];
                int newCol = col + colDirection[d];
                if (newRow >= 0 &&
                    newRow < rows &&
                    newCol >= 0 &&
                    newCol < cols &&
                    grid[newRow][newCol] == 1 &&
                    !visited[newRow][newCol]) {
                    visited[newRow][newCol] = true;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }
}