class Solution {
    public int[] twoSum(int[] nums, int target) {


        // Better Solution : Hashing

        HashMap<Integer,Integer> mpp = new HashMap<>();

        int a[]=new int[2];

        int n = nums.length;

        for(int i = 0;i<n;i++)
        {
            int num = nums[i];

            int moreNeeded = target-num;

            if(mpp.containsKey(moreNeeded))
            {
                a[0]=mpp.get(moreNeeded);
                a[1]=i;
                return a;
            }

            mpp.put(nums[i],i);
        }


        return a;
    }
}