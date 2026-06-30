class Solution {
    int[][] grid;
    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int count = dfs(i, j);
                    if (count > max) {
                        max = count;
                    }
                }
            }
        }
        return max;
    }
    private int dfs(int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[x].length) {
            return 0;
        }
        if (grid[x][y] == 0) {
            return 0;
        }
        grid[x][y] = 0;
        return dfs(x+1,  y) + dfs(x, y+1) + dfs (x, y-1) + dfs(x-1, y) +1;
    }
}
