class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (Character.isDigit(board[i][j])) {
                    if (rowSet.contains((int)board[i][j])) {
                        return false;
                    }
                    rowSet.add((int) board[i][j]);
                }
            }
        }
        for (int p = 0; p < 9; p++) {
            Set<Integer> columnSet = new HashSet<>();
            for (int q = 0; q < 9; q++) {
                if (Character.isDigit(board[q][p])) {
                    if (columnSet.contains((int) board[q][p])) {
                        return false;
                    }
                    columnSet.add((int) board[q][p]);
                }
            }
        }
        for (int boxRow = 0; boxRow < 9; boxRow += 3) {
            for (int boxCol = 0; boxCol < 9; boxCol += 3) {
                Set<Integer> boxSet = new HashSet<>();
                for (int r = boxRow; r < boxRow +3; r++) {
                    for (int l = boxCol; l < boxCol +3; l++) {
                        if (Character.isDigit(board[r][l])) {
                            if (boxSet.contains((int) board[r][l])) {
                                return false;
                            }
                            boxSet.add((int) board[r][l]);
                            }
                    }
                }
            }
        }
        return true;
    }
}
