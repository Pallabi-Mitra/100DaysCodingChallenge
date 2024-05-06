class Solution {
    public int search(int[] nums, int target) {

/* Iterative :

        int n = nums.length;
        int low = 0;
        int high = n-1;
       

       while(low<=high)
        {
                 int mid = (low+high)/2;

                 if(target == nums[mid]) return mid;
                 else if(target<nums[mid]) high = mid-1;
                 else
                 low = mid+1;

        }

        return -1;
      */

   //  Recursive : 

   return binarySearch(nums,0,nums.length-1,target); // arr, low, high, target


    }

        public int binarySearch(int nums[],int low,int high,int target)
        {
            if(low>high) return -1;
            int mid = (low+high)/2;
            if(nums[mid]==target) return mid;
            else if(target>nums[mid])
           return binarySearch(nums,mid+1,high,target);
            else
            return binarySearch(nums,0,mid-1,target);

        }

}