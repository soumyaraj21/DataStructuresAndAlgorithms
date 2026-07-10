class Solution {
    public void dfs(int row, int col, char[][] grid) {
        grid[row][col] = '0';
        int[] rowDirection = {-1, 0, 1, 0};
        int[] colDirection = {0, 1, 0, -1};
        for (int d = 0; d < 4; d++) {
            int newRow = row + rowDirection[d];
            int newCol = col + colDirection[d];
            if (newRow >= 0 &&
                newRow < grid.length &&
                newCol >= 0 &&
                newCol < grid[0].length &&
                grid[newRow][newCol] == '1') {
                dfs(newRow, newCol, grid);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int islands = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, grid);
                    islands++;
                }
            }
        }
        return islands;
    }
}