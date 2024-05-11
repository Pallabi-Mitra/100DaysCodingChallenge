class Solution {

    public int calculatePossible(int [] nums, int mid)
    {
        int count = 1; 
        int total = 0;

        for(int i = 0;i< nums.length;i++)
        {
            if(total + nums[i]<=mid)
            {
                total+=nums[i];
            }
            else
            {
                count++;
                total=nums[i];
            }
        }
        return count;
    }
    
    
        public int splitArray(int[] nums, int k) {

        int n = nums.length;

        int mini = Integer.MIN_VALUE;
        int summ=0;
        for(int i = 0;i<n;i++)
        {
            mini = Math.max(mini,nums[i]);
            summ+=nums[i];
        }

        int low= mini;
        int high = summ;
        int ans = -1;

        while(low<=high)
        {
            int mid = (low+high)/2;

            int res= calculatePossible(nums,mid);

            if(res > k)
            {
                low=mid+1;
            }
            else
            {
                // ans = mid;
                    high = mid-1;
            }


        }

       // return ans;
       return low;

        
    }
}