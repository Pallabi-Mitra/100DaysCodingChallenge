class Solution {
    public int maximumDifference(int[] nums) {

        int n=nums.length;
        int ans =-1;
        int max=nums[n-1];

        for(int i=n-2;i>=0;i--)
        {
            max=Math.max(max,nums[i]);
            if(max <= nums[i]) continue;
            int diff = max-nums[i];
            ans = Math.max(ans,diff);
                    
            }

            return ans;
        


/*
        int n = nums.length;
        int diff=-1;
        //int res=0;

        for(int i =0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(nums[i]<nums[j])
                {
                    diff= Math.max(nums[j]-nums[i],diff);
                }
            }
           
        }

        return diff;
        */
    }
}