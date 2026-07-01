class Solution {
    int[][] grid;
    List<List<Integer>> rotten;
    public int orangesRotting(int[][] grid) {
        this.grid = grid;
        rotten = new ArrayList<>();
        int fresh = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    rotten.add(new ArrayList<>(Arrays.asList(i, j)));
                    grid[i][j]=1;
                    fresh++;
                } else if (grid[i][j] ==1) {
                    fresh++;
                }
            }
        }
        if (fresh == 0) {
            return 0;
        }
        Queue<List<Integer>> queue = new LinkedList<>();
        for (List l : rotten) {
            queue.add(l);
        }
        int count =-1;
        while (!queue.isEmpty() && fresh >0) {
            int size = queue.size();
            count++;
            for (int k = 0; k < size; k++) {
                List<Integer> list = queue.poll();
                int x = list.get(0);
                int y = list.get(1);
                if (x < 0 || x>= grid.length || y <0 || y>= grid[0].length) {
                    continue;
                }
                if (grid[x][y] == 2 || grid[x][y] == 0) {
                    continue;
                }
                grid[x][y] = 2;
                fresh--;
                queue.add(new ArrayList<>(Arrays.asList(x+1, y)));
                queue.add(new ArrayList<>(Arrays.asList(x, y+1)));
                queue.add(new ArrayList<>(Arrays.asList(x-1, y)));
                queue.add(new ArrayList<>(Arrays.asList(x, y-1)));
            }
        }
        if (fresh != 0) {
            return -1;
        }
        return count;
    }
}
