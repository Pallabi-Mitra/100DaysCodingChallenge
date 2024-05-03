class Solution {
    public int[] findErrorNums(int[] nums) {


// Optimized : Hashing :

        int n = nums.length;
        int hash[]=new int[n+1];
        int ans[]=new int[2];
/*
        for(int i = 0;i<=n;i++)
        {
                hash[i]=0;
        }
*/
        for(int i=0;i<n;i++)
        {
            hash[nums[i]]++;
        }

        for(int i =1;i<=n;i++)
        {
            if(hash[i]==2)
            {
                ans[0]=i;
            }
            if(hash[i]==0)
            {
                ans[1]=i;
            }
        }

return ans;




      // Brute Force : O(n^2) :
/*
        int n = nums.length;
        int repeating = -1;
        int missing = -1;
        int c;
        int i,j;
        int ans []=new int[2];

        for( i = 1;i<=n;i++)
        {
            c=0;
            for( j=0;j<n;j++)
            {
                if(nums[j]==i)
                {
                    c++;
                    
                }


            }
            
                if(c==0)
                {
                    missing = i;
                }
                else if(c>=2)
                {
                    repeating = i;
                }

                if(missing!=-1 && repeating !=-1)
                {
                    break;
                }
            
        }

        ans[0]=repeating;
        ans[1]=missing;
        return ans;
*/
        // My Hashing Method : 
        /*
        int n = nums.length;
        int i,j,k=0;
        int lost=0;
        int count=0;
        int ans[]=new int[2];
        int seen=0;
        //HashSet<Integer> st = new HashSet<>();
        HashMap<Integer,Integer> mpp = new HashMap<Integer,Integer>();

        for(i=1;i<=n;i++)
        {
                mpp.put(i,k);
                k++;
        }


        for(i=0;i<n;i++)
        {
            
            if(nums[i]!=mpp.getKey(i))
            {
                lost=mpp.getKey(i);
                ans[0]=lost;
            }
            

        }
             seen=nums[0];
        for(i=1;i<n;i++)
        {
           if(nums[i]==seen)
            {
                count=count+1;
                ans[1]=nums[i];
            }
            seen = nums[i];
        }
        

return ans;
        
*/

    }
}