class Solution {
    public int findPeakElement(int[] nums) {

// Optimized : Binary Search : O(log n):

int n = nums.length;
int low = 1;
int high = n-2;

if(n==1) return 0;

for(int i =0;i<n;i++) // first and last element
{

    if((i==0 || nums[i]>nums[i-1] ) && (i==n-1 || nums[i]>nums[i+1]))
    {
        return i;
    }
    /*
    if(i==0)
    {
        if(nums[i+1]<nums[i])
        {
            return i;
        }
    }
    else if(i==n-1)
    {
        if(nums[i-1]<nums[i])
        {
            return i;
        }
    }
    */
}
// binary search
          while(low<=high)
            {
                int mid = (low+high)/2;

                if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1])
                {
                    return mid;
                }
                // increasing curve : 
                else if(nums[mid]>nums[mid-1] && nums[mid]<nums[mid+1])
                {
                    low=mid+1;
                }
                else
                {
                    high=mid-1;
                }
            }
    

return -1;
    }
}






// Bruteforce : O(n):
/*
        int n = nums.length;

        for(int i = 0;i<n;i++)
        {
            if((i==0 || nums[i-1]<nums[i]) && (i==n-1 || nums[i] > nums[i+1]))
            {
                return i;
            }
        }
        return -1;

        
    }
}
*/