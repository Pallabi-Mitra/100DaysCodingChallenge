class Solution {
    public int longestOnes(int[] nums, int k) {

        int zeroes = 0;
            int right = 0;
            int left = 0;
            int maxlen = 0;
            int n = nums.length;
    
           while(right<n)
            {
                if(nums[right]==0)
                zeroes ++;
    
                while(zeroes > k)
                {
                       
                            if(nums[left]==0)
                            {
                                zeroes--;
                            }
                             left++;
                        
                }
               
                maxlen = Math.max(maxlen,right-left+1);
                 right++;
            }
            return maxlen;
    }
}