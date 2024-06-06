class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
/*
    List<List<Integer>> ans = new ArrayList<>();
    ArrayList<Integer> al = new ArrayList<>();
    findCombinations(0,nums,target,ans,al);
    return ans;
    }


    public void findCombinations(int i, int nums[],int target,List<List<Integer>> ans,
                                    ArrayList<Integer> al)
    {
        if(i==nums.length)
        {
           if(target==0){
            ans.add(new ArrayList<>(al));
            }
        
            return;
        }
    

    if(nums[i]<=target) // &&nums[i]!=0 ---> to avoid 0 for infinite loop
    {
        // pick condition : take current index

        al.add(nums[i]);
        findCombinations(i,nums,target-nums[i],ans,al);

        // remove if not found 

        al.remove(al.size()-1);

    }

    // not pick current index : check next index
    // not picking anything so target doesnt change
    findCombinations(i+1,nums,target,ans,al);


    }
}

*/


// One set : not considering same elements twice 
/*
        ArrayList<Integer> al = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        solve(0,al,res,0,nums,target);
        return res;
        
    }


    public void solve(int i,ArrayList<Integer> al,List<List<Integer>> res,int sum,int nums[],int target)
    {
        //base condition :

        if(i==nums.length)
        {
            if(sum==target)
            {
                res.add(new ArrayList<>(al));
            }

            return;
        }

        if(nums[i]<=target)
        {
                // take condition :
        al.add(nums[i]);
        sum+=nums[i];
        
        solve(i,al,res,sum,nums,target);

        // not take condition :

        sum-=nums[i];
        al.remove(al.size()-1);
        solve(i+1,al,res,sum,nums,target);
        }

        

    }
}

*/
// Create a list to store the current combination
        ArrayList<Integer> currentCombination = new ArrayList<>();
        // Create a list to store all the valid combinations
        List<List<Integer>> result = new ArrayList<>();
        
        // Start the recursive process
        solve(0, currentCombination, result, 0, nums, target);
        
        // Return the result
        return result;
    }

    // Recursive function to find combinations
    public void solve(int index, ArrayList<Integer> currentCombination, List<List<Integer>> result, int currentSum, int[] nums, int target) {
        // Base condition: if the current sum equals the target, add the combination to the result
        if (currentSum == target) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }

        // If the current sum exceeds the target or if the index is out of bounds, return
        if (currentSum > target || index == nums.length) {
            return;
        }

        // Include the current number in the combination
        currentCombination.add(nums[index]);
        // Recursively call the function with the same index to allow repeated numbers
        solve(index, currentCombination, result, currentSum + nums[index], nums, target);
        
        // Backtrack: remove the current number from the combination
        currentCombination.remove(currentCombination.size() - 1);
        
        // Move to the next number
        solve(index + 1, currentCombination, result, currentSum, nums, target);
    }
}