class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> al = new ArrayList<>();

        int n =nums.length;
        boolean hash[]=new boolean[n];
        
        solve(nums,ans,al,hash);

        return ans;
        
    }

    public void solve(int nums[],List<List<Integer>> ans, List<Integer> al, boolean hash[] )
    {
        int n =nums.length;
        if(al.size()==n)
        {
            ans.add(new ArrayList<>(al));
            return;
        }
        
        for(int i = 0; i < n;i++)
        {
            if(!hash[i])
            {
                hash[i]=true;
                al.add(nums[i]);
                solve(nums,ans,al,hash);

                // backtrack 
                al.remove(al.size()-1);
                hash[i]= false;

            }
        }
        
       
    }
}
   