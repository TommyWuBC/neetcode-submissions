class Solution {
    int[][] heights;
    List<List<Integer>> results;
    boolean[][] visited;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        results = new ArrayList<>();
        if (heights == null || heights.length == 0) return results;
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                boolean reachAtlantic = false;
                boolean reachPacific = false;
                
                visited = new boolean[heights.length][heights[0].length];
                reachAtlantic = atlantic(i, j, heights[i][j]);
                
                visited = new boolean[heights.length][heights[0].length];
                reachPacific = pacific(i, j, heights[i][j]);
                
                if (reachAtlantic && reachPacific) {
                    results.add(new ArrayList<>(Arrays.asList(i, j)));
                }
            }
        }
        return results;
    }
    private boolean atlantic(int r, int c, int water) {
        if (r >= heights.length || c >= heights[0].length) {
            return true;
        }
        if (r < 0 || c < 0 || water < heights[r][c] || visited[r][c]) {
            return false;
        }
        visited[r][c] = true;
        int val = heights[r][c];
        return atlantic(r+1, c, val) || atlantic(r, c+1, val) || atlantic(r-1, c, val) || atlantic(r, c-1, val);
    }
    private boolean pacific(int r, int c, int water) {
        if (r < 0 || c < 0) {
            return true;
        } 
        if (r >= heights.length || c >= heights[0].length || water < heights[r][c] || visited[r][c]) {
            return false;
        }
        visited[r][c] = true;
        int val = heights[r][c];
        return pacific(r-1, c, val) || pacific(r, c-1, val) || pacific(r+1, c, val) || pacific(r, c+1, val);
    }
}