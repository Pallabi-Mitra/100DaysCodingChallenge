class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {

        
        
        
        
        /*
        
        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> al = new ArrayList<>();

        int nums[]=new int[9];
        for(int i = 0;i<9;i++)
        {
            nums[i]=i+1;
        }

        solve(0,nums,k,n,ans,al);
        return ans;
        
    }

    public void solve(int i,int nums[],int k,int target,List<List<Integer>> ans,List<Integer> al)
    {

        if(k<3) return;
        if(i==nums.length)
        {
            if(target==0)
            {
                ans.add(new ArrayList<>(al));
                return;
            }
        }

       while(i<nums.length && i<k)
        {
            al.add(nums[i]);
            solve(i+1,nums,k,target-nums[i],ans,al);
           
            al.remove(al.size()-1);
            i++;
        }

       


    }
}


*/

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> currentCombination = new ArrayList<>();
        solve(1, k, n, ans, currentCombination);
        return ans;
    }

    // Recursive function to find combinations
    private void solve(int start, int k, int target, List<List<Integer>> ans, List<Integer> currentCombination) {
        // If the combination has the required k numbers
        if (currentCombination.size() == k) {
            // If the sum of the combination is equal to the target
            if (target == 0) {
                ans.add(new ArrayList<>(currentCombination));
            }
            return;
        }

        // Iterate through numbers from start to 9
        for (int i = start; i <= 9; i++) {
            // Early termination if the current number exceeds the target
            if (i > target) {
                break;
            }

            // Add the number to the current combination
            currentCombination.add(i);
            // Recurse with the next number and the reduced target
            solve(i + 1, k, target - i, ans, currentCombination);
            // Backtrack by removing the last added number
            currentCombination.remove(currentCombination.size() - 1);
        }
    }
}