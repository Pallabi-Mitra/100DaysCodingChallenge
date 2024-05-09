class Solution {
    public int search(int[] nums, int target) {

        int n = nums.length;
        int low= 0;
        int high = n-1;

        while(low<=high)
        {
            int mid = (low+high)/2;

            if(nums[mid]==target)
            {
                return mid;
            }

            // identify the sorted half :
            //either left half sorted / right half sorted

            // left - half sorted :

            if(nums[low]<= nums[mid]) // if sorted we look in left side to get target
                                    
            {
                if(nums[low]<= target && target<=nums[mid])// target lies within left half
                {
                    high = mid-1; // eliminate right half
                }
                else
                {
                    low=mid+1; // it doesnt lie on left side so eliminate it and look right
                }
            }

            // right - half sorted :
            else
            {
                if(nums[mid]<=target && target <= nums[high])//target lies within right half
                    {
                            low=mid+1; //eliminate left half
                    }
                else
                {
                high = mid-1; //it doesnt lie on right side so eliminate it and look left
                }
            }
        }
        return -1; // if element not found.
        
    }
}