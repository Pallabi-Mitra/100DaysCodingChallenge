class Solution {
    public int findMin(int[] nums) {
        
        int m = 1000000;
        for (int i : nums) {
            m = Math.min(m, i);
        }
        return m;
        
    }
}