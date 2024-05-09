class Solution {
    public int findMin(int[] nums) {


// Optimized Solution : 





      // Bruteforce  :  
        int m = 1000000;
        for (int i : nums) {
            m = Math.min(m, i);
        }
        return m;
        
        
    }
}