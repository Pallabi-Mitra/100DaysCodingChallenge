class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {

 return subarrayWithMostKDistinct(nums,k) - subarrayWithMostKDistinct(nums,k-1) ; 

    }

public int subarrayWithMostKDistinct(int[] nums, int k) {
// Optimized : HashMap, Sliding Window, 2 pointers

int n = nums.length;
int count = 0;
int right = 0;
int left = 0;
HashMap<Integer,Integer> mpp = new HashMap<>();

    while(right < n)
    {

        mpp.put(nums[right],mpp.getOrDefault(nums[right],0)+1);

       

        while(mpp.size()>k)
        {

            mpp.put(nums[left],mpp.get(nums[left])-1);

            if(mpp.get(nums[left])==0)
            {
                mpp.remove(nums[left]);
            }
            left++;
        }

        //if(mpp.size()<=k)
          //  count++;
// if larger subarray is valid, all sub parts will be valid too
// if segment is valid calculate the subarrays count
//if(mpp.size()<=k){
          count += right - left + 1;

        

        right++;
    }


    return count;
}
        
}



// bruteforce :
/*

int n = nums.length;
int count = 0;

    for(int i = 0;i< n ;i++)
    {
        HashMap<Integer,Integer> mpp = new HashMap<>();

        for(int j =i ;j<n;j++)
        {
            mpp.put(nums[j], mpp.getOrDefault(nums[j],0)+1);

            if(mpp.size()==k)
            {
                count++;
            }
            else if ( mpp.size() > k)
            break;
        }
    }
    return count;
    }
}

*/