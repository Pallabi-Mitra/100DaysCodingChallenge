class Solution {
    public List<List<String>> solveNQueens(int n) {

        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        
        // Initialize the board with empty spaces
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        
        // Start the backtracking process
        backtrack(result, board, 0);
        return result;
    }

    private void backtrack(List<List<String>> result, char[][] board, int row) {
        if (row == board.length) { // All rows processed, a valid solution found
            List<String> currentBoard = new ArrayList<>();
            for (char[] r : board) {
                currentBoard.add(new String(r));
            }
            result.add(currentBoard);
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if (isValid(board, row, col)) {
                // Place the queen
                board[row][col] = 'Q';
                // Recur to the next row
                backtrack(result, board, row + 1);
                // Backtrack: Remove the queen
                board[row][col] = '.';
            }
        }
    }

    private boolean isValid(char[][] board, int row, int col) {
        // Check the column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // Check the upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // Check the upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
        
        
    
}