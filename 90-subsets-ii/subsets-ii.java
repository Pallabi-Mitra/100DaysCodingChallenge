class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {


       Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> al = new ArrayList<>();
        findSubsets(0,nums,al,ans);
        return ans;
    }

    public void findSubsets(int index, int nums[],List<Integer> al, List<List<Integer>> ans)
    {
            ans.add(new ArrayList<>(al));

            for(int i = index;i<nums.length;i++)
            {
                if(i!=index && nums[i] == nums[i-1]) continue;
                al.add(nums[i]);
                findSubsets(i+1,nums,al,ans);
                al.remove(al.size()-1);
            }
    }
}








/*

       // Define the actual recursive function method :
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();
        
        ArrayList<Integer> al = new ArrayList<>();
       

        solve(0,al,res,nums);
        List<List<Integer>> ans = new ArrayList<>(res);
        return ans;
    }

    public void solve(int i,ArrayList<Integer> al,Set<List<Integer>> res,int nums[])

    {
            //base condition :
            if(i==nums.length)
            {
                res.add(new ArrayList<>(al));
                return;
            }

            // take condition :

            al.add(nums[i]);
            solve(i+1,al,res,nums);


            // not take condition :
            al.remove(al.size()-1);

            solve(i+1,al,res,nums);
    }  
    
}

*/