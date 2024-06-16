class Solution {
    public int minPatches(int[] nums, int n) {
   long covered = 0; // maximum sum that can be formed
    int patches = 0;
    int index = 0;
    
    while (covered < n) {
        if (index < nums.length && nums[index] <= covered + 1) {
            covered += nums[index++];
        } else {
            patches++;
            covered = covered * 2 + 1; // patch and extend the covered range
        }
    }
    
    return patches;
        
    }
}