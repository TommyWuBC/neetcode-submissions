class Solution {
    int[][] grid;
    public void islandsAndTreasure(int[][] grid) {
        this.grid = grid;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == Math.pow(2, 31) -1) {
                    boolean[][] visited = new boolean[grid.length][grid[0].length];
                    bfs(i, j, visited);
                }
            }
        }

    }
    private void bfs(int i, int j, boolean visited[][]) {
        Node node = new Node(i, j);
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        int dist = -1;
        while (!queue.isEmpty()) {
            dist++;
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                Node n = queue.poll();
                if (n.x < 0 || n.x >= grid.length || n.y < 0 || n.y >= grid[n.x].length || visited[n.x][n.y] == true) {
                    continue;
                }
                if (grid[n.x][n.y] == -1) {
                    continue;
                }
                if (grid[n.x][n.y] == 0) {
                    grid[i][j] = dist;
                    return;
                }
                queue.add(new Node(n.x-1, n.y));
                queue.add(new Node(n.x, n.y-1));
                queue.add(new Node(n.x+1, n.y));
                queue.add(new Node(n.x, n.y+1));
                visited[n.x][n.y] = true;
            }
        }
    }
    private class Node {
        int x;
        int y;
        public Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
