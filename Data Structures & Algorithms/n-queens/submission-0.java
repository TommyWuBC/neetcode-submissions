class Solution {
    int n;
    List<List<String>> output;
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        output = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int r = 0; r < n; r++) {
            Arrays.fill(board[r], '.');
        }
        backtrack(0, board);
        return output;
    }
    private void backtrack(int row, char[][] board) {
        if (row == n) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(new String(board[i]));
            }
            output.add(list);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(board, row, col)) {
                board[row][col] = 'Q';
                backtrack(row+1, board);
                board[row][col] = '.';
            }
        }
    }
    private boolean isValid(char[][] board, int row, int col) {
        int left = col-1;
        int right = col+1;
        for (int i = row-1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
            if (left >=0 && board[i][left] == 'Q') {
                return false;
            }
            if (right < n && board[i][right] == 'Q') {
                return false;
            }
            left--;
            right++;
        }
        return true;
    }
}
