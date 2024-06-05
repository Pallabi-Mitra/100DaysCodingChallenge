class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> al = new ArrayList<>();

        Arrays.sort(nums);

        findCombinations(0,nums,target,ans,al);
        return ans;

    }


    public void findCombinations(int index,int nums[],int target,List<List<Integer>> ans,List<Integer> al)
    {
        // base condition :

        if(target == 0)
        {
            ans.add(new ArrayList<>(al));
            return;
        }

        for(int i= index;i<nums.length;i++)
        {
            if(i > index && nums[i]==nums[i-1]) continue; // dont consider consecutives
            if(nums[i]>target)break;

            al.add(nums[i]);
            findCombinations(i+1,nums,target-nums[i],ans,al);
            al.remove(al.size()-1);

        }
    }

    
}











 // Combination Sum I :

 /*     
    //List<List<Integer>> ans = new ArrayList<>();
    Set<List<Integer>> ans = new HashSet<>();
    ArrayList<Integer> al = new ArrayList<>();
    Arrays.sort(nums);
    findCombinations(0,nums,target,ans,al);
    List<List<Integer>> result = new ArrayList<>(ans);
    return result;
    }


    public void findCombinations(int i, int nums[],int target,Set<List<Integer>> ans,
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
        findCombinations(i+1,nums,target-nums[i],ans,al);

        // remove if not found 

        al.remove(al.size()-1);

    }

    // not pick current index : check next index
    // not picking anything so target doesnt change
    findCombinations(i+1,nums,target,ans,al);


    }
}  

*/