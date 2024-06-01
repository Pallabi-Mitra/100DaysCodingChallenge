class Solution {
    public int numberOfSubarrays(int[] nums, int k) {

// Hashing :



    HashMap<Integer,Integer> mpp = new HashMap<>();
    mpp.put(0,1);
    int oddCount = 0;
    int result = 0;


    for(int num : nums)
    {
        if(num%2!=0)
        oddCount++;

        int needed = oddCount - k;

        if(mpp.containsKey(needed))
        {
           result+= mpp.get(needed);
        }



        mpp.put(oddCount,mpp.getOrDefault(oddCount,0)+1);

    }

return result;
    }
}















        // Sliding Window :
        // Consider all even number as 0, and odd number as 1
        // Same as finding the sum in the problem Binary subarrays with sum

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

 