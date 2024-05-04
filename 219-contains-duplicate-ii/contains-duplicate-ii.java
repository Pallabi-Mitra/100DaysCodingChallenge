class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {


        HashMap<Integer,Integer> mpp = new HashMap<>();
        int n = nums.length;

        for(int i = 0;i<n;i++)
        {
            if(mpp.containsKey(nums[i]))
            {
                if(i-mpp.get(nums[i]) <=k)
                {
                    return true;
                }
            }
            mpp.put(nums[i],i);
        }

return false;








/* TLE
        for(int i = 0;i<n;i++)
        {
            for(int j =i+1;j<n;j++)
            {
                if(nums[i]==nums[j] && Math.abs(i-j)<=k)
                {
                    return true;
                }
            }
        }
        return false;
        */
    }
}