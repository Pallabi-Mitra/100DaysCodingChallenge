class Solution {

 public int subarraySum(int[] nums, int k) {
  

  // For both negative & positive :
   int sum = 0;
        int ans = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int j=0;j<nums.length;j++){
            sum += nums[j];
            if(map.containsKey(sum -k)){
                ans += map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return ans;
    }
}
  // To count for positive arrays : //
  /* 
  
    int i=0,j=0;
        int n = nums.length;
        long sum=0;
        int len=0;
        int c =0;

       for(i=0;i<n;i++)
        {
            
            sum+=nums[i];

            while(sum>k && i!=0)
            {
                sum-=nums[j];
                j++;
               
            }
            if(sum==k)
            {
                //len=Math.max(len,i-j+1);
               
                c ++;
            }
        }

            return c;
}
}
*/
/*
   
        
*/
/*
        int n = arr.length; // size of the given array.
        Map mpp = new HashMap();
        int preSum = 0, cnt = 0;

        mpp.put(0, 1); // Setting 0 in the map.
        for (int i = 0; i < n; i++) {
            // add current element to prefix Sum:
            preSum += arr[i];

            // Calculate x-k:
            int remove = preSum - k;

            // Add the number of subarrays to be removed:
            cnt += mpp.getOrDefault(remove, 0);

            // Update the count of prefix sum
            // in the map.
            mpp.put(preSum, mpp.getOrDefault(preSum, 0) + 1);
        }
        return cnt;
        */
//Optimal Solution : Prefix sum : O(N)

/*
int n = nums.length;
int c=0;
int sum=0;

HashMap<Integer,Integer> mpp = new HashMap<>();
mpp.put(0,1);
for(int i = 0;i<n;i++)
{

    sum+=nums[i];

    int rem = sum-k;

    c += mpp.getOrDefault(rem, 0);
    mpp.put(sum,c);

}

    return c;
*/
//bruteforce : O(N2)
/*
        int n = nums.length;

        int c=0;
        //int sum=0;
        for(int i=0;i<n;i++)
        {
            int sum=0;
            for(int j=i;j<n;j++)
            {
                    sum=sum+nums[j];
                    
                    if(sum==k)
                    {
                        c++;
                    }
            }
            


        }

        return c;
       */ 
 