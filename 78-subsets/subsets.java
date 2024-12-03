class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        // Bit manipulation - better than recursion due to less SC

        int n = nums.length;
        int subsets = 1<<n;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0;i<subsets;i++)
        {
            List<Integer> al = new ArrayList<>();
            for(int j=0;j<n;j++)
            {
                // check ith bit set or not
                if( (i & (1<<j)) !=0) // 1
                    al.add(nums[j]);
            }

            ans.add(al);
        }

        return ans;
        
    }
}