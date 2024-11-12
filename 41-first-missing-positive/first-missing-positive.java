class Solution {
    public int firstMissingPositive(int[] nums) {
          int n = nums.length;

    // Step 1: Place each number in its correct index position
    for (int i = 0; i < n; i++) {
        while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
            // Swap nums[i] with nums[nums[i] - 1] to place it in the correct position
            int correctIdx = nums[i] - 1;
            int temp = nums[i];
            nums[i] = nums[correctIdx];
            nums[correctIdx] = temp;
        }
    }

    // Step 2: Find the first index where the number is not at the correct position
    for (int i = 0; i < n; i++) {
        if (nums[i] != i + 1) {
            return i + 1; // The smallest missing positive
        }
    }

    // If all numbers are in the correct position, return n + 1
    return n + 1;  
    }
}