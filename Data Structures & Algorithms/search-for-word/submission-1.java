class Solution {
    char[][] board;
    String word;
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        visited = new boolean[board.length][board[0].length];
        int x = 0;
        int y = 0;
        boolean result;
        while (x < board.length) {
            y=0;
            while (y < board[x].length) {
                if (word.charAt(0) == board[x][y]) {
                    result = backtrack(0, x, y);
                    if (result == true) {
                        return true;
                    }
                }
                y++;
            }
            x++;
        }
        return false;
    }
    private boolean backtrack(int index, int i, int j) {
        if (index >= word.length()) {
            return true;
        }
        if (i < 0|| i >= board.length || j >= board[i].length || j < 0) {
            return false;
        }
        if (visited[i][j]  == true) {
            return false;
        }
        if (word.charAt(index) != board[i][j]) {
            return false;
        }
        visited[i][j] = true;
        boolean path = backtrack(index+1, i+1, j) || backtrack(index +1, i, j+1) || backtrack(index+1, i-1, j) || backtrack(index+1, i, j-1);
        visited[i][j] = false;
        return path;
    }

}
