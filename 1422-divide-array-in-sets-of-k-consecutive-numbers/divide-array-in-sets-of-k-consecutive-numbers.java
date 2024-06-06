class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {


        // Optimal :

// cannot take repeated elements :



        Arrays.sort(nums);
        int n = nums.length;
        if(n%k!=0) return false; // array cannot be grouped completely, elements will remain

        

        for(int i = 0;i<n;i++)
        {
           if(nums[i]>0)
           {
            if(!findNext(nums,k,i,n))
            return false;
           
           }
        }

        return true;
        
    }

    public boolean findNext(int nums[],int k,int i,int n)
    {
           
           
            int search = nums[i]+1; // consecutive no needs to be searched
            nums[i]=-1;
            i+=1;
            int count = 1;

            while(i < n && count < k)
            {
                if(nums[i]==search)
                {
                    search = nums[i]+1;
                    nums[i]=-1;
                    count++;
                }
                i++;
            }

            if( count!=k) // matching consecutive elemnets not found
            return false;
            else
            return true;
    }
}
