class Solution {
    boolean[][] explored;
    int[][] grid;
    boolean[][] added;
    PriorityQueue<Tile> minHeap;
    public int swimInWater(int[][] grid) {
        this.grid = grid;
        explored = new boolean[grid.length][grid[0].length];
        added = new boolean[grid.length][grid[0].length];
        minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        int t = 0;
        Tile start = new Tile(grid[0][0], new int[]{0, 0});
        minHeap.add(start);
        added[0][0] = true;
        while (explored[explored.length-1][explored[0].length-1] != true) {
            Tile lowest = minHeap.peek();
            while (!minHeap.isEmpty() && lowest.val <= t) {
                Tile curr = minHeap.poll();
                addTile(curr.pos[0], curr.pos[1]+1);
                addTile(curr.pos[0]+1, curr.pos[1]);
                addTile(curr.pos[0]-1, curr.pos[1]);
                addTile(curr.pos[0], curr.pos[1]-1);
                explored[curr.pos[0]][curr.pos[1]] = true;
                if (explored[explored.length-1][explored[0].length-1] == true) {
                    return t;
                }
                if (!minHeap.isEmpty()) {
                    lowest = minHeap.peek();
                }
            }
            t+=1;
        }
        return t;
    }
    private void addTile(int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return;
        }
        if (added[x][y] == true || explored[x][y] == true) {
            return;
        }
        int[] pos = new int[]{x, y};
        Tile tile = new Tile(grid[x][y], pos);
        minHeap.add(tile);
        added[x][y] = true;
    }
    private class Tile {
        int val;
        int[] pos;
        public Tile(int val, int[] pos) {
            this.val = val;
            this.pos = pos;
        }
    }
}
