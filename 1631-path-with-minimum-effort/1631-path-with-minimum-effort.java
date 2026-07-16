class Solution {
    static class Pair{
        int difference;
        int row;
        int col;
        Pair(int difference, int row, int col) {
            this.difference = difference;
            this.row = row;
            this.col = col;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int rows=heights.length;
        int cols=heights[0].length;
        int distance[][]=new int[rows][cols];
        for(int i=0;i<rows;i++){
             Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>((a, b) -> a.difference - b.difference);
        distance[0][0] = 0;
        priorityQueue.offer(new Pair(0, 0, 0));
        int[] rowDirection = {-1, 0, 1, 0};
        int[] colDirection = {0, 1, 0, -1};
        while (!priorityQueue.isEmpty()) {
            Pair current = priorityQueue.poll();
            int difference = current.difference;
            int row = current.row;
            int col = current.col;
            if (row == rows - 1 && col == cols - 1) {
                return difference;
            }
            for (int d = 0; d < 4; d++) {
                int newRow = row + rowDirection[d];
                int newCol = col + colDirection[d];
                if (newRow >= 0 && newRow < rows && newCol >= 0 &&
                    newCol < cols) {
                    int newDifference = Math.max(difference,
                            Math.abs(heights[row][col] - heights[newRow][newCol])
                    );
                    if (newDifference < distance[newRow][newCol]) {
                        distance[newRow][newCol] = newDifference;
                        priorityQueue.offer(
                                new Pair(newDifference, newRow, newCol)
                        );
                    }
                }
            }
        }

        return 0;
    }
}