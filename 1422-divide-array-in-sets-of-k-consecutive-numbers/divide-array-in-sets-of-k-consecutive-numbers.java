class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {


        // Optimal :

// cannot take repeated elements in one set always consecutive per sets:
// in place correction



        Arrays.sort(nums);
        int n = nums.length;
        if(n%k!=0) return false; // array cannot be grouped completely, elements will remain

        

        for(int i = 0;i<n;i++) // check for all array elemnts
        {
           if(nums[i]>0) // if the no is -1 that is already taken in a set
           {
            if(!findNext(nums,k,i,n)) // if returns false cannot form set
            return false;
           
           }
        }

        return true; // if never false encountered, it is true
        
    }

    public boolean findNext(int nums[],int k,int i,int n)
    {
           
           
            int search = nums[i]+1; // consecutive no needs to be searched
            nums[i]=-1; // set the current no as -1 in array
            i+=1; // move to next
            int count = 1; // to track the group size

            while(i < n && count < k) // till group size
            {
                if(nums[i]==search) // if match found
                {
                    search = nums[i]+1; // move to next consecutive element search till group size not formed
                    nums[i]=-1; // set the current as -1
                    count++;
                }
                i++; //  check next element
            }

            if( count!=k) // if all matching consecutive elemnets counting to group size not found
            return false;
            else // group size matching consecutives found
            return true;
    }
}
