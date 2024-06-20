class Solution {
    public int maxDistance(int[] position, int m) {
     

     
 Arrays.sort(position); // Step 1: Sort the positions
        int left = 1, right = position[position.length - 1] - position[0];
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canPlaceBalls(position, m, mid)) {
                result = mid; // Valid force found
                left = mid + 1; // Try for a larger minimum force
            } else {
                right = mid - 1; // Reduce the search range
            }
        }

        return result;
    }

    private boolean canPlaceBalls(int[] position, int m, int minForce) {
        int count = 1; // Place first ball
        int lastPosition = position[0];

        for (int i = 1; i < position.length; i++) {
            if (position[i] - lastPosition >= minForce) {
                count++;
                lastPosition = position[i];
                if (count == m) return true; // All balls placed
            }
        }

        return false; // Not all balls could be placed
    }
}