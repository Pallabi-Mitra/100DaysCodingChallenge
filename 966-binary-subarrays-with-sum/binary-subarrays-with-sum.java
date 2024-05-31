class Solution {
    public int numSubarraysWithSum(int[] nums, int S) {

// Sliding Window :

/*
    return atMost(nums, S) - atMost(nums, S - 1);
}

private int atMost(int[] nums, int S) {
    if (S < 0) return 0;
    int count = 0;
    int left = 0, sum = 0;
    for (int right = 0; right < nums.length; right++) {
        sum += nums[right]; // Expand the window
        while (sum > S) {
            sum -= nums[left++]; // Shrink the window
        }
        count += right - left + 1; // Number of subarrays ending at 'right'
    }
    return count; // Return the count of subarrays with sum at most S
}
}
*/

// Initialize count of subarrays with sum at most S
    int count = 0;
    
    // Initialize pointers and sums for S and S - 1
    int left1 = 0, sum1 = 0; // Pointers and sum for S
    int left2 = 0, sum2 = 0; // Pointers and sum for S - 1

    // Iterate through the array using the right pointer
    for (int right = 0; right < nums.length; right++) {
        // Update sum1 and sum2 by adding the current element
        sum1 += nums[right];
        sum2 += nums[right];

        // Shrink the window for S until the sum is less than or equal to S
        while (sum1 > S) {
            sum1 -= nums[left1++];
        }

        // Shrink the window for S - 1 until the sum is less than S
        while (left2 <= right && sum2 >= S) {
            sum2 -= nums[left2++];
        }

        // Add the count of subarrays with sum exactly equal to S
        count += left2 - left1;
    }

    // Return the total count of subarrays with sum exactly equal to S
    return count;
}
}

  // Hashing : 

  /*
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
  */
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