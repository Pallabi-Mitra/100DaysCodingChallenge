class Solution {
    public boolean containsDuplicate(int[] nums) {

        int n = nums.length;
/*
        for(int i = 0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(nums[i]==nums[j])
                {
                    return true;
                }
            }
        }
        return false;
    */

    HashSet<Integer> st = new HashSet<>();

    for(int i = 0;i<n;i++)
    {
        st.add(nums[i]);
    }    

    if(st.size()<n)
    {
            return true;
    }
    else
    {
        return false;
    }
    }
}