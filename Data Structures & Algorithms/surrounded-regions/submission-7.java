class Solution {
    char[][] board;
    boolean[][] visited;
    public void solve(char[][] board) {
        this.board = board;
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                visited = new boolean[board.length][board[0].length];
                bfs(i, 0);
            }
            if (board[i][board[0].length-1] == 'O') {
                visited = new boolean[board.length][board[0].length];
                bfs(i, board[0].length-1);
            }
        }
        for (int j = 0; j < board[0].length; j++) {
            if (board[0][j] == 'O') {
                visited = new boolean[board.length][board[0].length];
                bfs(0, j);
            }
            if (board[board.length-1][j] == 'O') {
                visited = new boolean[board.length][board[0].length];
                bfs(board.length-1, j);
            }
        }
        for (int x = 0; x  < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                if (board[x][y] == '#') {
                    board[x][y] = 'O';
                } else if (board[x][y] == 'O') {
                    board[x][y] = 'X';
                }
            }
        }
    }
    private void bfs(int r, int c) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length) {
            return;
        }
        if (board[r][c] != 'O') {
            return;
        }
        if (visited[r][c] == true) {
            return;
        }
        visited[r][c] = true;
        board[r][c] = '#';
        bfs(r+1, c);
        bfs(r, c+1);
        bfs(r-1, c);
        bfs(r, c-1);
    }
}
