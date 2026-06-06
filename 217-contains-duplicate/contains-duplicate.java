class Solution {
    public boolean containsDuplicate(int[] nums) {

        int count = 0;
        //HashMap<Integer,Integer> mpp = new HashMap<>();

        HashSet<Integer> st = new HashSet<>();
        int n = nums.length;

        for(int i=0; i<n;i++)
        {
            st.add(nums[i]);


        }


        if(st.size()<n)
            return true;

        else
        return false;
        
    }
}