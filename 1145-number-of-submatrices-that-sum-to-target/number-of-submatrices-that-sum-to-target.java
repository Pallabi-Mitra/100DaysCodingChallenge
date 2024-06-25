class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {

          int rows = matrix.length;
    int cols = matrix[0].length;
    int count = 0;

    // Compute prefix sums for each row
    for (int r = 0; r < rows; r++) {
        for (int c = 1; c < cols; c++) {
            matrix[r][c] += matrix[r][c - 1];
        }
    }

    // Iterate over all pairs of columns
    for (int c1 = 0; c1 < cols; c1++) {
        for (int c2 = c1; c2 < cols; c2++) {
            Map<Integer, Integer> sumCount = new HashMap<>();
            sumCount.put(0, 1);
            int currSum = 0;

            for (int r = 0; r < rows; r++) {
                currSum += matrix[r][c2] - (c1 > 0 ? matrix[r][c1 - 1] : 0);

                count += sumCount.getOrDefault(currSum - target, 0);
                sumCount.put(currSum, sumCount.getOrDefault(currSum, 0) + 1);
            }
        }
    }

    return count;
        
    }
}

  

