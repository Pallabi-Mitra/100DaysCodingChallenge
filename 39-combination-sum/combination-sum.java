class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {

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

        // take condition :
        al.add(nums[i]);
        sum+=nums[i];
        
        solve(i+1,al,res,sum,nums,target);

        // not take condition :

        sum-=nums[i];
        al.remove(al.size()-1);
        solve(i+1,al,res,sum,nums,target);

    }
}

*/