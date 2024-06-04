class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        // Define the actual recursive function method :
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> al = new ArrayList<>();
       

        solve(0,al,res,nums);
        return res;
    }

    public void solve(int i,ArrayList<Integer> al,List<List<Integer>> res,int nums[])

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

