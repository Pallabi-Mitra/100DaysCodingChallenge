class Solution {
    public int maximumDifference(int[] nums) {


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
    }
}