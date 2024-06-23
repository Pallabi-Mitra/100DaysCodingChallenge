class Solution {
    public List<List<String>> solveNQueens(int n) {



        // Initialize a list to store all solutions
        List<List<String>> result = new ArrayList<>();
        // Initialize the board with empty spaces
        char[][] board = new char[n][n];
        
        // Initialize the board with empty spaces ('.')
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        
        // Arrays to track availability of rows and diagonals
        int[] leftRow = new int[n]; // Tracks rows
        int[] lowerDiagonal = new int[2 * n - 1]; // Tracks lower diagonals
        int[] upperDiagonal = new int[2 * n - 1]; // Tracks upper diagonals
        
        // Start the backtracking process from the first column
        backtrack(result, board, 0, leftRow, lowerDiagonal, upperDiagonal);
        
        // Return all solutions found
        return result;
    }
    
    // Backtracking method to find all solutions
    private void backtrack(List<List<String>> result, char[][] board, int col,
                           int[] leftRow, int[] lowerDiagonal, int[] upperDiagonal) {
        int n = board.length;
        // Base case: if all columns are processed, add the current board configuration to the result
        if (col == n) {
            // Convert the board configuration to List<String> and add to the result
            List<String> currentBoard = new ArrayList<>();
            for (char[] row : board) {
                currentBoard.add(new String(row));
            }
            result.add(currentBoard);
            return;
        }
        
        // Try placing queen in each row of the current column
        for (int row = 0; row < n; row++) {
            // Check if it's valid to place a queen at board[row][col]
            if (leftRow[row] == 0 && lowerDiagonal[row + col] == 0 && upperDiagonal[n - 1 + col - row] == 0) {
                // Place the queen
                board[row][col] = 'Q';
                // Update the arrays to mark rows and diagonals as under attack
                leftRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[n - 1 + col - row] = 1;
                
                // Recur to the next column
                backtrack(result, board, col + 1, leftRow, lowerDiagonal, upperDiagonal);
                
                // Backtrack: Remove the queen and restore the previous state
                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[n - 1 + col - row] = 0;
            }
        }
    }
}







        //  Brute force O(n) searching for placing queen safe or not

        /*
        // Initialize a list to store all solutions
        List<List<String>> result = new ArrayList<>();
        // Initialize the board with empty spaces
        char[][] board = new char[n][n];
        
        // Initialize the board with empty spaces ('.')
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        
        // Start the backtracking process from the first column
        backtrack(result, board, 0);
        
        // Return all solutions found
        return result;
    }

    // Backtracking method to find all solutions
    private void backtrack(List<List<String>> result, char[][] board, int col) {
        // If all columns are processed, add the current board configuration to the result
        if (col == board.length) {
            // Convert the board configuration to List<String> and add to the result
            List<String> currentBoard = new ArrayList<>();
            for (char[] r : board) {
                currentBoard.add(new String(r));
            }
            result.add(currentBoard);
            return;
        }
        
        // Try placing queen in each row of the current column
        for (int row = 0; row < board.length; row++) {
            // Check if it's valid to place a queen at board[row][col]
            if (isValid(board, row, col)) {
                // Place the queen
                board[row][col] = 'Q';
                // Recur to the next column
                backtrack(result, board, col + 1);
                // Backtrack: Remove the queen and try the next row
                board[row][col] = '.';
            }
        }
    }

    // Helper method to check if it's valid to place a queen at board[row][col]
    private boolean isValid(char[][] board, int row, int col) {
        int n = board.length;
        
        // Check the current row
        for (int j = 0; j < col; j++) {
            if (board[row][j] == 'Q') {
                return false;
            }
        }
        
        // Check the upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        
        // Check the lower-left diagonal
        for (int i = row + 1, j = col - 1; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        
        // If no conflicts found, it's valid to place the queen
        return true;

       }
}

        */
 