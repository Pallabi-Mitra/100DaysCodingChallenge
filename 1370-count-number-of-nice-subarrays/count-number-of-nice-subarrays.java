class Solution {
    public int numberOfSubarrays(int[] nums, int k) {


// Sliding Window :

/*
 int n = nums.length;
        int subarray = 0;
        int count = 0;
        int right = 0;
        int left = 0;

        while(right < n)
        {
            if(nums[right]%2!=0)
            {
                count ++;
            }

            if(count > k)
            {
                if(nums[left]%2!=0)
                {
                    count--;
                }
                left++;
            }

            if(count ==k)
            subarray++;

            right++;
        }

return subarray;
    }
}
*/
// Hashing :

/*

    HashMap<Integer,Integer> mpp = new HashMap<>();
    mpp.put(0,1);
    int oddCount = 0;
    int result = 0;


    for(int num : nums)
    {
        // if odd number increase the odd count
        if(num%2!=0)
        oddCount++;

        int needed = oddCount - k;
// if the required is present in map, the value will be the no of subarrays,
// because the freq stored is that many times the no is present in array, so can form desired subarray
     
       // Check if there is a subarray (ending here) with k odd numbers
        if(mpp.containsKey(needed))
        {
           result+= mpp.get(needed);
        }


// Update the hash map with the current count of odd numbers
        mpp.put(oddCount,mpp.getOrDefault(oddCount,0)+1);

    }

return result;
    }
}

*/




        // Sliding Window :
        // Consider all even number as 0, and odd number as 1
        // Same as finding the sum in the problem Binary subarrays with sum



       
    return atMost(nums, k) - atMost(nums, k - 1);
}

// if odd number  : num %2 == 1
// if even number : num %2 ==0
 // it acts same as the binary array
 // we can find sum of the odd numbers each 1 to match with k no of odd numbers
private int atMost(int[] nums, int k) {
    if (k < 0) return 0;
    int count = 0;
    int left = 0, sum = 0;
    for (int right = 0; right < nums.length; right++) {
        sum += nums[right]%2; // odd number sum
        while (sum > k) {
            sum -= nums[left++]%2; // Shrink the window
        }
        count += right - left + 1; // Number of subarrays ending at 'right'
    }
    return count; // Return the count of subarrays with sum at most S
}
}











        //Bruteforce : TLE
/*
        int n = nums.length;
           
            int subarray=0;
    
            for(int i =0;i<n;i++)
            {
                int count = 0;
                for(int j=i;j<n;j++)
                {
                   if(nums[j]%2!=0)
                    {
                        count++;
                    }
                    if(count==k)
                    {
                        subarray++;
                        //break;
                    }
    
                }
               
            }
    
    return subarray;
    }
}
 */   

 