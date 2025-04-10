class Solution {
    public void nextPermutation(int[] nums) {
        int ind = -1;
        int n = nums.length;

        // Step 1: Find the breakpoint
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                ind = i;
                break; // Break after finding the first dip
            }
        }

        if (ind == -1) {
            // If no breakpoint is found, reverse the entire array
            int p1 = 0;
            int p2 = n - 1;
            while (p1 < p2) {
                int temp = nums[p2];
                nums[p2] = nums[p1];
                nums[p1] = temp;
                p1++;
                p2--;
            }
            return; // Early exit to prevent further operations
        }

        // Step 2: Find the next larger element to swap with nums[ind]
        for (int i = n - 1; i > ind; i--) {
            if (nums[i] > nums[ind]) {
                int temp = nums[i];
                nums[i] = nums[ind];
                nums[ind] = temp;
                break;
            }
        }

        // Step 3: Reverse the elements after the breakpoint
        int start = ind + 1;
        int end = n - 1;
        while (start < end) {
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
    }
}
