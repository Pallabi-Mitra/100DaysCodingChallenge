class Solution {
    public int findMin(int[] nums) {

        int n = nums.length;  // 5
        int left = 0;
        int right = n-1; // 4
        int min = 5001;
        while(left<=right){
            int mid = left + (right-left)/2; //2
            if(nums[mid]==nums[left]){
                min = Math.min(min,nums[left]);
                left++;
            }
            else if(nums[mid]==nums[right]){
                min = Math.min(min,nums[right]);
                right--;
            }
            else if(nums[mid]>nums[left]){
                min = Math.min(min,nums[left]);
                left = mid+1;
            }
            else{
                min = Math.min(min,nums[mid]);
                right = mid-1;
            }
        }
        return min;
    }
}

// Optimized Solution : 
/*

int n = nums.length;
int low = 0;
int high = n-1;
int ans = Integer.MAX_VALUE;
if(n==1)
return nums[0];
if(n==2 && nums[0]==nums[1])
return nums[0];

while(low<=high)
{
    int mid = (low+high)/2;

    if(nums[low]==nums[mid] && nums[mid]==nums[high])
    {
        low=low+1;
        high=high-1;
        continue;
    }

   if(nums[low]<=nums[mid])
   {
    ans = Math.min(ans,nums[low]);
    low=mid+1;
   }
   else
   {
    ans=Math.min(ans,nums[mid]);
    high=mid-1;
   }
}
return ans;

      
    }
}

*/
/*
public int findMin(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n-1;
        int min = 5001;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid]>=nums[left]){
                min = Math.min(min,nums[left]);
                left = mid+1;
            }
            else{
                min = Math.min(min,nums[mid]);
                right = mid-1;
            }
        }
        return min;
    }
}


*/










