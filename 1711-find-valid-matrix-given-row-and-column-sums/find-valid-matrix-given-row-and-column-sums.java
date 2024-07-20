class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {

         int m = rowSum.length; // number of rows
    int n = colSum.length; // number of columns
    int[][] matrix = new int[m][n]; // result matrix

    // Iterate through each cell of the matrix
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            // Set the cell to the minimum of the remaining sums
            int value = Math.min(rowSum[i], colSum[j]);
            matrix[i][j] = value;
            // Subtract the value from both rowSum and colSum
            rowSum[i] -= value;
            colSum[j] -= value;
        }
    }
    
    return matrix;
        
    }
}