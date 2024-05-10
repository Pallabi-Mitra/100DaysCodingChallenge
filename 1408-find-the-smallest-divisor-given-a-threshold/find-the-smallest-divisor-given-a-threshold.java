class Solution {


    public int findSum(int [] nums, int mid)
    {
        int total = 0;
        for(int i = 0;i<nums.length;i++)
        {
            total+=Math.ceil((double)nums[i]/(double)mid);

        }
        return total;
    }
    public int smallestDivisor(int[] nums, int threshold) {



        int n = nums.length;

        int maxi = Integer.MIN_VALUE;
        int mini = Integer.MAX_VALUE;

        for(int i = 0;i<n ;i++)
        {
            maxi = Math.max(maxi,nums[i]);
            mini= Math.min(mini,nums[i]);
        }

        int low = 1;
        int high = maxi;
        int ans =-1;

        while(low<=high)
        {
            int mid=(low+high)/2;

           int res = findSum(nums,mid);

            if(res<=threshold)
            {
                ans = mid;
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
return ans;
    }
}


