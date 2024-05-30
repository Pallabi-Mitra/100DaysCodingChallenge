class Solution {
    public int longestOnes(int[] nums, int k) {


// Sliding Window Optimized  : 


    int n = nums.length;

    int left = 0;
    int right = 0;
    int zeroes = 0;
    int maxlen = 0;

    while(right< n)
    {
        if(nums[right]==0)
        {
            zeroes++;

        }

        if(zeroes > k)
        {
            if(nums[left]==0)
            {
                zeroes --;
            }
            left++;
        }
        if(zeroes <=k)
        maxlen = Math.max(maxlen,right-left+1);
        right++;
    }

return maxlen;
    }
}





// Sliding Window  : 
/*
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
            */


            // Bruteforce :
            /*
            int n = nums.length;
            int maxlen = 0;
            

            for(int i = 0;i<n;i++)
            {
                int zeroes = 0;
                for(int j = i;j<n;j++)
                {
                    if(nums[j]==0)
                    zeroes ++;

                    if(zeroes > k)
                    break;
                
                maxlen = Math.max(maxlen,j-i+1);
                }
                
            }
            return maxlen;
            */

 