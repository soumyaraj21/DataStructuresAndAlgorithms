class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
       int originalcolor = image[sr][sc];
        if (originalcolor == color) {
            return image;
        }
        dfs(sr, sc, image, originalcolor, color);
        return image;
    }
    public void dfs(int row, int col, int[][] image, int originalcolor, int color) {
        image[row][col] = color;
        int[] rowdirection = {-1, 0, 1, 0};
        int[] coldirection = {0, 1, 0, -1};
        for (int d = 0; d < 4; d++) {
            int newrow = row + rowdirection[d];
            int newcol = col + coldirection[d];
            if (newrow >= 0 && newrow < image.length &&
                newcol >= 0 && newcol < image[0].length &&
                image[newrow][newcol] == originalcolor) {
                dfs(newrow, newcol, image, originalcolor, color);
            }
        }
    }
}

