class Solution {
    int[][] grid;
    public int uniquePaths(int m, int n) {
        grid = new int[m][n];
        grid[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i==0 && j==0) {
                    continue;
                }
                grid[i][j] = get(i, j);
            }
        }
        return grid[m-1][n-1];
    }
    private int get(int x, int y) {
        int result = 0;
        if (x-1 >= 0) {
            result += grid[x-1][y];
        }
        if (y-1 >= 0) {
            result += grid[x][y-1];
        }
        return result;
    }
}
