//import java.util.Arrays;

class Solution {
    public long repairCars(int[] ranks, int cars) {
        Arrays.sort(ranks); // Sorting to optimize binary search
        long low = 1, high = (long) ranks[0] * cars * cars, ans = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (canRepairInTime(ranks, cars, mid)) {
                ans = mid;
                high = mid - 1; // Try for a lower time
            } else {
                low = mid + 1; // Need more time
            }
        }
        return ans;
    }

    private boolean canRepairInTime(int[] ranks, int cars, long time) {
        long totalCarsRepaired = 0;
        for (int rank : ranks) {
            long maxCars = (long) Math.sqrt(time / rank);
            totalCarsRepaired += maxCars;
            if (totalCarsRepaired >= cars) {
                return true;
            }
        }
        return false;
    }
}
