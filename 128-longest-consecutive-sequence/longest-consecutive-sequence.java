class Solution {
    public int longestConsecutive(int[] nums) {

        int n = nums.length;
        Arrays.sort(nums);
        int len=1;
        int count=0;
        int last_small=Integer.MIN_VALUE;
        if (n == 0) return 0;

        for(int i = 0;i<n;i++)
        {
            if(nums[i]-last_small==1)
            {
                last_small=nums[i];
                count++;
                
                
            }
            else if(nums[i]!=last_small)
            {
                last_small=nums[i];
                count=1;
               

            }

             len=Math.max(len,count);
        }

       

        return len;






/* 
        Arrays.sort(nums);

        int n = nums.length;
        int len=0;
        
        int final_len=0;
        for(int i =0;i<n;i++)
        {
         for(int j =i+1;j<n;j++)
            {
                    if(nums[j]-nums[j-1]==1)
                    {
                        len=j-i+1;
                    }
                    else
                    {
                        break;
                    }
            }

            final_len=Math.max(final_len,len);
            
        }
return final_len;
        */
    }
}