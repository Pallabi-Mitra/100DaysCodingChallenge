class Solution {
    public int minIncrementForUnique(int[] A) {
      Arrays.sort(A); // Sort the array
    int moves = 0;
    for (int i = 1; i < A.length; i++) {
        if (A[i] <= A[i - 1]) { // If current element is not greater than previous
            int increment = A[i - 1] - A[i] + 1; // Calculate increment needed
            A[i] += increment; // Increment current element
            moves += increment; // Increment moves count
        }
    }
    return moves;
    }
}