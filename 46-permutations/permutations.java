class Solution {
    public List<List<Integer>> permute(int[] nums) {

// Without extra space :
// in place permutation set generation with each recursive call


    List<List<Integer>> ans = new ArrayList<>();// store all permutations
    recurPermute(0,nums,ans);
    return ans;
    }


    private void recurPermute(int index, int nums[],List<List<Integer>> ans)
    {
        // base case : when reach end
        if(index == nums.length) // permutation is stored in nums array
        {
            List<Integer> al = new ArrayList<>(); // cretaing new list everytime a set is formed

            for(int i =0;i<nums.length;i++) 
            {
                al.add(nums[i]); // taking all array elements to list, this is a permutation set
            }
// adding the list to ans set to store
            ans.add(new ArrayList<>(al));
            return;
        }

        // still elements : keep calling the recursion
        // to swap everything from index to n-1

        for(int i = index;i<nums.length;i++)
        {
            swap(i,index,nums); // swap with the element itself 

            recurPermute(index+1,nums,ans); // calling the function recursively to keep swapping

// Backtrack : when come back from recursion,
//re swap it to make the elements in same place
            swap(i,index,nums);

        }

    }


    private void swap(int i,int j,int nums[])
    {
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}





// Using Hashing : to track elements : Boolean Array

/*
        // Initialize the result list to store all permutations
        List<List<Integer>> ans = new ArrayList<>();
        // List to store the current permutation
        List<Integer> al = new ArrayList<>();
        // Length of the input array
        int n = nums.length;
        // Boolean array to track the elements that are already included in the current permutation
        boolean hash[] = new boolean[n];

        // Call the recursive function to generate permutations
        solve(nums, ans, al, hash);

        // Return the result
        return ans;
    }

    public void solve(int nums[], List<List<Integer>> ans, List<Integer> al, boolean hash[]) {
        int n = nums.length;
        // If the current permutation size equals the array length, we have a complete permutation
        if (al.size() == n) {
            ans.add(new ArrayList<>(al)); // Add a copy of the current permutation to the result
            return; // Backtrack
        }

        // Try each number in the array
        for (int i = 0; i < n; i++) {
            // If the number at index i is not already in the current permutation
            if (!hash[i]) {
                hash[i] = true; // Mark the number as used
                al.add(nums[i]); // Add the number to the current permutation
                // Recurse to continue building the permutation
                solve(nums, ans, al, hash);
                // Backtrack: remove the last number added and unmark it
                al.remove(al.size() - 1);
                hash[i] = false;
            }
        }
    }
}

*/