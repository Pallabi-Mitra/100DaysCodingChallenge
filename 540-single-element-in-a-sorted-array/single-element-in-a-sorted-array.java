class Solution {
    public int singleNonDuplicate(int[] nums) {

        
       
// Optimized : Binary Search : O(log n):
int n= nums.length;

if(n==1) return nums[0];
if(nums[0]!=nums[1]) return nums[0];
if(nums[n-1]!=nums[n-2]) return nums[n-1];

int low = 1;
int high = n-2;

    while(low<=high)
    {
        int mid =(low+high)/2;

        if(nums[mid]!=nums[mid+1] && nums[mid]!=nums[mid-1]) // if mid is not same with
         //either left or right then it is the single element
        {
            return nums[mid];
        }

        // elimination part : 

        if((mid%2==1 && nums[mid-1] == nums[mid]) || (mid%2==0 && nums[mid]==nums[mid+1]))
        {
            low=mid+1; // eliminate left half
        }
        else
        {
            high = mid-1; // eliminate right half;
        }

    }
    return -1;
    }
}


// Bruteforce : O(n):
/*

        if(n==1)
        {
            return nums[0];
        }
        else
        {
            for(int i = 0;i<n;i++)
            {
                if(i==0)
                {
                    if(nums[i]!=nums[i+1]) return nums[i];
                }
                else if(i==n-1)
                {
                    if(nums[i]!=nums[i-1]) return nums[i];
                }
                else
                {
                    if(nums[i]!=nums[i+1] && nums[i]!=nums[i-1]) // either left or right 
                    //should not have the element
                    {
                        return nums[i];
                    }
                }
            }
        }
        return -1;
        
    }
}
*/