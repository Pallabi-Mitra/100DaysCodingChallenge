
class Solution {
        public boolean canJump(int[] nums) {

            int maxIndex = 0;

            int n = nums.length;

            for(int i=0;i<n;i++)
            {
                if(i > maxIndex) return false;

                maxIndex = Math.max(maxIndex, nums[i]+i);

                if(maxIndex >=n)
                    break;


            }

            return true;

        }
}

/*

class Solution {
    


public boolean canJump(int[] nums) {
    // Initialize the last index as the last position
    int lastGoodIndex = nums.length - 1;

    // Traverse from the second last index to the first index
    for (int i = nums.length - 2; i >= 0; i--) {
        // Check if the current index can reach the last good index
        if (i + nums[i] >= lastGoodIndex) {
            lastGoodIndex = i; // Update the last good index
        }
    }

    // If we can reach the start index, return true
    return lastGoodIndex == 0;
}
}

*/


