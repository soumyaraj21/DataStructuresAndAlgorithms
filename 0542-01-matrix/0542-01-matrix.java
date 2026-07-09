class Solution {
    public int[][] updateMatrix(int[][] mat) {
    int rows=mat.length;
    int cols=mat[0].length;
    Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];
        int[][] distance = new int[rows][cols];
        for(int i=0;i<=rows-1;i++){
            for(int j=0;j<=cols-1;j++){
                if(mat[i][j]==0){
                    queue.offer(new int[]{i, j, 0});
                    visited[i][j]=true;
                }
            }
        }
        int[] rowDirection = {-1, 0, 1, 0};
        int[] colDirection = {0, 1, 0, -1};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];
            int steps = cell[2];
            distance[row][col] = steps;
            for (int d = 0; d < 4; d++) {
                int newRow = row + rowDirection[d];
                int newCol = col + colDirection[d];
                if (newRow >= 0 && newRow < rows &&
                    newCol >= 0 && newCol < cols &&
                    !visited[newRow][newCol]) {
                    visited[newRow][newCol] = true;
                    queue.offer(new int[]{newRow, newCol, steps + 1});
                }
            }
        }
        return distance;
    }
}