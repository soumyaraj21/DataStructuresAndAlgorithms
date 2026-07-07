
class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int total = 0;
        int rotten = 0;
        int time = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] != 0) {
                    total++;
                }
                if(grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                    rotten++;
                }
            }
        }
        int[] row = {-1, 0, 1, 0};
        int[] col = {0, 1, 0, -1};
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int k = 0; k < size; k++) {
                int[] cell = queue.poll();
                int r = cell[0];
                int c = cell[1];
                for(int d = 0; d < 4; d++) {
                    int newRow = r + row[d];
                    int newCol = c + col[d];
                      if(newRow >= 0 && newRow < rows &&
                       newCol >= 0 && newCol < cols &&
                       grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        queue.offer(new int[]{newRow, newCol});
                        rotten++;
                    }
                }
            }
            if(!queue.isEmpty()) {
                time++;
            }
        }
        if(rotten == total) {
            return time;
        } else {
            return -1;
        }
    }
}