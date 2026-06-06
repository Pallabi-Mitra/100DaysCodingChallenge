class Solution {
    public boolean containsDuplicate(int[] nums) {

        /*
        

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
*/
// Using HashMap and keeping counts

    HashMap<Integer,Integer> countMap = new HashMap<>();

    for(int num : nums)
    {
        int count = countMap.getOrDefault(num,0)+1;

        if(count > 1)
            return true;
    
    

    countMap.put(num,count);
    }

    return false;

        
    }
}