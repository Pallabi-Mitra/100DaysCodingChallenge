class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {

  // Hashing : 
/*
  HashMap<Integer,Integer> mpp = new HashMap<>();
  int n = nums.length;
  int sum = 0;
  int count =0;

  for(int i = 0;i<n ; i++)
  {
       sum += nums[i];

       int reqd = goal-sum;

       if(mpp.containsKey(reqd))
       {
            count ++;
       }

       mpp.put(sum,i);
  }
  
  return count;
    }
}
  
  */
  
  
 // Initialize a hashmap to store the frequency of prefix sums
    HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
    // Initialize the count of subarrays with sum equal to goal
    int count = 0;
    // Initialize the running prefix sum
    int sum = 0;
    // Base case: prefix sum 0 occurs once before we start
    prefixSumCount.put(0, 1);

    // Iterate through each number in the array
    for (int num : nums) {
        // Update the running prefix sum
        sum += num;
        // Calculate the required prefix sum that would make the current subarray sum to the goal
        int reqd = sum - goal;
        // If the required prefix sum exists in the hashmap, increment the count by its frequency
        if (prefixSumCount.containsKey(reqd)) {
            count += prefixSumCount.get(reqd);
        }
        // Update the hashmap with the current prefix sum
        prefixSumCount.put(sum, prefixSumCount.getOrDefault(sum, 0) + 1);
    }
    
    // Return the total count of subarrays with sum equal to the goal
    return count;
    }
}
  
        // Bruteforce : O(n^2):
        /*

        int n = nums.length;
        int count = 0;

        for(int i = 0;i<n;i++)
        {
            int sum = 0;
            for(int j =i;j<n;j++)
            {
                sum+=nums[j];

                if(sum==goal)
                count++;
                if(sum>goal)break;
            }
        }

return count;
        
    }
}

*/