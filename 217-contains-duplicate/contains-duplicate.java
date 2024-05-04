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
// HashSet :
/*
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
    */

    // Hashset approach 1 :

    HashSet<Integer> seen = new HashSet<>();
    for(int num : nums)
    {
        if(seen.contains(num))
        {
            return true;
        }

        seen.add(num);
    }
    return false;
    }
}